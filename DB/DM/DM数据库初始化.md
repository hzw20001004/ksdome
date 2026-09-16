# 切换dmdba用户
su - dmdba
# 临时恢复系统PATH
export PATH=/usr/bin:/bin
# 编辑环境变量配置
vi ~/.bash_profile


# root账号执行
mkdir -p /db_data/dmdata
chown -R dmdba:dinstall /db_data
chmod 700 /db_data/dmdata

# dmdba 初始化
/data/dmdbms/bin/dminit PATH=/db_data/dmdata PAGE_SIZE=32 EXTENT_SIZE=32 LOG_SIZE=2048 CHARSET=1 CASE_SENSITIVE=N PORT_NUM=4236 DB_NAME=DAMENG INSTANCE_NAME=DMSERVER SYSDBA_PWD='Dameng@123' SYSAUDITOR_PWD='Dameng@123'

# root账号执行
/home/dmdbms/script/root/dm_service_shturl.cc/SM -t dmserver -dm_ini /db_data/dmdata/DAMENG/dm.ini -p DMSERVER

# 启动
systemctl start DmServiceDMSERVER
# 开机自启
systemctl enable DmServiceDMSERVER
# 查看状态
systemctl status DmServiceDMSERVER

# 换端口














