# linux

下载安装nginx1:1.30+++
# logs目录（存放错误日志、pid文件）
mkdir -p /home/nginx/nginx-1.30.3/logs
# 临时目录（http缓存临时文件，防止后续启动报错）
mkdir -p /home/nginx/nginx-1.30.3/tmp
# 软链接映射编译prefix路径（核心，解决硬编码路径问题）
ln -s /home/nginx/nginx-1.30.3 /usr/local/nginx-1.30.3

cd /home/nginx
wget https://nginx.org/download/nginx-1.30.3.tar.gz
tar -zxvf nginx-1.30.3.tar.gz
cd nginx-1.30.3
加载配置
./configure --prefix=/usr/local/nginx-1.30.3 --with-http_ssl_module --with-http_gzip_static_module --with-http_stub_status_module --with-http_v2_module --with-stream --with-stream_ssl_module --with-pcre
编译
make -j4

systemd 服务文件
cat > /etc/systemd/system/nginx130.service <<'EOF'
[Unit]
Description=Nginx 1.30.3
After=network.target

[Service]
Type=forking
ExecStart=/home/nginx/nginx-1.30.3/objs/nginx
ExecStop=/home/nginx/nginx-1.30.3/objs/nginx -s stop
ExecReload=/home/nginx/nginx-1.30.3/objs/nginx -s reload
PrivateTmp=true

[Install]
WantedBy=multi-user.target
EOF

systemctl daemon-reload
systemctl enable nginx130
systemctl start nginx130
systemctl status nginx130

ln -sf /home/nginx/nginx-1.30.3/objs/nginx /usr/bin/nginx
# 验证
nginx -V

# 1. 校验配置（必做！错了会保留旧配置不生效）
/home/nginx/nginx-1.30.3/objs/nginx -t

# 2. 平滑刷新配置（生产首选，长连接不切断）
systemctl reload nginx130








