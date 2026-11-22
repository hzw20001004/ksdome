部署命令

查询防火墙状态
systemctl status firewalld
> 端口进程查看 进程杀除
```text
// 查看所有端口
ss -tulnp

sudo netstat -tulnp

netstat -nlp | grep :9083

netstat -nlp | grep :7077

kill -s 9 24204
``` 
> nginx 文件目录
```text
//寻找根目录
whereis nginx
//检查配置
nginx -t
//刷新配置
    nginx -s reload
/home/nginx/nginx-1.31.9/objs/nginx -s reload
/home/nginx/nginx-1.31.9/objs/nginx -t
/home/nginx/nginx-1.31.9/objs/nginx -s stop
//更新并重启
nginx -t && systemctl restart nginx && nginx -v
```
kill -9 nginx
//更新配置
sudo systemctl reload nginx
//启动nginx
sudo systemctl start nginx
>操作tomcat 启动命令
```shell
sh startup.sh  启动
sh shutdown.sh 停止
```


docker-compose build && docker-compose docker-compose-tomcat.yml up -d

文件夹加锁
chattr +i /home/mbpc/ruoyi-files
解锁
chattr -R -i /home/mbpc/ruoyi-files








