drop table if exists sys_Department;
drop table if exists sys_Role;
drop table if exists sys_Resource;
drop table if exists sys_User;
drop table if exists sys_RoleResource;
drop table if exists sys_UserRole;
drop table if exists sys_UserLog;
drop table if exists sys_AUTO_INCREMENTLog;
drop table if exists sys_TableDef;
drop table if exists sys_TableScheme;
drop table if exists sys_FieldDef;
drop table if exists sys_FieldDefDtl;
drop table if exists sys_SelectItem;
drop table if exists sys_FilterScheme;
drop table if exists sys_Config;
drop table if exists sys_FormDef;
drop table if exists sys_RecycleBin;
drop table if exists sys_Message;
drop table if exists sys_Document;
drop table if exists sys_Skin;

create table sys_Department (
	id int AUTO_INCREMENT,
	departmentName varchar(100),
	priority int,
	superivsor int,
	descript varchar(255),
	constraint pk_sys_Department primary key (id),
	constraint uk_sys_Department_010 unique (departmentName)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_Role (
	id int AUTO_INCREMENT,
	roleCode varchar(50),
	roleName varchar(100),
	priority int,
	available char(1),
	userNum int,
	descript varchar(255),
	createUser	varchar(60),
	createTime	datetime,
	modifiedUser	varchar(60),
	modifiedTime	datetime,
	constraint pk_sys_Role primary key (id),
	constraint uk_sys_Role_010 unique (roleCode)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_Resource (
	id int AUTO_INCREMENT,
	resourceCode varchar(100),
	resourceName varchar(100),
	permissionType char(1),
	priority int,
	parentCode varchar(100),
	permission varchar(100),
	available char(1),
	descript varchar(255),
	includedCmd varchar(255),
	constraint pk_sys_Resource primary key (id),
	constraint uk_sys_Resource_010 unique (resourceCode)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_User (
	id int AUTO_INCREMENT,
	username varchar(100),
	password varchar(100),
	salt varchar(100),
	departmentId int,
	isLocked char(1),
	employeeName varchar(100),
	phone varchar(50),
	email varchar(100),
	createUser	varchar(60),
	createTime	datetime,
	modifiedUser	varchar(60),
	modifiedTime	datetime,
	stationCode varchar(30),
	userType char(1),
	lastLoginTime	datetime,
	lastModifiedPwdTime	datetime,
	constraint pk_sys_User primary key (id),
	constraint uk_sys_User_010 unique (username)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_RoleResource (
	id int AUTO_INCREMENT,
	roleCode	varchar(50),
	resourceCode	varchar(100),
	constraint pk_sys_RoleResource primary key (id),
	constraint uk_sys_RoleResource_010 unique (roleCode, resourceCode)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_UserRole (
	id int AUTO_INCREMENT,
	username	varchar(60),
	roleCode	varchar(50),
	constraint pk_sys_UserRole primary key (id),
	constraint uk_sys_UserRole_010 unique (username, roleCode)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_UserLog (
	id int AUTO_INCREMENT,
	username	varchar(60),
	operateTime	datetime,
	ip	varchar(15),
	moduleName	varchar(20),
	descript	varchar(255),
	constraint pk_sys_UserLog primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_AUTO_INCREMENTLog (
	id int AUTO_INCREMENT,
	userId	int,
	operateType	varchar(10),
	ip	varchar(15),
	operateTime	datetime,
	constraint pk_sys_AUTO_INCREMENTLog primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_TableDef (
	id int AUTO_INCREMENT,
	tableName varchar(40),
	defaultName varchar(40),
	displayName varchar(40),
	orderBy varchar(255),
	descript varchar(255),
	defaultEnglish	varchar(60),
	defaultTraditionalCN	varchar(60),
	defaultJapanese	varchar(60),
	defaultGerman	varchar(60),
	defaultSpanish	varchar(60),
	defaultRussian	varchar(60),
	defaultFrench	varchar(60),
	defaultKorean	varchar(60),
	displayEnglish	varchar(60),
	displayTraditionalCN	varchar(60),
	displayJapanese	varchar(60),
	displayGerman	varchar(60),
	displaySpanish	varchar(60),
	displayRussian	varchar(60),
	displayFrench	varchar(60),
	displayKorean	varchar(60),
	constraint pk_sys__TableDef primary key (id),
	constraint uk_sys_TableDef_010 unique (tableName)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_TableScheme (
	id int AUTO_INCREMENT,
	tableName	varchar(40),
	username	varchar(60),
	lineid	int,
	schemeName	varchar(40),
	orderBy	varchar(255),
	customName	varchar(255),
	descript	varchar(255),
	constraint pk_sys_TableScheme primary key (id),
	constraint uk_sys_TableScheme_010 unique (tableName, username, lineid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_FieldDef (
	id int AUTO_INCREMENT,
	tableName varchar(40),
	fieldName varchar(40),
	wholeFieldName varchar(80),
	defaultName varchar(40),
	displayName varchar(40),
	fieldType	varchar(20),
	relateTable	varchar(40),
	originField varchar(40),
	relateField	varchar(40),
	displayField varchar(40),
	displayType	char(1),
	changeable	char(1),
	isRequired	char(1),
	noEdit	char(1),
	maxLength	int,
	defaultInt	int,
	defaultStr	varchar(255),
	defaultDouble	decimal(18,6),
	formula varchar(1000),
	descript	varchar(255),
	defaultEnglish	varchar(60),
	defaultTraditionalCN	varchar(60),
	defaultJapanese	varchar(60),
	defaultGerman	varchar(60),
	defaultSpanish	varchar(60),
	defaultRussian	varchar(60),
	defaultFrench	varchar(60),
	defaultKorean	varchar(60),
	displayEnglish	varchar(60),
	displayTraditionalCN	varchar(60),
	displayJapanese	varchar(60),
	displayGerman	varchar(60),
	displaySpanish	varchar(60),
	displayRussian	varchar(60),
	displayFrench	varchar(60),
	displayKorean	varchar(60),
	constraint pk_sys_FieldDef primary key (id),
	constraint uk_sys_FieldDef_010 unique (wholeFieldName)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_FieldDefDtl (
	id int AUTO_INCREMENT,
	relateScheme	varchar(120),
	dtlName	varchar(150),
	wholeFieldName	varchar(80),
	dtlType	char(1),
	relateDtlName	varchar(150),
	visible	char(1),
	priority	int,
	width	int,
	textWidth	int,
	sortable	char(1),
	precisionDigits	int,
	thousandsSeparator	char(1),
	constraint pk_sys_FieldDefDtl primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_SelectItem (
	id int AUTO_INCREMENT,
	tableName varchar(40),
	fieldName varchar(40),
	content	varchar(500),
	english	varchar(500),
	traditionalCN	varchar(500),
	japanese	varchar(500),
	german	varchar(500),
	spanish	varchar(500),
	russian	varchar(500),
	french	varchar(500),
	korean	varchar(500),
	constraint pk_sys_SelectedItem primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_FilterScheme (
	id int AUTO_INCREMENT,
	tableName	varchar(40),
	username	varchar(60),
	lineid	int,
	schemeName	varchar(40),
	content	varchar(2000),
	isSaved char(1),
	descript	varchar(255),
	constraint pk_sys_FilterScheme primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_Config (
	id int AUTO_INCREMENT,
	configName varchar(50),
	username varchar(60),
	moduleName varchar(30),
	descript varchar(255),
	intValue int,
	doubleValue decimal(18,6),
	datetimeValue datetime,
	strValue varchar(255),
	minQty decimal(18,6),
	maxQty decimal(18,6),
	constraint pk_sys_Config primary key (id),
	constraint uk_sys_Config_010 unique (configName)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_FormDef (
	id int AUTO_INCREMENT,
	fieldId int,
	priority int,
	width int,
	constraint pk_sys_FormDef primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_RecycleBin (
	id int AUTO_INCREMENT,
	binType	varchar(10),
	fileId	int,
	dirId	int,
	bomId	int,
	fileSize	decimal(15, 0),
	fileType	varchar(40),
	location	varchar(1000),
	version	varchar(40),
	deleteUser	varchar(60),
	deleteTime	datetime,
	lastModifiedTime	datetime,
	constraint pk_sys_RecycleBin primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_Message (
	id int AUTO_INCREMENT,
	relateId	int,
	subject	varchar(255),
	content	varchar(8000),
	sender	varchar(60),
	sendTime	datetime,
	recipients	varchar(5000),
	msgType	char(1),
	isRead	char(1),
	readTime	datetime,
	attachDoc	varchar(1000),
	constraint pk_sys_Message primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_Document (
	id int AUTO_INCREMENT,
	fileName	varchar(255),
	fileSize	bigint,
	fileType	varchar(100),
	createUser	varchar(60),
	createTime	datetime,
	fileVersion	varchar(40),
	modifiedUser	varchar(60),
	modifiedTime	datetime,
	filePath	varchar(1000),
	md5	char(32),
	descript	varchar(8000),
	def_str01	varchar(255),
	def_str02	varchar(255),
	def_str03	varchar(255),
	def_str04	varchar(255),
	def_str05	varchar(255),
	def_num01	decimal(18,6),
	def_num02	decimal(18,6),
	def_num03	decimal(18,6),
	def_num04	decimal(18,6),
	def_num05	decimal(18,6),
	def_date01	datetime,
	def_date02	datetime,
	def_date03	datetime,
	def_date04	datetime,
	def_date05	datetime,
	def_int01	int,
	def_int02	int,
	def_int03	int,
	def_int04	int,
	def_int05	int,
	constraint pk_sys_Document primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sys_Skin (
	id int AUTO_INCREMENT,
	username	varchar(60),
	headerColor	varchar(20),
	sideBarColor	varchar(20),
	constraint pk_sys_Skin primary key (id),
	constraint uk_sys_Skin_010 unique (username)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


