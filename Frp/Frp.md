## Nginx+Frp+Docker实现HTTPS内网穿透

## Docker+Frp+NGinx+云服务器 实现HTTPS内网穿透

### 服务端搭建 (docker，服务器搭建)
```shell
docker pull snowdreamtech/frps
```

> 在某个目录下新建配置文件 frps.ini,如我是在 /mydata/frp 目录下,此处记得把安全组对应端口开放
```shell
[common]
#绑定端口
bind_port = 7000
# 启用面板
dashboard_port = 7500
# 面板登录名和密码
dashboard_user = admin
dashboard_pwd = xxxxxx
# 使用http代理并使用8888端口进行穿透
vhost_http_port = 8888
# 使用https代理并使用9999端口进行穿透
vhost_https_port = 9999
# 日志路径
log_file = ./frps.log
# 日志级别
log_level = info
# 日志最大保存天数
log_max_days = 2
# 认证超时时间
authentication_timeout = 900
# 认证token，客户端需要和此对应，类似于密码，建议设置复杂
token=2DwEfQYnY8f0jG7vPYI29tzzA72_iha93n1gmYqCj5Zw1wxH
# 最大连接数
max_pool_count = 5
max_ports_per_client = 0
```

> 在 /mydata/frp 目录下新建 frp-restart.sh 文件，内容如下
```shell
NAME=frps
IMAGE=snowdreamtech/frps

docker stop $NAME
docker rm $NAME

docker run --restart=on-failure:3 --network host -v /mydata/frp/frps.ini:/etc/frp/frps.ini -d --name $NAME $IMAGE
```

> 运行 frp-restart.sh，启动服务端容器
```shell
./frp-restart.sh
```

外网浏览器输入 服务器ip:7500，输入配置文件中的账号密码，登录 dashboard，确认是否启动成功

### 客户端搭建(本地搭建)
> 下载对应版本 frp 客户端文件，地址：https://github.com/fatedier/frp/releases 解压到本地

* Windows: frp_0.44.0_windows_amd64.zip
* MacOS: frp_0.44.0_darwin_amd64.tar.gz
* MacOS(m1): frp_0.44.0_darwin_arm64.tar.gz


> 找到目录中的 frpc.ini 文件，管理员模式打开编辑，编辑内容如下，记得在服务器安全组开放对应端口
```shell
[common]
# 服务端ip(服务器ip)
server_addr = xxxx
# 对应服务端配置 bind_port
server_port = 7000
# 对应服务端配置中的 token
token = 2DwEfQYnY8f0jG7vPYI29tzzA72_iha93n1gmYqCj5Zw1wxH

# 每一个 server 对应一个端口映射，名称可自定义
[server-1]
type = tcp
# 此处不需要改
local_ip = 127.0.0.1
# 本地服务器映射端口
local_port = 8000
# local_port映射的远程端口(外网端口)，也就是映射的服务端的端口
remote_port = 8800

# 每一个 server 对应一个端口映射，名称可自定义
[server-2]
type = tcp
# 此处不需要改
local_ip = 127.0.0.1
# 本地服务器映射端口
local_port = 8085
# local_port映射的远程端口(外网端口)，也就是映射的服务端的端口
remote_port = 8885
```

> 通过命令行启动 frpc

* windows,通过cmd窗口执行
```shell
frpc.exe
```
* macos,通过终端执行，这里需要去 设置 -> 安全与隐私 -> 通用 -> 允许从以下位置下载的APP 点击允许才可继续执行命令
```shell
./frpc -c frpc.ini
# 需要注意的是，mac运行可能需要安装 go 的环境，若以上语句报错，则先执行
brew install go
```
通过 服务器ip + remote_port 访问对应服务即可

> 若想使用 https，需要配合 nginx，可参考以下文档

https://developer.aliyun.com/article/979499