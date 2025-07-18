#Docker   常用的知识



##安装docker
```shell
安装命令
sudo yum install -y yum-utils device-mapper-persistent-data lvm2
sudo yum-config-manager --add-repo https://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
sudo yum install -y containerd.io
sudo yum install -y docker-ce docker-ce-cli containerd.io

启动docker
查看版本 验证是否安装成功
设置开机自启
systemctl status docker
systemctl enable docker
docker version

安装docker-compose
sudo yum install docker-compose-plugin
curl -L "https://github.com/docker/compose/releases/download/v2.2.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose  
docker-compose version
卸载
sudo rm /usr/local/bin/docker-compose
```


##阿里云镜像加速
```shell
# 创建文件
sudo mkdir -p /etc/docker
# 修改配置, 设置镜像
sudo mkdir -p /etc/docker

sudo tee /etc/docker/daemon.json <<EOF
{
  "registry-mirrors": [ "https://docker.1ms.run","https://docker.xuanyuan.me"]
}
EOF


# 重启后台线程  # 重启docker
sudo systemctl daemon-reload
sudo systemctl restart docker
# 查看docker  是否配置成功
docker info
```
```text
sudo vim /etc/docker/daemon.json

{"registry-mirrors": [
    "https://xxxxxxx.mirror.aliyuncs.com", #改成自己的阿里云加速器地址
    "https://docker.rainbond.cc",
    "https://do.nark.eu.org",
    "https://dc.j8.work",
    "https://docker.m.daocloud.io",
    "https://dockerproxy.com",
    "https://registry.docker-cn.com",
    "https://docker.mirrors.ustc.edu.cn",
    "https://hub-mirror.c.163.com",
    "https://mirror.baidubce.com",
    "https://docker.nju.edu.cn"
  ]
}
sudo systemctl daemon-reload
sudo systemctl restart docker

这时候再拉去镜像就不会报错了
sudo docker run hello-world

```






































