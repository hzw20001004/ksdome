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



多个直接解压就好了
验证
/home/jdk8/jdk8u422-b05/bin/java -version


## jdk17
https://release-assets.githubusercontent.com/github-production-release-asset/372925194/fa1e0dc6-b748-4eaf-8e2d-0c47f9a31ffa?sp=r&sv=2018-11-09&sr=b&spr=https&se=2026-11-25T08%3A15%3A53Z&rscd=attachment%3B+filename%3DOpenJDK17U-jdk_x64_linux_hotspot_17.0.20_8.tar.gz&rsct=application%2Foctet-stream&skoid=96c2d410-5711-43a1-aedd-ab1947aa7ab0&sktid=398a6654-997b-47e9-b12b-9515b896b4de&skt=2026-11-25T07%3A15%3A08Z&ske=2026-11-25T08%3A15%3A53Z&sks=b&skv=2018-11-09&sig=9nTOOUV0EbcvmX4MArGEpjrb6p7S4vlV43gLSYAOSH4%3D&jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmVsZWFzZS1hc3NldHMuZ2l0aHVidXNlcmNvbnRlbnQuY29tIiwia2V5Ijoia2V5MSIsImV4cCI6MTc5NTU5NDUwOCwibmJmIjoxNzk1NTkwOTA4LCJwYXRoIjoicmVsZWFzZWFzc2V0cHJvZHVjdGlvbi5ibG9iLmNvcmUud2luZG93cy5uZXQifQ.p2VauK2cxHGcZBHOA-ujxMucW9u0L1PArZSmi_27XH0&response-content-disposition=attachment%3B%20filename%3DOpenJDK17U-jdk_x64_linux_hotspot_17.0.20_8.tar.gz&response-content-type=application%2Foctet-stream
tar -zxvf OpenJDK17U-jdk_x64_linux_hotspot_17.0.20_8.tar.gz -C /usr/local/
ln -s /usr/local/jdk8u422-b05 /usr/local/jdk

cat >> /etc/profile <<'EOF'
export JAVA_HOME=/usr/local/jdk
export JRE_HOME=${JAVA_HOME}/jre
export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib
export PATH=${JAVA_HOME}/bin:$PATH
EOF

source /etc/profile
java -version


