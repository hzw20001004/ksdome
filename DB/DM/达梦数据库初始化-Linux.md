# 达梦数据库实例初始化（根盘版 · Linux）

> 参考：《达梦数据库实例初始化(根盘版)参考手册》
> 环境：DM8 / Linux，命令行初始化
> 标注「⚠️ 生产必须」的步骤，生产环境不可省略。

---

## 0、环境信息（路径约定）

| 项 | 路径 |
|---|---|
| 数据库软件安装目录 | `/data/dmdbms` |
| 数据文件存放目录 | `/db_data/dmdata` |
| 归档目录（第 4 步用） | `/db_data/dmarch` |
| 备份目录（第 5 步用） | `/db_data/dmbak` |

提前建好归档/备份目录并授权：

```bash
mkdir -p /db_data/dmarch /db_data/dmbak
chown -R dmdba:dinstall /db_data
```

---

## 1、命令行初始化实例

> 初始化参数根据实际情况配置，以下为本次采用命令（`PAGE_SIZE=32`、`LOG_SIZE=2048`，并指定 SYSDBA 密码）。

```bash
# 切到 dmdba
su - dmdba

# 初始化（软件装在 /data/dmdbms，数据落到 /db_data/dmdata）
/data/dmdbms/bin/dminit PATH=/db_data/dmdata PAGE_SIZE=32 LOG_SIZE=2048 SYSDBA_PWD="Dameng@123"
```

执行成功后，会在 `/db_data/dmdata/DAMENG/` 下生成 `dm.ini`、`dm.ctl`、数据文件、联机日志等。

### 1.1 常用可选参数（按需追加到 dminit 后）

| 参数 | 说明 |
|---|---|
| `DB_NAME=DAMENG` | 数据库名（默认即 DAMENG） |
| `INSTANCE_NAME=DMSERVER` | 实例名 |
| `PORT_NUM=5236` | 端口（默认 5236） |
| `EXTENT_SIZE=32` | 簇大小 |
| `CASE_SENSITIVE=Y` | 大小写敏感，Oracle 迁移建议 `N`（建库后不可改） |
| `CHARSET=1` | 字符集：`1`=UTF-8（推荐），`0`=GB18030（建库后不可改） |
| `LENGTH_IN_CHAR=1` | VARCHAR 按字符算，避免中文超长 |

> ⚠️ `PAGE_SIZE`、`CASE_SENSITIVE`、`CHARSET` 建库后不可改，初始化时一次定死。

---

## 2、注册实例服务（root）

```bash
/data/dmdbms/script/root/dm_service_installer.sh -t dmserver -p DM -dm_ini /db_data/dmdata/DAMENG/dm.ini
```

注册后得到服务脚本：`/data/dmdbms/bin/DmServiceDM`

> 备注：删除自启 / 服务注册错误时用：
> ```bash
> /data/dmdbms/script/root/dm_service_uninstaller.sh -n DmServiceDM
> ```

---

## 3、启动 / 关闭服务

```bash
# dmdba 或 root 均可
/data/dmdbms/bin/DmServiceDM start     # 启动
/data/dmdbms/bin/DmServiceDM stop      # 关闭
```

root 下检查数据库是否启动：

```bash
ps -ef | grep dmserver
```

---

## 4、配置归档（⚠️ 生产必须开启）

> Windows 环境用 manager 管理工具登录实例执行同样语句即可。

```bash
su - dmdba
cd /data/dmdbms/bin
./disql SYSDBA/"Dameng@123"@localhost:5236
```

```sql
ALTER DATABASE MOUNT;
ALTER DATABASE ARCHIVELOG;
ALTER DATABASE ADD ARCHIVELOG 'DEST=/db_data/dmarch, TYPE=LOCAL, FILE_SIZE=2048, SPACE_LIMIT=20480';
ALTER DATABASE OPEN;
```

---

## 5、创建作业调度（⚠️ 生产必须开启）

> Windows 环境用 manager 管理工具连接实例执行；可在「代理」中查看作业运行情况。
> 用 disql 连上后，**逐段执行**下列脚本。

### 5.0 创建代理环境

```sql
SP_INIT_JOB_SYS(1);
```

### 5.1 统计信息收集（每月第一个周六 23:00）

