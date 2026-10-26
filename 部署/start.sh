#!/bin/sh
nohup java -jar -Dserver.port=8080 ruoyi-admin.jar > app.log 2>&1 &
echo "启动完成，进程PID：$!"
