# linux

https://github.com/adoptium/temurin8-binaries/releases/download/jdk8u422-b05/OpenJDK8U-jdk_aarch64_linux_hotspot_8u422b05.tar.gz
https://github.com/adoptium/temurin8-binaries/releases/download/jdk8u422-b05/OpenJDK8U-jdk_x64_linux_hotspot_8u422b05.tar.gz


tar -zxvf OpenJDK8U-jdk_x64_linux_hotspot_8u422b05.tar.gz -C /usr/local/
ln -s /usr/local/jdk8u422-b05 /usr/local/jdk

cat >> /etc/profile <<'EOF'
export JAVA_HOME=/usr/local/jdk
export JRE_HOME=${JAVA_HOME}/jre
export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib
export PATH=${JAVA_HOME}/bin:$PATH
EOF

source /etc/profile
java -version




