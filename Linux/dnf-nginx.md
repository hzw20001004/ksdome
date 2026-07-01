# 更新源
cat > /etc/yum.repos.d/nginx.repo <<'EOF'
[nginx-stable]
name=nginx stable repo
baseurl=https://nginx.org/packages/centos/8/$basearch/
gpgcheck=1
enabled=1
gpgkey=https://nginx.org/keys/nginx_signing.key
module_hotfixes=true
EOF


dnf clean all && dnf makecache
dnf list --showduplicates nginx
dnf install -y nginx-1:1.30.3-1.el8.ngx
nginx -v


dnf remove -y nginx
dnf install -y nginx-1:1.30.3-1.el8.ngx
