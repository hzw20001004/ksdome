#Docker   常用的知识



##安装docker
```shell
安装命令
sudo yum install -y yum-utils device-mapper-persistent-data lvm2
sudo yum-config-manager --add-repo https://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
sudo yum install -y docker-ce docker-ce-cli containerd.io
启动docker
service docker start 
查看版本 验证是否安装成功
docker version
设置开机自启
sudo systemctl enable docker


安装docker-compose
sudo yum install docker-compose-plugin
curl -L "https://github.com/docker/compose/releases/download/v2.2.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose  
docker-compose version
```


##阿里云镜像加速
```shell
# 创建文件
sudo mkdir -p /etc/docker
# 修改配置, 设置镜像
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://vw9qapdy.mirror.aliyuncs.com"]
}
EOF
# 重启后台线程
sudo systemctl daemon-reload
# 重启docker
sudo systemctl restart docker
```






>镜像云镜像服务上

1.登录到阿里云
2.找到容器镜像服务
3.创建命名空间
4.创建容器镜像
![img_19.png](img/img_19.png)
5.镜像推送到阿里云的的镜像仓库
```shell
# 登录
[root@iZbp1bjhiosovua6v1vsclZ ~]# docker login --username=迷人酥酥 registry.cn-hangzhou.aliyuncs.com
Password: 
WARNING! Your password will be stored unencrypted in /root/.docker/config.json.
Configure a credential helper to remove this warning. See
https://docs.docker.com/engine/reference/commandline/login/#credentials-store
Login Succeeded
[root@iZbp1bjhiosovua6v1vsclZ ~]# docker images
REPOSITORY               TAG       IMAGE ID       CREATED        SIZE
hzw/tomcat               1.5       fb16eb6c7c09   11 hours ago   545MB
hzw20001004/tomcat8080   1.5       fb16eb6c7c09   11 hours ago   545MB
diytomcat8080            latest    fb16eb6c7c09   11 hours ago   545MB
[root@iZbp1bjhiosovua6v1vsclZ ~]# docker push hzw20001004/tomcat8080:1.5
```
具体操作到阿里云官网看看

##小结
![img_20.png](img/img_20.png)
![img_21.png](img/img_21.png)



































