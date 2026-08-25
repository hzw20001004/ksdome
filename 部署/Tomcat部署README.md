#  Tomcat部署README.md



```

拷贝war包
docker cp /home/qt.war mytomcatqt:usr/local/tomcat/webapps
拷贝证书  改成一样的名字拷贝进去
docker cp /home/zdz.siginfo.cn.pfx mytomcatqt:usr/local/tomcat/
进入容器
docker exec -it 72eb7634c0ae /bin/bash
cd /conf
vim server.xml
重启容器
docker restart mytomcatqt


```

