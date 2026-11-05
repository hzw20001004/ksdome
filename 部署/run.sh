#!/bin/bash
set -u
APP_NAME="ruoyi-admin.jar"
DEPLOY_DIR="/home/dining"
NEW_JAR_DIR="/home/dining/newjar"
PORT=8555
PROFILE="nei"                      # 显式钉死, 防 jar 内 active 配置漂移(7158559 同源坑)
JAVA_BIN="${JAVA_HOME:-/usr}/bin/java"
LOG="$DEPLOY_DIR/app_$(date +%Y%m%d_%H%M%S).log"

echo "=== 应用更新与重启 ==="

# 1) 优雅停机: 先 SIGTERM, 20s 不退再 -9
PID=$(pgrep -f "${APP_NAME}" || true)
if [ -n "$PID" ]; then
    echo "运行中 PID=$PID, 优雅关闭..."
    kill $PID
    for i in $(seq 1 20); do kill -0 $PID 2>/dev/null || break; sleep 1; done
    kill -0 $PID 2>/dev/null && { echo "超时, 强杀"; kill -9 $PID; sleep 2; }
else
    echo "未发现运行中的进程。"
fi

# 2) 旧包留一份回滚, 新包临时名+mv 原子替换
if [ -f "$DEPLOY_DIR/$APP_NAME" ]; then
    mv -f "$DEPLOY_DIR/$APP_NAME" "$DEPLOY_DIR/$APP_NAME.bak"
fi
[ -f "$NEW_JAR_DIR/$APP_NAME" ] || { echo "错误: $NEW_JAR_DIR/$APP_NAME 不存在!"; exit 1; }
cp "$NEW_JAR_DIR/$APP_NAME" "$DEPLOY_DIR/$APP_NAME.tmp" || { echo "复制失败, 保留旧包可回滚"; exit 1; }
mv -f "$DEPLOY_DIR/$APP_NAME.tmp" "$DEPLOY_DIR/$APP_NAME"

cd "$DEPLOY_DIR" || exit 1

# 3) 启动: profile/端口显式传参, 日志按时间戳落盘
nohup "$JAVA_BIN" -jar "$APP_NAME" \
    --server.port="$PORT" --spring.profiles.active="$PROFILE" > "$LOG" 2>&1 &
JAVA_PID=$!
echo "已拉起 PID=$JAVA_PID, 日志: $LOG"

# 4) 真启动判据: 轮询端口(最长120s), 挂了自动吐日志尾部
for i in $(seq 1 60); do
    sleep 2
    (exec 3<>/dev/tcp/127.0.0.1/$PORT) 2>/dev/null && {
        exec 3>&- 3<&-
        echo "=== 启动成功(端口 $PORT 已就绪), PID=$JAVA_PID ==="
        exit 0
    }
    kill -0 $JAVA_PID 2>/dev/null || {
        echo "=== 进程中途退出! 最近日志: ==="
        tail -50 "$LOG"
        echo "=== 如需回滚: cp $DEPLOY_DIR/$APP_NAME.bak $DEPLOY_DIR/$APP_NAME && 重跑本脚本 ==="
        exit 1
    }
done
echo "=== 120s 未就绪, 请人工检查: tail -f $LOG ==="
exit 1
