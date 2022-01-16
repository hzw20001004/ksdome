
-- 用户信息
insert into sys_TableDef(tableName, defaultName, displayName, orderBy, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_User', '用户信息', '用户信息', 'id', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');

 -- 默认的空的过滤方案
insert into sys_FilterScheme(tableName, username, lineid, schemeName, content, isSaved, descript) 
values('sys_User', 'default', '1', '方案一', '', '1', '');
insert into sys_FilterScheme(tableName, username, lineid, schemeName, content, isSaved, descript) 
values('sys_User', 'admin', '1', '方案一', '', '1', '');


insert into sys_TableScheme(tableName, username, lineid, schemeName, orderBy, customName, descript) 
values('sys_User', 'default', '1', '方案一', 'id','','');
insert into sys_TableScheme(tableName, username, lineid, schemeName, orderBy, customName, descript) 
values('sys_User', 'admin', '1', '方案一', 'id','','');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_User', 'username', 'sys_User_username', '用户名', '用户名', 'String', '', '', '', '', '0', '', '1', '0', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_User', 'password', 'sys_User_password', '密码', '密码', 'String', '', '', '', '', '0', '', '0', '0', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_User', 'salt', 'sys_User_salt', '盐', '盐', 'String', '', '', '', '', '0', '', '0', '0', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_User', 'userType', 'sys_User_userType', '用户类别', '用户类别', 'String', '', '', '', '', '3', '', '0', '0', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_User', 'isLocked', 'sys_User_isLocked', '是否禁用', '是否禁用', 'String', '', '', '', '', '3', '', '0', '0', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_User', 'stationCode', 'sys_User_stationCode', '当前工位', '当前工位', 'String', '', '', '', '', '0', '', '0', '1', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_User', 'departmentId', 'sys_User_departmentId', '所属部门', '所属部门', 'int', '', '', '', '', '0', '', '0', '0', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_User', 'employeeName', 'sys_User_employeeName', '员工姓名', '员工姓名', 'String', '', '', '', '', '0', '', '0', '0', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_User', 'phone', 'sys_User_phone', '手机', '手机', 'String', '', '', '', '', '0', '', '0', '0', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_User', 'email', 'sys_User_email', '邮箱', '邮箱', 'String', '', '', '', '', '0', '', '0', '0', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_User', 'lastLoginTime', 'sys_User_lastLoginTime', '最近一次登录时间', '最近一次登录时间', 'datetime', '', '', '', '', '0', '', '0', '1', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_User', 'lastModifiedPwdTime', 'sys_User_lastModifiedPwdTime', '上次修改密码时间', '上次修改密码时间', 'datetime', '', '', '', '', '0', '', '0', '1', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_User', 'createUser', 'sys_User_createUser', '创建用户', '创建用户', 'String', '', '', '', '', '0', '', '0', '1', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_User', 'createTime', 'sys_User_createTime', '创建时间', '创建时间', 'datetime', '', '', '', '', '0', '', '0', '1', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_User', 'modifiedUser', 'sys_User_modifiedUser', '修改用户', '修改用户', 'String', '', '', '', '', '0', '', '0', '1', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_User', 'modifiedTime', 'sys_User_modifiedTime', '修改时间', '修改时间', 'datetime', '', '', '', '', '0', '', '0', '1', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');

 -- 表格信息
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', '', 'sys_User_username','1', '', '1', 1, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', '', 'sys_User_username','1', '', '1', 1, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', '', 'sys_User_password','1', '', '1', 2, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', '', 'sys_User_password','1', '', '1', 2, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', '', 'sys_User_salt','1', '', '0', 3, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', '', 'sys_User_salt','1', '', '0', 3, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', '', 'sys_User_userType','1', '', '1', 4, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', '', 'sys_User_userType','1', '', '1', 4, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', '', 'sys_User_isLocked','1', '', '1', 5, 80, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', '', 'sys_User_isLocked','1', '', '1', 5, 80, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', '', 'sys_User_stationCode','1', '', '1', 6, 80, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', '', 'sys_User_stationCode','1', '', '1', 6, 80, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', '', 'sys_User_departmentId','1', '', '0', 7, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', '', 'sys_User_departmentId','1', '', '0', 7, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', '', 'sys_User_employeeName','1', '', '1', 8, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', '', 'sys_User_employeeName','1', '', '1', 8, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', '', 'sys_User_phone','1', '', '1', 9, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', '', 'sys_User_phone','1', '', '1', 9, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', '', 'sys_User_email','1', '', '1', 10, 160, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', '', 'sys_User_email','1', '', '1', 10, 160, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', '', 'sys_User_lastLoginTime','1', '', '1', 11, 160, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', '', 'sys_User_lastLoginTime','1', '', '1', 11, 160, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', '', 'sys_User_lastModifiedPwdTime','1', '', '1', 12, 160, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', '', 'sys_User_lastModifiedPwdTime','1', '', '1', 12, 160, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', '', 'sys_User_createUser','1', '', '1', 13, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', '', 'sys_User_createUser','1', '', '1', 13, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', '', 'sys_User_createTime','1', '', '1', 14, 160, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', '', 'sys_User_createTime','1', '', '1', 14, 160, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', '', 'sys_User_modifiedUser','1', '', '1', 15, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', '', 'sys_User_modifiedUser','1', '', '1', 15, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', '', 'sys_User_modifiedTime','1', '', '1', 16, 160, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', '', 'sys_User_modifiedTime','1', '', '1', 16, 160, null, '1', null, '0');

 -- 表单信息
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', 'sys_User_username_default_1', 'sys_User_username', '0', '', '1', 1, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', 'sys_User_username_admin_1', 'sys_User_username', '0', '', '1', 1, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', 'sys_User_password_default_1', 'sys_User_password', '0', '', '1', 2, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', 'sys_User_password_admin_1', 'sys_User_password', '0', '', '1', 2, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', 'sys_User_userType_default_1', 'sys_User_userType', '0', '', '1', 3, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', 'sys_User_userType_admin_1', 'sys_User_userType', '0', '', '1', 3, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', 'sys_User_isLocked_default_1', 'sys_User_isLocked', '0', '', '1', 4, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', 'sys_User_isLocked_admin_1', 'sys_User_isLocked', '0', '', '1', 4, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', 'sys_User_stationCode_default_1', 'sys_User_stationCode', '0', '', '1', 5, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', 'sys_User_stationCode_admin_1', 'sys_User_stationCode', '0', '', '1', 5, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', 'sys_User_employeeName_default_1', 'sys_User_employeeName', '0', '', '1', 6, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', 'sys_User_employeeName_admin_1', 'sys_User_employeeName', '0', '', '1', 6, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', 'sys_User_phone_default_1', 'sys_User_phone', '0', '', '1', 7, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', 'sys_User_phone_admin_1', 'sys_User_phone', '0', '', '1', 7, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_default_1', 'sys_User_email_default_1', 'sys_User_email', '0', '', '1', 8, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_User_admin_1', 'sys_User_email_admin_1', 'sys_User_email', '0', '', '1', 8, 135, 100, '', null, '0');

 -- 自定义下拉项信息
