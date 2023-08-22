WebService Java操作
```text
1. 获取WSDL 文件
   http://58.246.48.190:1180/fid/service/InterOp?wsdl
2. 将WSDL 解析
wsimport是JDK中提供的一个工具命令，其作用就是生成WSDL客户端代码，所在位置是在JDK的安装目录下，bin目录中
找到bin目录打开cmd黑窗口
代码解析 执行命令
wsimport -s D:\ -encoding utf8 -keep -p com.ws.stub -Xnocompile http://58.246.48.190:1180/fid/service/InterOp?wsdl
3. 解析好的文件要注意存放路径  路径错误会导致解析不到
4. java代码拷贝到项目里面
   必须全路径拷贝到java目录下面
   直接在生成好的代码里找自己的方法调用
```












































































































