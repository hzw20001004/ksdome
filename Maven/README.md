> 打包命令

``` xml
// 引用外部jar导入到本地电脑maven库
mvn install:install-file ^
-Dfile=D:\zwdd-sdk-java-1.2.1.jar ^
-DgroupId=com.zwdd ^
-DartifactId=zwdd-sdk-java ^
-Dversion=1.2.1 ^
-Dpackaging=jar

1. maven引用外部的jar，在pom.xml添加
<dependencies>
    <!-- 外部依赖库 -->
            <dependency>
            <groupId>com.www</groupId>
            <artifactId>client</artifactId>
            <version>2.8</version>
            <scope>system</scope>
            <systemPath>${project.basedir}/mylib/client.jar</systemPath>
         </dependency>
 </dependencies>

2. 项目打包遇到问题,引入的外部jar一直无法打包到项目jar里面；在网上也查询很多解决办法一直不生效，最终在打包插件中添加配置后问题解决

     <plugin>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-maven-plugin</artifactId>
  　　<!-- 添加配置如下-->
           <configuration>
               <includeSystemScope>true</includeSystemScope>
           </configuration>
     </plugin>
```














