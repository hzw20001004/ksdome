drop table if exists sys_TableDef;
drop table if exists sys_TableScheme;
drop table if exists sys_FieldDef;
drop table if exists sys_FieldDefDtl;
drop table if exists sys_SelectItem;
drop table if exists sys_FilterScheme;

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
	lineId	int,
	schemeName	varchar(40),
	content	varchar(2000),
	isSaved char(1),
	descript	varchar(255),
	constraint pk_sys_FilterScheme primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
