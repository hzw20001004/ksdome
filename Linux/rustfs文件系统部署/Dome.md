#  部署

### nginx
```text
server {
    listen 9993;
    server_name www;
    
    location / {
        proxy_pass http://127.0.0.1:7001;

        # 重点！把浏览器真实访问的 host:9993 传给rustfs后端，不要内部127.0.0.1:7001
        proxy_set_header Host $host:$server_port;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header X-Forwarded-Host $host;
        proxy_set_header X-Forwarded-Port $server_port;

        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection "upgrade";

        proxy_connect_timeout 300;
        proxy_send_timeout 300;
        proxy_read_timeout 300;
        client_max_body_size 0;
        proxy_buffering off;
    }
}
```

### docker
```text
  rustfs:
    image: rustfs/rustfs:latest
    container_name: rustfs
    volumes:
      - /mydata/rustfs/data:/data  # 数据存储
    environment:
      - RUSTFS_ROOT_USER=admin
      - RUSTFS_ROOT_PASSWORD=siginfo*88668850
      - RUSTFS_ACCESS_KEY=admin
      - RUSTFS_SECRET_KEY=siginfo*88668850
    restart: unless-stopped
    ports:
      - "9994:9000"   # S3 API
      - "7001:9001"   # Web 控制台

```

