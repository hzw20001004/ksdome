#iptables（CentOS/RHEL 常用）

查看端口规则
```shell
查看端口规则
sudo iptables -L -n
开放9999端口
sudo iptables -I IN_public_allow -p tcp --dport 9999 -m conntrack --ctstate NEW,UNTRACKED -j ACCEPT
sudo iptables -I IN_public_allow -p tcp --dport 8848 -m conntrack --ctstate NEW,UNTRACKED -j ACCEPT
sudo iptables -I IN_public_allow -p tcp --dport 18848 -m conntrack --ctstate NEW,UNTRACKED -j ACCEPT

```







































