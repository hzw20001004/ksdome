部署命令
>后台启动
```text
nohup java -jar chengfa.jar &
nohup java -jar wh-1.0.1.jar &
nohup java -jar parent-services-0.0.1-SNAPSHOT.jar &
java -jar station.jar > stationLog.txt 2>&1 &
```
nohup java -jar warehouse-0.1.0.jar &


> 指定文件
```text
nohup java -jar chengfa.jar >temp.txt &
``` 
> 端口进程查看 进程杀除
```text
netstat -nlp | grep :9083
netstat -nlp | grep :8848

netstat -nlp | grep :7077

kill -s 9 24204
``` 
> nginx 文件目录
```text
whereis nginx
//刷新配置
nginx -s reload
```
kill -9 nginx

>操作tomcat 启动命令
```shell
sh startup.sh  启动
sh shutdown.sh 停止
```


docker-compose build && docker-compose docker-compose-tomcat.yml up -d











