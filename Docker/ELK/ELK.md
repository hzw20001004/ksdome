##Docker安装ELK  

> 安装环境版本
```shell
CentOS 7.6  
Docker 20    
elasticsearch:7.17.3
logstash:7.17.3
kibana:7.17.3
```
>创建目录 赋予权限
```shell
1. 创建镜像挂载目录
   mkdir mydata
   mkdir mydata/elasticsearch mydata/logstash
   mkdir mydata/elasticsearch/data mydata/elasticsearch/plugins

2. 创建镜像挂载文件
   cd mydata/logstash
   vim logstash.conf
   i :wq 保存文件   
   
3. 赋予文件权限
chmod 777 mydata/elasticsearch mydata/elasticsearch/data mydata/elasticsearch/plugins mydata/logstash mydata/logstash/logstash.conf
   
```
> 使用 docker-compose.yml 安装环境
```shell
1. 创建 docker-compose.yml 文件
电脑本地  docker-compose.yml
加入 /mydata 地址
version: '3'
services:
  elasticsearch:
    image: elasticsearch:7.17.3
    container_name: elasticsearch
    restart: always
    environment:
      - "cluster.name=elasticsearch" #设置集群名称为elasticsearch
      - "discovery.type=single-node" #以单一节点模式启动
      - "ES_JAVA_OPTS=-Xms512m -Xmx1024m" #设置使用jvm内存大小
    volumes:
      - /mydata/elasticsearch/plugins:/usr/share/elasticsearch/plugins #插件文件挂载
      - /mydata/elasticsearch/data:/usr/share/elasticsearch/data #数据文件挂载
    ports:
      - 9200:9200
      - 9300:9300
  logstash:
    image: logstash:7.17.3
    container_name: logstash
    restart: always
    environment:
      - TZ=Asia/Shanghai
    volumes:
      - /mydata/logstash/logstash.conf:/usr/share/logstash/pipeline/logstash.conf #挂载logstash的配置文件
    depends_on:
      - elasticsearch #kibana在elasticsearch启动之后再启动
    links:
      - elasticsearch:es #可以用es这个域名访问elasticsearch服务
    ports:
      - 4560:4560
      - 4561:4561
      - 4562:4562
      - 4563:4563
  kibana:
    image: kibana:7.17.3
    container_name: kibana
    restart: always
    links:
      - elasticsearch:es #可以用es这个域名访问elasticsearch服务
    depends_on:
      - elasticsearch #kibana在elasticsearch启动之后再启动
    environment:
      - "elasticsearch.hosts=http://es:9200" #设置访问elasticsearch的地址
    ports:
      - 5601:5601






   
   
   

```




加入内容   #可以根据自己需求改动

#监听4560 - 4563 端口来读取项目推送过来的日志
input {
  tcp {
    mode => "server"
    host => "0.0.0.0"
    port => 4560
    codec => json_lines
    type => "debug"
  }
  tcp {
    mode => "server"
    host => "0.0.0.0"
    port => 4561
    codec => json_lines
    type => "error"
  }
  tcp {
    mode => "server"
    host => "0.0.0.0"
    port => 4562
    codec => json_lines
    type => "business"
  }
  tcp {
    mode => "server"
    host => "0.0.0.0"
    port => 4563
    codec => json_lines
    type => "record"
  }
}
#filter：对于记录类型的日志，直接将JSON格式的message转化到source中去，便于搜索查看；
filter{
  if [type] == "record" {
    mutate {
      remove_field => "port"
      remove_field => "host"
      remove_field => "@version"
     }
    json {
      source => "message"
     remove_field => ["message"]
    }
  }
}

output {
  elasticsearch {
    hosts => ["es:9200"]
    codec => json
    action => "index"
#    index => "文件名称禁止大写-%{type}-%{+YYYY.MM.dd}"
    index => "springbootlog-%{type}-%{+YYYY.MM.dd}"
    template_name => "awbook"
    user => ["账号"]
    password => ["密码"]
  }
}




```










