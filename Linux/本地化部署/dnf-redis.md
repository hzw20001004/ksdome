# linux

下载安装reids
https://download.redis.io/releases/redis-7.2.5.tar.gz
mkdir -p /home/redis
cd /home/redis
tar -zxvf redis-7.2.5.tar.gz
cd redis-7.2.5
编译
make -j4
安装 启动
make install

systemd 服务关联
cat > /etc/systemd/system/redis.service <<'EOF'
[Unit]
Description=Redis Server
After=network.target

[Service]
Type=forking
User=root
Group=root
WorkingDirectory=/home/redis/redis-7.2.5
ExecStart=/usr/local/bin/redis-server /home/redis/redis-7.2.5/redis.conf
ExecStop=/usr/local/bin/redis-cli -a Redis@2026 shutdown
Restart=on-failure
RestartSec=1

[Install]
WantedBy=multi-user.target
EOF

改配置
vim /home/redis/redis-7.2.5/redis.conf

bind 0.0.0.0
protected-mode no
requirepass Redis@2026
daemonize yes
supervised no
启动不了手工启动

systemctl daemon-reload
systemctl stop redis
systemctl start redis
systemctl status redis



