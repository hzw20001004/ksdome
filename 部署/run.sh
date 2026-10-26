#!/bin/bash

# 定义一些路径变量，方便后续修改
APP_NAME="gzyun-yc-biz.jar"
DEPLOY_DIR="/home/project/zhenlong/yc"
NEW_JAR_DIR="/home/project/zhenlong/yc/new-code"

echo "=== 开始执行应用更新与重启脚本 ==="

# 第一步：找到正在运行的进程并杀掉
PID=$(ps -ef | grep "$APP_NAME" | grep -v grep | awk '{print $2}')

if [ -n "$PID" ]; then
    echo "发现应用正在运行，PID为: $PID，正在尝试关闭..."
    kill -9 $PID
    # 稍微等待一下，确保进程完全退出，端口释放
    sleep 3
    echo "进程已成功关闭。"
else
    echo "未发现正在运行的 $APP_NAME 进程，跳过关闭步骤。"
fi

# 第二步：删除旧的jar包
if [ -f "$DEPLOY_DIR/$APP_NAME" ]; then
    echo "正在删除旧版本的jar包..."
    rm -f "$DEPLOY_DIR/$APP_NAME"
    echo "旧版本jar包已删除。"
else
    echo "未找到旧的jar包，跳过删除步骤。"
fi

# 第三步：将新jar包复制到部署目录
if [ -f "$NEW_JAR_DIR/$APP_NAME" ]; then
    echo "正在从 $NEW_JAR_DIR 复制新版本jar包到 $DEPLOY_DIR ..."
    cp "$NEW_JAR_DIR/$APP_NAME" "$DEPLOY_DIR/"
    echo "新版本jar包复制完成。"
else
    echo "错误：在 $NEW_JAR_DIR 下未找到新的 $APP_NAME 文件！请检查。"
    exit 1
fi

# 第四步：切换到部署目录
cd "$DEPLOY_DIR" || exit
echo "当前工作目录已切换至：$(pwd)"

# 第五步：后台启动应用，并将日志输出到 app.log
echo "正在启动新版本应用..."
nohup java -jar "$APP_NAME" > app.log 2>&1 &

# 稍微等待一下，让程序开始初始化
sleep 3
NEW_PID=$(ps -ef | grep "$APP_NAME" | grep -v grep | awk '{print $2}')

if [ -n "$NEW_PID" ]; then
    echo "=== 应用启动成功！新进程 PID: $NEW_PID ==="
    echo "可以通过 tail -f app.log 查看实时日志。"
else
    echo "=== 警告：应用可能启动失败，请务必检查 app.log 日志！ ==="
fi
