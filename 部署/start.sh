#!/bin/sh
nohup env LOG_PATH=/home/onlyoffice-docs \
java -jar ruoyi-admin.jar \
> nohup.log 2>&1 &

