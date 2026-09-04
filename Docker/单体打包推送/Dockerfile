FROM adoptopenjdk/openjdk8:latest

RUN mkdir -p /ruoyi/server/logs \
    /ruoyi/server/temp \
    /ruoyi/skywalking/agent
ENV LANG C.UTF-8
ENV TZ=Asia/Shanghai
RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN mkdir -p /ruoyi-admin
WORKDIR /ruoyi-admin
EXPOSE 8080
ADD ./target/ruoyi-admin.jar ./
CMD sleep 3;java $JAVA_OPTS -jar ruoyi-admin.jar
