#Linux   常用命令和知识

###基础操作命令
```shell
vi /etc/sysconfig/network-scripts/ifcfg-ens192

/etc/sysconfig/network-scripts

TYPE="Ethernet" //以太网，还有其他的如bond，bridge
PROXY_METHOD="none"//默认代理方式：关闭状态
BROWSER_ONLY="no" //默认只是浏览器：否
 BOOTPROTO="none" //dhcp 表示动态获取IP地址， static 表示表态IP，none  表示不指定，就是静态
DEFROUTE="yes" //默认路由：是
IPV4_FAILURE_FATAL="no" //是否开启IPV4致命错误检测：否
IPV6INIT="yes" //默认IPV6是否自动初始化: 是
IPV6_AUTOCONF="yes" //默认IPV6是否自动配置：是
IPV6_DEFROUTE="yes" //默认IPV6是否默认路由：是
IPV6_FAILURE_FATAL="no" //如果IPv4或IPv6配置失败，此接口将被禁用，否:如果配置失败，此接口不会被禁用
IPV6_ADDR_GEN_MODE="stable-privacy" //IPV6地址生成模型
NAME="ens192" //名称
UUID="51e111fd-ec09-44f5-8163-81d8f8ebc8f4" //唯一ID
DEVICE="ens192" //设备名称
ONBOOT="yes" //开启启动


IPADDR="192.168.31.201"
PREFIX="24"
GATEWAY="192.168.31.1"
DNS1="114.114.114.114"
DNS2="8.8.8.8"

 
 
CentOS8网卡配置后重启网络


systemctl restart  NetworkManager


```