```sql
call SP_CREATE_JOB('UPDATE_STAT',1,0,'',0,0,'',0,'每月第一个周六自动更新数据库统计信息');
call SP_JOB_CONFIG_START('UPDATE_STAT');
call SP_ADD_JOB_STEP('UPDATE_STAT', '定期更新数据库统计信息', 0,
  'CALL DBMS_STATS.GATHER_SCHEMA_STATS(''SYSDBA'',100,FALSE,''FOR ALL COLUMNS SIZE AUTO'');
   CALL DBMS_STATS.GATHER_SCHEMA_STATS(''SYSDBA'',100,FALSE,''FOR ALL COLUMNS SIZE AUTO'');',
  0, 0, 0, 0, NULL, 0);   -- ⚠️ username 改成实际业务用户
call SP_ADD_JOB_SCHEDULE('UPDATE_STAT', '每月第一个周六执行作业', 1, 4, 1, 7, 0, '23:00:00', NULL, '2020-09-14 13:06:39', NULL, '');
call SP_JOB_CONFIG_COMMIT('UPDATE_STAT');
```

### 5.2 每周日 00:00 全量备份

```sql
call SP_INIT_JOB_SYS(1);
call SP_CREATE_JOB('full_bak',1,0,'',0,0,'',0,'每周日00:00进行一次全库备份');
call SP_JOB_CONFIG_START('full_bak');
call SP_ADD_JOB_STEP('full_bak', 'fbak', 6, '01000000/db_data/dmbak', 1, 2, 0, 0, NULL, 0);
call SP_ADD_JOB_SCHEDULE('full_bak', 'meizhou', 1, 2, 1, 1, 0, '00:00:00', NULL, '2022-07-26 23:00:00', NULL, '');
call SP_JOB_CONFIG_COMMIT('full_bak');
```

### 5.3 每周一至周六 23:00 增量备份

```sql
call SP_CREATE_JOB('incre_bak',1,0,'',0,0,'',0,'每周一至周六23:00进行增量备份');
call SP_JOB_CONFIG_START('incre_bak');
call SP_ADD_JOB_STEP('incre_bak', 'meitian', 6, '11000000/db_data/dmbak', 1, 2, 0, 0, NULL, 0);
call SP_ADD_JOB_SCHEDULE('incre_bak', 'meitian', 1, 2, 1, 126, 0, '23:00:00', NULL, '2022-07-26 23:00:00', NULL, '');
call SP_JOB_CONFIG_COMMIT('incre_bak');
```

### 5.4 备份清理（保留 15 天，每天 01:00 清理）

```sql
call SP_CREATE_JOB('bak_clear',1,0,'',0,0,'',0,'每天删除15天前的备份');
call SP_JOB_CONFIG_START('bak_clear');
call SP_ADD_JOB_STEP('bak_clear', 'del_bak', 0,
  'SF_BAKSET_BACKUP_DIR_ADD(''DISK'',''/db_data/dmbak'');
   CALL SP_DB_BAKSET_REMOVE_BATCH(''DISK'',SYSDATE-15);',
  1, 2, 0, 0, NULL, 0);
call SP_ADD_JOB_SCHEDULE('bak_clear', 'diaodu_del', 1, 1, 1, 0, 0, '01:00:00', NULL, '2020-06-25 22:54:03', NULL, '');
call SP_JOB_CONFIG_COMMIT('bak_clear');
```

### 5.5 备份相关查询与手动全备验证

```sql
-- 查看备份路径相关参数
select * from v$DM_INI where PARA_NAME like '%BAK_PATH%';

-- 手动全量备份（用来验证调度能否成功）
backup database full backupset '/db_data/dmbak/bak1';
```

> ⚠️ 必须先做一次全备验证是否成功：DMAP 或权限类问题会导致报错，验证通过后再调成正常备份时间。

---

## 附：关键路径 / 命令速查

| 项 | 值 |
|---|---|
| 软件目录 | `/data/dmdbms` |
| 数据目录 | `/db_data/dmdata/DAMENG/` |
| 主配置 | `/db_data/dmdata/DAMENG/dm.ini` |
| 归档目录 | `/db_data/dmarch` |
| 备份目录 | `/db_data/dmbak` |
| 默认端口 | `5236` |
| 默认账号 | `SYSDBA` / `Dameng@123` |
| 服务脚本 | `/data/dmdbms/bin/DmServiceDM` |
| disql | `/data/dmdbms/bin/disql` |
| 服务注册 | `/data/dmdbms/script/root/dm_service_installer.sh` |
| 服务卸载 | `/data/dmdbms/script/root/dm_service_uninstaller.sh -n DmServiceDM` |
