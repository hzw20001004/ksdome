-- Ĭ�ϵ�ӵ������Ȩ�޵Ľ�ɫ�����û�ʹ��
insert into sys_Role(roleCode, roleName, available, createUser, createTime)
values('all', '����Ա', '0', 'admin', now());
-- Ĭ��Ƥ������
insert into sys_Skin(username,headerColor, sideBarColor) values('admin', '#03a9f4', '0');
-- ����Ա��������
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('admin_password', 'system', '����Ա����', null, null, null, '123456');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('admin_name', 'system', '����Ա����', null, null, null, '');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('admin_phone', 'system', '����Ա�ֻ�', null, null, null, '');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('admin_email', 'system', '����Ա����', null, null, null, '');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('admin_lastModifiedPwdTime', 'system', '�ϴ��޸Ĺ���Ա����ʱ��', null, null, null, null);
-- ֪ͨ��ʽ
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('esop_notice_color', 'esop', '֪ͨ��ʽ������ɫ', null, null, null, '#FF0');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('esop_notice_backgroundColor', 'esop', '֪ͨ��ʽ��ɫ', null, null, null, '');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('esop_notice_position', 'esop', '֪ͨ��ʽλ��', null, null, null, 'top');
-- ��������
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('email_protocol', 'msg', '����Э��', null, null, null, 'smtps');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('email_host', 'msg', '��������', null, null, null, 'smtp.163.com');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('email_port', 'msg', '����˿�', 465, null, null, null);
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('email_username', 'msg', '�����û���', null, null, null, 'liuyong5573@163.com');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('email_password', 'msg', '��������', null, null, null, 'aA72271076');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('email_emailfrom', 'msg', 'ϵͳ�����ַ', null, null, null, 'liuyong5573@163.com');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('email_system_name', 'msg', 'ϵͳ��������', null, null, null, 'MESϵͳ');
-- ·������
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('esop_storage_root', 'esop', 'esop�ĵ��洢��·��', null, null, null, 'C:\esopdata');
-- �ļ�����
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('supportJpg', 'esop', '֧��jpg', null, null, null, '1');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('supportJpeg', 'esop', '֧��jpeg', null, null, null, '1');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('supportPng', 'esop', '֧��png', null, null, null, '1');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('supportBmp', 'esop', '֧��bmp', null, null, null, '1');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('supporGif', 'esop', '֧��gif', null, null, null, '1');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('supportPdf', 'esop', '֧��pdf', null, null, null, '1');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('supportMp4', 'esop', '֧��mp4', null, null, null, '1');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('supportMp3', 'esop', '֧��mp3', null, null, null, '1');
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('maxImageSize', 'esop', '�����ϴ�ͼƬ��С', null, null, null, null);
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('maxPdfSize', 'esop', '�����ϴ�pdf��С', null, null, null, null);
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('maxVideoSize', 'esop', '�����ϴ���Ƶ��С', null, null, null, null);
insert into sys_Config(configName, moduleName, descript, intValue, doubleValue, datetimeValue, strValue)
values('maxAudioSize', 'esop', '�����ϴ���Ƶ��С', null, null, null, null);
-- ��ˮ������
insert into esop_Config(configName,intValue) values('SN', '0');

