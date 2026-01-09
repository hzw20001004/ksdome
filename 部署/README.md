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
# 查看所有配置文件中的 listen 指令（推荐）
grep -r "listen " /etc/nginx/
nohup java -jar chengfa.jar >temp.txt &
``` 
> 端口进程查看 进程杀除
```text
// 查看所有端口
sudo netstat -tulnp

netstat -nlp | grep :9083

netstat -nlp | grep :7077

kill -s 9 24204
``` 
> nginx 文件目录
```text
whereis nginx
```
kill -9 nginx

sudo systemctl start nginx
>操作tomcat 启动命令
```shell
sh startup.sh  启动
sh shutdown.sh 停止
```


docker-compose build && docker-compose docker-compose-tomcat.yml up -d











