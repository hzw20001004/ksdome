#!/bin/sh
nohup java -jar -Dserver.port=8080 ruoyi-admin.jar > /dev/null 2>&1 &