insert into sys_SelectItem(tableName, fieldName, content, english, traditionalCN, japanese, german, spanish, russian, french, korean) 
values('sys_User','userType', '{"0":"普通用户","1":"流水线终端","2":"报工终端","3":"看板终端"}', '', '', '', '', '', '', '', '');
insert into sys_SelectItem(tableName, fieldName, content, english, traditionalCN, japanese, german, spanish, russian, french, korean) 
values('sys_User','isLocked', '{"0":"不禁用","1":"禁用"}', '', '', '', '', '', '', '', '');

-- 角色信息
insert into sys_TableDef(tableName, defaultName, displayName, orderBy, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_Role', '角色信息', '角色信息', 'id', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');

 -- 默认的空的过滤方案
insert into sys_FilterScheme(tableName, username, lineid, schemeName, content, isSaved, descript) 
values('sys_Role', 'default', '1', '方案一', '', '1', '');
insert into sys_FilterScheme(tableName, username, lineid, schemeName, content, isSaved, descript) 
values('sys_Role', 'admin', '1', '方案一', '', '1', '');


insert into sys_TableScheme(tableName, username, lineid, schemeName, orderBy, customName, descript) 
values('sys_Role', 'default', '1', '方案一', 'id','','');
insert into sys_TableScheme(tableName, username, lineid, schemeName, orderBy, customName, descript) 
values('sys_Role', 'admin', '1', '方案一', 'id','','');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_Role', 'roleCode', 'sys_Role_roleCode', '角色代码', '角色代码', 'String', '', '', '', '', '0', '', '1', '0', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_Role', 'roleName', 'sys_Role_roleName', '角色名称', '角色名称', 'String', '', '', '', '', '0', '', '1', '0', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_Role', 'priority', 'sys_Role_priority', '显示顺序', '显示顺序', 'int', '', '', '', '', '0', '', '0', '0', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_Role', 'available', 'sys_Role_available', '是否可用', '是否可用', 'String', '', '', '', '', '3', '', '0', '0', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_Role', 'userNum', 'sys_Role_userNum', '用户数', '用户数', 'int', '', '', '', '', '0', '', '0', '1', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_Role', 'createUser', 'sys_Role_createUser', '创建用户', '创建用户', 'String', '', '', '', '', '0', '', '0', '1', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_Role', 'createTime', 'sys_Role_createTime', '创建时间', '创建时间', 'datetime', '', '', '', '', '0', '', '0', '1', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_Role', 'modifiedUser', 'sys_Role_modifiedUser', '修改用户', '修改用户', 'String', '', '', '', '', '0', '', '0', '1', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_Role', 'modifiedTime', 'sys_Role_modifiedTime', '修改时间', '修改时间', 'datetime', '', '', '', '', '0', '', '0', '1', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
insert into sys_FieldDef(tableName, fieldName, wholeFieldName, defaultName, displayName, fieldType, relateTable, originField, relateField, displayField, displayType, changeable, isRequired, noEdit, maxLength, defaultInt, defaultStr, defaultDouble, formula, descript, defaultEnglish, defaultTraditionalCN, defaultJapanese, defaultGerman, defaultSpanish, defaultRussian, defaultFrench, defaultKorean, displayEnglish, displayTraditionalCN, displayJapanese, displayGerman, displaySpanish, displayRussian, displayFrench, displayKorean) 
values('sys_Role', 'descript', 'sys_Role_descript', '描述', '描述', 'String', '', '', '', '', '0', '', '0', '0', null, null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');

 -- 表格信息
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_default_1', '', 'sys_Role_roleCode','1', '', '1', 1, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_admin_1', '', 'sys_Role_roleCode','1', '', '1', 1, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_default_1', '', 'sys_Role_roleName','1', '', '1', 2, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_admin_1', '', 'sys_Role_roleName','1', '', '1', 2, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_default_1', '', 'sys_Role_priority','1', '', '0', 3, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_admin_1', '', 'sys_Role_priority','1', '', '0', 3, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_default_1', '', 'sys_Role_available','1', '', '1', 4, 80, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_admin_1', '', 'sys_Role_available','1', '', '1', 4, 80, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_default_1', '', 'sys_Role_userNum','1', '', '1', 5, 80, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_admin_1', '', 'sys_Role_userNum','1', '', '1', 5, 80, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_default_1', '', 'sys_Role_createUser','1', '', '1', 6, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_admin_1', '', 'sys_Role_createUser','1', '', '1', 6, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_default_1', '', 'sys_Role_createTime','1', '', '1', 7, 160, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_admin_1', '', 'sys_Role_createTime','1', '', '1', 7, 160, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_default_1', '', 'sys_Role_modifiedUser','1', '', '1', 8, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_admin_1', '', 'sys_Role_modifiedUser','1', '', '1', 8, 100, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_default_1', '', 'sys_Role_modifiedTime','1', '', '1', 9, 160, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_admin_1', '', 'sys_Role_modifiedTime','1', '', '1', 9, 160, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_default_1', '', 'sys_Role_descript','1', '', '1', 10, 200, null, '1', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_admin_1', '', 'sys_Role_descript','1', '', '1', 10, 200, null, '1', null, '0');

 -- 表单信息
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_default_1', 'sys_Role_roleCode_default_1', 'sys_Role_roleCode', '0', '', '1', 1, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_admin_1', 'sys_Role_roleCode_admin_1', 'sys_Role_roleCode', '0', '', '1', 1, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_default_1', 'sys_Role_roleName_default_1', 'sys_Role_roleName', '0', '', '1', 2, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_admin_1', 'sys_Role_roleName_admin_1', 'sys_Role_roleName', '0', '', '1', 2, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_default_1', 'sys_Role_available_default_1', 'sys_Role_available', '0', '', '1', 3, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_admin_1', 'sys_Role_available_admin_1', 'sys_Role_available', '0', '', '1', 3, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_default_1', 'sys_Role_userNum_default_1', 'sys_Role_userNum', '0', '', '1', 4, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_admin_1', 'sys_Role_userNum_admin_1', 'sys_Role_userNum', '0', '', '1', 4, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_default_1', 'sys_Role_descript_default_1', 'sys_Role_descript', '0', '', '1', 5, 135, 100, '', null, '0');
insert into sys_FieldDefDtl(relateScheme, dtlName, wholeFieldName, dtlType, relateDtlName, visible, priority, width, textWidth, sortable, precisionDigits, thousandsSeparator) 
values('sys_Role_admin_1', 'sys_Role_descript_admin_1', 'sys_Role_descript', '0', '', '1', 5, 135, 100, '', null, '0');

 -- 自定义下拉项信息
insert into sys_SelectItem(tableName, fieldName, content, english, traditionalCN, japanese, german, spanish, russian, french, korean) 
values('sys_Role','available', '{"0":"可用","1":"不可用"}', '', '', '', '', '', '', '', '');
