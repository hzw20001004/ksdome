#Linux   Linux免密登录.md常用命令和知识

###基础操作命令
```shell
创建密钥
ssh-keygen -t ed25519

拷贝密钥到指定服务器
ssh-copy-id root@192.168.9.61
ssh-copy-id root@192.168.31.202

登录到指定服务器
ssh root@192.168.31.202

密码短语问题
如果你为私钥设置了密码短语，每次使用私钥时都需要输入这个密码短语。
你可以使用ssh-agent和ssh-add来缓存密码短语，这样在一次输入之后，在会话期间就无需再次输入：

eval $(ssh-agent)
ssh-add /root/.ssh/id_ed25519
```



sudo systemctl start rpcbind
sudo systemctl start nfs-server
sudo systemctl enable rpcbind
sudo systemctl enable nfs-server
sudo systemctl status rpcbind
sudo systemctl status nfs-server


