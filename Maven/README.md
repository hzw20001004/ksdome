> 打包命令

``` xml

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














