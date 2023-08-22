部署命令
>后台启动
```text
nohup java -jar jqApi.jar &
nohup java -jar chengfa.jar &
```

> 指定文件
```text
nohup java -jar shareniu.jar >temp.txt &
``` 
> 端口进程查看 进程杀除
```text
netstat -nlp | grep :8080
kill -s 9 24204
``` 
> nginx 文件目录
```text
whereis nginx
```


kill -9 nginx














