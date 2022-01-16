-- 默认的拥有所有权限的角色，供用户使用
insert into sys_Role(roleCode, roleName, available, createUser, createTime)
values('all', '管理员', '0', 'admin', now());
-- 默认皮肤设置
insert into sys_Skin(username,headerColor, sideBarColor) values('admin', '#03a9f4', '0');
-- 管理员密码设置
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('admin_password', 'system', '管理员密码', null, null, null, '123456');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('admin_name', 'system', '管理员姓名', null, null, null, '');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('admin_phone', 'system', '管理员手机', null, null, null, '');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('admin_email', 'system', '管理员邮箱', null, null, null, '');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('admin_lastModifiedPwdTime', 'system', '上次修改管理员密码时间', null, null, null, null);
-- 通知样式
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('esop_notice_color', 'esop', '通知样式文字颜色', null, null, null, '#FF0');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('esop_notice_backgroundColor', 'esop', '通知样式底色', null, null, null, '');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('esop_notice_position', 'esop', '通知样式位置', null, null, null, 'top');
-- 邮箱设置
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('email_protocol', 'msg', '邮箱协议', null, null, null, 'smtps');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('email_host', 'msg', '邮箱主机', null, null, null, 'smtp.163.com');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('email_port', 'msg', '邮箱端口', 465, null, null, null);
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('email_username', 'msg', '邮箱用户名', null, null, null, 'liuyong5573@163.com');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('email_password', 'msg', '邮箱密码', null, null, null, 'aA72271076');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('email_emailfrom', 'msg', '系统邮箱地址', null, null, null, 'liuyong5573@163.com');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('email_system_name', 'msg', '系统邮箱名称', null, null, null, 'MES系统');
-- 路径设置
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('esop_storage_root', 'esop', 'esop文档存储根路径', null, null, null, 'C:\esopdata');
-- 文件设置
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('supportJpg', 'esop', '支持jpg', null, null, null, '1');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('supportJpeg', 'esop', '支持jpeg', null, null, null, '1');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('supportPng', 'esop', '支持png', null, null, null, '1');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('supportBmp', 'esop', '支持bmp', null, null, null, '1');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('supporGif', 'esop', '支持gif', null, null, null, '1');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('supportPdf', 'esop', '支持pdf', null, null, null, '1');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('supportMp4', 'esop', '支持mp4', null, null, null, '1');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('supportMp3', 'esop', '支持mp3', null, null, null, '1');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('maxImageSize', 'esop', '限制上传图片大小', null, null, null, null);
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('maxPdfSize', 'esop', '限制上传pdf大小', null, null, null, null);
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('maxVideoSize', 'esop', '限制上传视频大小', null, null, null, null);
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('maxAudioSize', 'esop', '限制上传音频大小', null, null, null, null);
-- 流水号设置
insert into esop_Config(configName,intValue) values('SN', '0');

