#!/bin/sh
nohup java -jar -Dserver.port=8080 ruoyi-admin.jar > app.log 2>&1 &
echo "启动完成，进程PID：$!"


#!/bin/sh
nohup /home/jdk8/jdk8u422-b05/bin/java -jar -Dserver.port=8190 tdx-face-sdk-server_release.jar > app.log 2>&1 &
echo "启动完成，进程PID：$!"


