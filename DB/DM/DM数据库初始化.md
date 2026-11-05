# 切换dmdba用户
su - dmdba
# 临时恢复系统PATH
export PATH=/usr/bin:/bin


# root账号执行
mkdir -p /db_data/dmdata
chown -R dmdba:dinstall /db_data
chmod 700 /db_data/dmdata

# dmdba 初始化
cd/home/dmdbms/bin
/home/dmdbms/bin/dminit PATH=/db_data/dmdata PAGE_SIZE=32 EXTENT_SIZE=32 LOG_SIZE=2048 CHARSET=1 CASE_SENSITIVE=N PORT_NUM=3435 DB_NAME=DAMENG INSTANCE_NAME=DMSERVER SYSDBA_PWD='Dameng123' SYSAUDITOR_PWD='Dameng123'

# root账号执行
cd /home/dmdbms/script/root
./dm_service_installer.sh -t dmserver -dm_ini /db_data/dmdata/DAMENG/dm.ini -p DMSERVER
注册成功后服务名称：`DmServiceDMSERVER`

# 启动
systemctl start DmServiceDMSERVER
# 开机自启
systemctl enable DmServiceDMSERVER
# 查看状态
systemctl status DmServiceDMSERVER

# 防火墙
firewall-cmd --state
# ping 端口
telnet 10.33.2.234 3435

sudo netstat -tulnp












