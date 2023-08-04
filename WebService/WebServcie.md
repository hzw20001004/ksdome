WebService 请求操作
```text
1. 获取WSDL 文件
2. 将WSDL 解析
代码解析 执行命令
wsimport -s E:\test -keep http://47.111.74.113:8832/jdyy_fy_pc/OutCallWebService.xml
3. 解析好的文件要注意存放路径  路径错误会导致解析不到
```

wsimport -s D:\ -encoding utf8 -keep -p com.ws.stub -Xnocompile http://58.246.48.190:1180/fid/service/InterOp?wsdl

























