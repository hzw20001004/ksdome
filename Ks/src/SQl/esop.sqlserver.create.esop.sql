drop table if exists esop_File;
drop table if exists esop_FileDir;
drop table if exists esop_ProdLine;
drop table if exists esop_Station;
drop table if exists esop_WorkTemplate;
drop table if exists esop_TempDetail;
drop table if exists esop_WorkInfo;
drop table if exists esop_Notice;
drop table if exists esop_NoticeDetail;
drop table if exists esop_Product;
drop table if exists esop_AndonItem;
drop table if exists esop_AndonRecord;
drop table if exists esop_Config;
drop table if exists esop_ProductPlan;
drop table if exists esop_ProductReport;
drop table if exists esop_CustomLib;
drop table if exists esop_ProcedureDictionary;
drop table if exists esop_Dept;
drop table if exists esop_ProcessRoute;
drop table if exists esop_ProcessRouteEntry;
drop table if exists esop_ProcReqmst;
drop table if exists esop_ProcReqdtl;
drop table if exists esop_KanBanParam;
drop table if exists esop_KanBanExcel;
drop table if exists esop_KanBanFile;
drop view if exists view_productPlanProgress;
drop view if exists view_productPlanProgress2;



create table esop_File (
    id int AUTO_INCREMENT,
    fileName varchar(255),
	fileSize varchar(20),
	dirId int,
	fileType varchar(100),
	createUser varchar(60),
	createTime datetime,
	fileVersion varchar(40),
	modifiedUser varchar(60),
	modifiedTime datetime,
	releaseTime datetime,
	filePath varchar(1000),
	remarks varchar(255),
	state varchar(20),
	md5 char(32),
	source char(1),
	sourceId int,
	productCode varchar(255),
	procedureName	varchar(255),
	isBadPicture char(1),
	reviewState char(1),
	freezeState char(1),
	def_str01	varchar(255),
	def_str02	varchar(255),
	def_str03	varchar(255),
	def_str04	varchar(255),
	def_str05	varchar(255),
	def_str06	varchar(255),
	def_str07	varchar(255),
	def_str08	varchar(255),
	def_str09	varchar(255),
	def_str10	varchar(255),
	def_num01	decimal(18,6),
	def_num02	decimal(18,6),
	def_num03	decimal(18,6),
	def_num04	decimal(18,6),
	def_num05	decimal(18,6),
	def_num06	decimal(18,6),
	def_num07	decimal(18,6),
	def_num08	decimal(18,6),
	def_num09	decimal(18,6),
	def_num10	decimal(18,6),
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
    constraint pk_esop_File primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_FileDir (
    id int AUTO_INCREMENT,
	parentId int,
	dirLevel int,
	dirName varchar(255),
	dirPath varchar(1000),
	createUser varchar(60),
	createTime datetime,
	modifiedUser varchar(60),
	modifiedTime datetime,
	fileNumber int,
	dirNumber int,
	remarks varchar(255),
	def_str01	varchar(255),
	def_str02	varchar(255),
	def_str03	varchar(255),
	def_num01	decimal(18,6),
	def_num02	decimal(18,6),
	def_num03	decimal(18,6),
	def_date01	datetime,
	def_date02	datetime,
	def_int01	int,
	def_int02	int,
	def_int03	int,
    constraint pk_esop_FileDir primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_ProdLine (
    id int AUTO_INCREMENT,
	lineName varchar(255),
	workshopId int,
	createUser varchar(60),
	createTime datetime,
	modifiedUser varchar(60),
	modifiedTime datetime,
	remarks varchar(255),
	employees varchar(2000),
	enableReceive char(1),
	enableStart char(1),
	autoComplete char(1),
	def_str01	varchar(255),
	def_str02	varchar(255),
	def_str03	varchar(255),
	def_num01	decimal(18,6),
	def_num02	decimal(18,6),
	def_num03	decimal(18,6),
	def_date01	datetime,
	def_date02	datetime,
	def_date03	datetime,
	def_int01	int,
	def_int02	int,
	def_int03	int,
    constraint pk_esop_ProdLine primary key (id),
    constraint uk_esop_ProdLine_010 unique (lineName)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_Station (
    id int AUTO_INCREMENT,
	stationCode varchar(60),
	stationName varchar(255),
	prodLineId int,
	procedureName	varchar(255),
	type char(1),
	pagingTime int,
	state char(1),
	lastActiveTime datetime,
	andon char(1),
	ip varchar(16),
	createUser varchar(60),
	createTime datetime,
	modifiedUser varchar(60),
	modifiedTime datetime,
	remarks varchar(255),
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
	def_int01	int,
	def_int02	int,
	def_int03	int,
    constraint pk_esop_Station primary key (id),
    constraint uk_esop_Station_010 unique (stationCode)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_WorkTemplate (
    id int AUTO_INCREMENT,
	templateName varchar(255),
	productCode varchar(255),
	prodLineId int,
	createUser varchar(60),
	createTime datetime,
	modifiedUser varchar(60),
	modifiedTime datetime,
	remarks varchar(255),
	def_str01	varchar(255),
	def_str02	varchar(255),
	def_str03	varchar(255),
	def_num01	decimal(18,6),
	def_num02	decimal(18,6),
	def_num03	decimal(18,6),
	def_date01	datetime,
	def_date02	datetime,
	def_int01	int,
	def_int02	int,
	def_int03	int,
    constraint pk_esop_WorkTemplate primary key (id),
    constraint uk_esop_WorkTemplate_010 unique (templateName)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_TempDetail (
    id int AUTO_INCREMENT,
	templateId int,
	stationCode varchar(60),
	fileId int,
	displayPages varchar(255),
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
	def_int01	int,
	def_int02	int,
	def_int03	int,
    constraint pk_esop_TempDetail primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8; 

create table esop_WorkInfo (
    id int AUTO_INCREMENT,
	stationCode varchar(60),
	productCode varchar(255),
	fileId int,
	startTime datetime,
	endTime datetime,
	state char(1),
	distributeUser varchar(60),
	distributeTime datetime,
	createUser varchar(60),
	createTime datetime,
	modifiedUser varchar(60),
	modifiedTime datetime,
	displayPages varchar(255),
	def_str01	varchar(255),
	def_str02	varchar(255),
	def_str03	varchar(255),
	def_str04	varchar(255),
	def_str05	varchar(255),
	def_str06	varchar(255),
	def_str07	varchar(255),
	def_str08	varchar(255),
	def_str09	varchar(255),
	def_str10	varchar(255),
	def_num01	decimal(18,6),
	def_num02	decimal(18,6),
	def_num03	decimal(18,6),
	def_num04	decimal(18,6),
	def_num05	decimal(18,6),
	def_num06	decimal(18,6),
	def_num07	decimal(18,6),
	def_num08	decimal(18,6),
	def_num09	decimal(18,6),
	def_num10	decimal(18,6),
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
    constraint pk_esop_WorkInfo primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8; 

create table esop_Notice (
    id int AUTO_INCREMENT,
	noticeName varchar(255),
	state char(1),
	isFrozen char(1),
	content varchar(1000),
	createUser varchar(60),
	createTime datetime,
	modifiedUser varchar(60),
	modifiedTime datetime,
	remarks varchar(255),
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
	def_int01	int,
	def_int02	int,
	def_int03	int,
    constraint pk_esop_Notice primary key (id),
    constraint uk_esop_Notice_010 unique (noticeName)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_NoticeDetail (
    id int AUTO_INCREMENT,
	stationCode varchar(60),
	noticeName varchar(255),
	noticeContent varchar(1000),
	style char(1),
	state char(1),
	startTime datetime,
	endTime datetime,
	createUser varchar(60),
	createTime datetime,
	modifiedUser varchar(60),
	modifiedTime datetime,
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
	def_int01	int,
	def_int02	int,
	def_int03	int,
    constraint pk_esop_NoticeDetail primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8; 

create table esop_Product (
    id int AUTO_INCREMENT,
	productCode varchar(255),
	productName varchar(255),
	specification varchar(255),
	unit varchar(30),
	fileId int,
	createUser varchar(60),
	createTime datetime,
	modifiedUser varchar(60),
	modifiedTime datetime,
	remarks varchar(255),
	def_str01	varchar(255),
	def_str02	varchar(255),
	def_str03	varchar(255),
	def_str04	varchar(255),
	def_str05	varchar(255),
	def_str06	varchar(255),
	def_str07	varchar(255),
	def_str08	varchar(255),
	def_str09	varchar(255),
	def_str10	varchar(255),
	def_num01	decimal(18,6),
	def_num02	decimal(18,6),
	def_num03	decimal(18,6),
	def_num04	decimal(18,6),
	def_num05	decimal(18,6),
	def_num06	decimal(18,6),
	def_num07	decimal(18,6),
	def_num08	decimal(18,6),
	def_num09	decimal(18,6),
	def_num10	decimal(18,6),
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
    constraint pk_esop_Product primary key (id),
    constraint uk_esop_Product_010 unique (productCode)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_AndonItem (
    id int AUTO_INCREMENT,
	itemName varchar(255),
	descript varchar(500),
	color varchar(20),
	createUser varchar(60),
	createTime datetime,
	modifiedUser varchar(60),
	modifiedTime datetime,
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
	def_int01	int,
	def_int02	int,
	def_int03	int,
    constraint pk_esop_AndonItem primary key (id),
    constraint uk_esop_AndonItem_010 unique (itemName)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_AndonRecord (
    id int AUTO_INCREMENT,
	stationCode varchar(60),
	andonName varchar(255),
	state char(1),
	responseState char(1),
	handleState char(1),
	callPsn varchar(60),
	callTime datetime,
	responsePsn varchar(60),
	responseTime datetime,
	handlePsn varchar(60),
	handleTime datetime,
	remarks varchar(255),
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
	def_int01	int,
	def_int02	int,
	def_int03	int,
    constraint pk_esop_AndonRecord primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_Config (
    id int AUTO_INCREMENT,
	configName varchar(50),
	intValue int,
	doubleValue decimal(18,6),
	datetimeValue datetime,
	strValue varchar(255),
    constraint pk_esop_Config primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_ProductPlan (
	id int AUTO_INCREMENT,
	state char(1),
	sysno	varchar(60),
	contractno varchar(60),
	barcode	varchar(60),
	procReqdtlId int,
	stationCode varchar(60),
	procedureName	varchar(255),
	pickingState char(1),
	pickingTime datetime,
	productCode	varchar(255),
	planQty	decimal(18,6),
	completeQty	decimal(18,6),
	completionRate decimal(18,6),
	qualifiedQty	decimal(18,6),
	unqualifiedQty	decimal(18,6),
	scrapQty	decimal(18,6),
	employee	varchar(60),
	equipment	varchar(255),
	planStartdt datetime,
	planEnddt datetime,
	startdt	datetime,
	enddt	datetime,
	remarks	varchar(255),
	itemRemarks varchar(255),
	createUser	varchar(60),
	createTime	datetime,
	modifiedUser	varchar(60),
	modifiedTime	datetime,
	deliveryDate datetime,
	reworkTime datetime,
	type varchar(20),
	reworkQty decimal(18,6),
	isReceived char(1),
	stdTime int,
	wage decimal(18,6),
	pieceWage 	decimal(18,6),
	hourlyWage 	decimal(18,6),
	reworkTimes int,
	def_str01	varchar(255),
	def_str02	varchar(255),
	def_str03	varchar(255),
	def_str04	varchar(255),
	def_str05	varchar(255),
	def_str06	varchar(255),
	def_str07	varchar(255),
	def_str08	varchar(255),
	def_str09	varchar(255),
	def_str10	varchar(255),
	def_num01	decimal(18,6),
	def_num02	decimal(18,6),
	def_num03	decimal(18,6),
	def_num04	decimal(18,6),
	def_num05	decimal(18,6),
	def_num06	decimal(18,6),
	def_num07	decimal(18,6),
	def_num08	decimal(18,6),
	def_num09	decimal(18,6),
	def_num10	decimal(18,6),
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
	constraint pk_esop_ProductPlan primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_ProductReport (
	id int AUTO_INCREMENT,
	planId int,
	sysno	varchar(60),
	procedureName varchar(255),
	stationCode	varchar(60),
	productCode	varchar(255),
	reportQty	decimal(18,6),
	qualifiedQty	decimal(18,6),
	unqualifiedQty	decimal(18,6),
	scrapQty	decimal(18,6),
	reportdt	datetime,
	employee varchar(255),
	wage	decimal(18,6),
	pieceWage	decimal(18,6),
	hourlyWage	decimal(18,6),
	totalWages	decimal(18,6),
	remarks	varchar(255),
	createUser	varchar(60),
	createTime	datetime,
	modifiedUser	varchar(60),
	modifiedTime	datetime,
	def_str01	varchar(255),
	def_str02	varchar(255),
	def_str03	varchar(255),
	def_str04	varchar(255),
	def_str05	varchar(255),
	def_str06	varchar(255),
	def_str07	varchar(255),
	def_str08	varchar(255),
	def_str09	varchar(255),
	def_str10	varchar(255),
	def_num01	decimal(18,6),
	def_num02	decimal(18,6),
	def_num03	decimal(18,6),
	def_num04	decimal(18,6),
	def_num05	decimal(18,6),
	def_num06	decimal(18,6),
	def_num07	decimal(18,6),
	def_num08	decimal(18,6),
	def_num09	decimal(18,6),
	def_num10	decimal(18,6),
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
	constraint pk_esop_ProductReport primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_CustomLib (
	id int AUTO_INCREMENT,
	productCode varchar(60),
	fileId int,
	displayPages varchar(255),
	remarks	varchar(255),
	createUser	varchar(60),
	createTime	datetime,
	modifiedUser	varchar(60),
	modifiedTime	datetime,
	def_str01	varchar(255),
	def_str02	varchar(255),
	def_str03	varchar(255),
	def_str04	varchar(255),
	def_str05	varchar(255),
	def_str06	varchar(255),
	def_str07	varchar(255),
	def_str08	varchar(255),
	def_str09	varchar(255),
	def_str10	varchar(255),
	def_num01	decimal(18,6),
	def_num02	decimal(18,6),
	def_num03	decimal(18,6),
	def_num04	decimal(18,6),
	def_num05	decimal(18,6),
	def_num06	decimal(18,6),
	def_num07	decimal(18,6),
	def_num08	decimal(18,6),
	def_num09	decimal(18,6),
	def_num10	decimal(18,6),
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
	constraint pk_esop_CustomLib primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_ProcedureDictionary (
    id int AUTO_INCREMENT,
	procedureName	varchar(255),
	createUser	varchar(60),
	createTime	datetime,
	modifiedUser	varchar(60),
	modifiedTime	datetime,
	remarks	varchar(255),
	def_str01	varchar(255),
	def_str02	varchar(255),
	def_str03	varchar(255),
	def_str04	varchar(255),
	def_str05	varchar(255),
	def_num01	decimal(18,6),
	def_num02	decimal(18,6),
	def_date01	datetime,
	def_date02	datetime,
	def_int01	int,
	def_int02	int,
    constraint pk_esop_ProcedureDictionary primary key (id),
    constraint uk_esop_ProcedureDictionary_010 unique (procedureName)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;	


create table esop_Dept (
	id	int AUTO_INCREMENT,
	deptCode varchar(60),
	deptName varchar(255),
	processControl char(1),
	remarks varchar(255),
	createUser	varchar(60),
	createTime	datetime,
	modifiedUser	varchar(60),
	modifiedTime	datetime,
	def_str01 varchar(255),
	def_str02 varchar(255),
	def_str03 varchar(255),
	def_str04 varchar(255),
	def_str05 varchar(255),
	def_num01 decimal(18,6),
	def_num02 decimal(18,6),
	def_num03 decimal(18,6),
	def_num04 decimal(18,6),
	def_num05 decimal(18,6),
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
	constraint pk_esop_Dept primary key (id),
	constraint uk_esop_Dept unique (deptCode)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_ProcessRoute(
	id	int AUTO_INCREMENT,
	deptCode	varchar(60),
	productCode	varchar(60),
	remarks		varchar(255),
	createUser	varchar(60),
	createTime	datetime,
	modifiedUser	varchar(60),
	modifiedTime	datetime,
	def_str01	varchar(255),
	def_str02	varchar(255),
	def_str03	varchar(255),
	def_str04	varchar(255),
	def_str05	varchar(255),
	def_str06	varchar(255),
	def_str07	varchar(255),
	def_str08	varchar(255),
	def_str09	varchar(255),
	def_str10	varchar(255),
	def_num01	decimal(18,6),
	def_num02	decimal(18,6),
	def_num03	decimal(18,6),
	def_num04	decimal(18,6),
	def_num05	decimal(18,6),
	def_num06	decimal(18,6),
	def_num07	decimal(18,6),
	def_num08	decimal(18,6),
	def_num09	decimal(18,6),
	def_num10	decimal(18,6),
	def_date01	datetime,
	def_date02	datetime,
	def_date03	datetime,
	def_date04	datetime,
	def_date05	datetime,
	def_date06	datetime,
	def_date07	datetime,
	def_date08	datetime,
	def_date09	datetime,
	def_date10	datetime,
	def_int01	int,
	def_int02	int,
	def_int03	int,
	def_int04	int,
	def_int05	int,
	def_int06	int,
	def_int07	int,
	def_int08	int,
	def_int09	int,
	def_int10	int,
	constraint pk_esop_ProcessRoute primary key (id),
	constraint uk_esop_ProcessRoute unique (deptCode,productCode)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table esop_ProcessRouteEntry(
	id	int AUTO_INCREMENT,
	processRouteId int,
	linenumber	int,
	procedureName	varchar(255),
	prodLineId	int,
	stationCode	varchar(30),
	stdTime		int,
	wage		decimal(18,6),
	remarks		varchar(255),
	def_str01	varchar(255),
	def_str02	varchar(255),
	def_str03	varchar(255),
	def_str04	varchar(255),
	def_str05	varchar(255),
	def_str06	varchar(255),
	def_str07	varchar(255),
	def_str08	varchar(255),
	def_str09	varchar(255),
	def_str10	varchar(255),
	def_num01	decimal(18,6),
	def_num02	decimal(18,6),
	def_num03	decimal(18,6),
	def_num04	decimal(18,6),
	def_num05	decimal(18,6),
	def_num06	decimal(18,6),
	def_num07	decimal(18,6),
	def_num08	decimal(18,6),
	def_num09	decimal(18,6),
	def_num10	decimal(18,6),
	def_date01	datetime,
	def_date02	datetime,
	def_date03	datetime,
	def_date04	datetime,
	def_date05	datetime,
	def_date06	datetime,
	def_date07	datetime,
	def_date08	datetime,
	def_date09	datetime,
	def_date10	datetime,
	def_int01	int,
	def_int02	int,
	def_int03	int,
	def_int04	int,
	def_int05	int,
	def_int06	int,
	def_int07	int,
	def_int08	int,
	def_int09	int,
	def_int10	int,
	constraint pk_esop_ProcessRouteEntry primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_ProcReqmst(
	id	int AUTO_INCREMENT,
	reviewState	char(1),
	sysno	varchar(60),
	deliveryDate	datetime,
	contractno		varchar(60),
	customName	varchar(255),
	deptCode	varchar(60),
	productCode	varchar(60),
	planQty		decimal(18,6),
	planStartdt	datetime,
	planEnddt	datetime,
	remarks		varchar(255),
	barcode	varchar(60),
	createUser	varchar(60),
	createTime	datetime,
	modifiedUser	varchar(60),
	modifiedTime	datetime,
	def_str01	varchar(255),
	def_str02	varchar(255),
	def_str03	varchar(255),
	def_str04	varchar(255),
	def_str05	varchar(255),
	def_str06	varchar(255),
	def_str07	varchar(255),
	def_str08	varchar(255),
	def_str09	varchar(255),
	def_str10	varchar(255),
	def_num01	decimal(18,6),
	def_num02	decimal(18,6),
	def_num03	decimal(18,6),
	def_num04	decimal(18,6),
	def_num05	decimal(18,6),
	def_num06	decimal(18,6),
	def_num07	decimal(18,6),
	def_num08	decimal(18,6),
	def_num09	decimal(18,6),
	def_num10	decimal(18,6),
	def_date01	datetime,
	def_date02	datetime,
	def_date03	datetime,
	def_date04	datetime,
	def_date05	datetime,
	def_date06	datetime,
	def_date07	datetime,
	def_date08	datetime,
	def_date09	datetime,
	def_date10	datetime,
	def_int01	int,
	def_int02	int,
	def_int03	int,
	def_int04	int,
	def_int05	int,
	def_int06	int,
	def_int07	int,
	def_int08	int,
	def_int09	int,
	def_int10	int,
	constraint pk_esop_ProcReqmst primary key (id),
	constraint uk_esop_ProcReqmst unique (sysno)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



create table esop_ProcReqdtl(
	id	int AUTO_INCREMENT,
	procReqmstId	int,
	linenumber	int,
	procedureName	varchar(255),
	prodLineId	int,
	stationCode	varchar(30),
	stdTime	int,
	wage	decimal(18,6),
	planStartdt	datetime,
	planEnddt	datetime,
	employee	varchar(60),
	remarks		varchar(255),
	def_str01	varchar(255),
	def_str02	varchar(255),
	def_str03	varchar(255),
	def_str04	varchar(255),
	def_str05	varchar(255),
	def_str06	varchar(255),
	def_str07	varchar(255),
	def_str08	varchar(255),
	def_str09	varchar(255),
	def_str10	varchar(255),
	def_num01	decimal(18,6),
	def_num02	decimal(18,6),
	def_num03	decimal(18,6),
	def_num04	decimal(18,6),
	def_num05	decimal(18,6),
	def_num06	decimal(18,6),
	def_num07	decimal(18,6),
	def_num08	decimal(18,6),
	def_num09	decimal(18,6),
	def_num10	decimal(18,6),
	def_date01	datetime,
	def_date02	datetime,
	def_date03	datetime,
	def_date04	datetime,
	def_date05	datetime,
	def_date06	datetime,
	def_date07	datetime,
	def_date08	datetime,
	def_date09	datetime,
	def_date10	datetime,
	def_int01	int,
	def_int02	int,
	def_int03	int,
	def_int04	int,
	def_int05	int,
	def_int06	int,
	def_int07	int,
	def_int08	int,
	def_int09	int,
	def_int10	int,
	constraint pk_esop_ProcReqdtl primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_KanBanParam (
	id int AUTO_INCREMENT,
	kanBanCode varchar(60),
	type	varchar(10),
	templateNo	int,
	companyName	varchar(255),
	boardName	varchar(255),
	fontSize	int,
	rowNum	int,
	pagingTime	int,
	tableHead	varchar(1000),
	columnWidth	varchar(1000),
	headHeight int,
	headFontSize int,
	headBgColor varchar(20),
	bodyHeight int,
	bodyFontSize int,
	bodyBgColor varchar(20),
	colorInterval varchar(20),
	intervalRowNum int,
	excelName varchar(255),
	sqlQuery varchar(2000),
	notice varchar(1000),
	noticeFontSize int,
	noticeHeight int,
	createUser	varchar(60),
	createTime	datetime,
	modifiedUser	varchar(60),
	modifiedTime	datetime,
	lastActiveTime datetime,
	columnFormat varchar(255),
	def_str01	varchar(255),
	def_str02	varchar(255),
	def_str03	varchar(255),
	def_str04	varchar(255),
	def_str05	varchar(255),
	def_str06	varchar(255),
	def_str07	varchar(255),
	def_str08	varchar(255),
	def_str09	varchar(255),
	def_str10	varchar(255),
	def_num01	decimal(18,6),
	def_num02	decimal(18,6),
	def_num03	decimal(18,6),
	def_num04	decimal(18,6),
	def_num05	decimal(18,6),
	def_num06	decimal(18,6),
	def_num07	decimal(18,6),
	def_num08	decimal(18,6),
	def_num09	decimal(18,6),
	def_num10	decimal(18,6),
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
	constraint pk_esop_KanBanParam primary key (id),
	constraint uk_esop_KanBanParam_010 unique (kanBanCode)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_KanBanExcel (
	id int AUTO_INCREMENT,
	kanbanCode	varchar(60),
	def_str01	varchar(255),
	def_str02	varchar(255),
	def_str03	varchar(255),
	def_str04	varchar(255),
	def_str05	varchar(255),
	def_str06	varchar(255),
	def_str07	varchar(255),
	def_str08	varchar(255),
	def_str09	varchar(255),
	def_str10	varchar(255),
	def_str11	varchar(255),
	def_str12	varchar(255),
	def_str13	varchar(255),
	def_str14	varchar(255),
	def_str15	varchar(255),
	def_str16	varchar(255),
	def_str17	varchar(255),
	def_str18	varchar(255),
	def_str19	varchar(255),
	def_str20	varchar(255),
	def_str21	varchar(255),
	def_str22	varchar(255),
	def_str23	varchar(255),
	def_str24	varchar(255),
	def_str25	varchar(255),
	def_str26	varchar(255),
	def_str27	varchar(255),
	def_str28	varchar(255),
	def_str29	varchar(255),
	def_str30	varchar(255),
	def_str31	varchar(255),
	def_str32	varchar(255),
	def_str33	varchar(255),
	def_str34	varchar(255),
	def_str35	varchar(255),
	def_str36	varchar(255),
	def_str37	varchar(255),
	def_str38	varchar(255),
	def_str39	varchar(255),
	def_str40	varchar(255),
	constraint pk_esop_KanBanExcel primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table esop_KanBanFile (
	id int AUTO_INCREMENT,
	kanbanCode	varchar(60),
	fileName	varchar(255),
	type	varchar(20),
	priority	int,
	filePath	varchar(255),
	constraint pk_esop_KanBanFile primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE VIEW view_productPlanProgress AS
select
	(select state from esop_ProductPlan where esop_ProductPlan.sysno = result2.sysno and esop_ProductPlan.productCode = result2.productCode  order by id desc limit 1) state,
	(select DATEDIFF(now(),planEnddt) from esop_ProductPlan where esop_ProductPlan.sysno = result2.sysno order by id desc limit 1) overdueDays,
	(select planEnddt from esop_ProductPlan where esop_ProductPlan.sysno = result2.sysno order by id desc limit 1) planEnddt,
	sysno, contractno, productCode, productName, specification, unit,reworkTimes,
	(select planQty from esop_ProductPlan where esop_ProductPlan.sysno = result2.sysno order by id asc limit 1) planQty,	
		(select CAST(IFNULL(completeQty/nullif(planQty,0),0)*100 AS decimal(18,2)) from esop_ProductPlan where esop_ProductPlan.sysno = result2.sysno order by id desc limit 1) completionRate,
	 	CAST(IFNULL(SUM(unqualifiedQty)/nullif((select completeQty from esop_ProductPlan where esop_ProductPlan.sysno = result2.sysno order by id asc limit 1),0),0)*100 AS decimal(18,2)) unqualifiedRate,
 		CAST(IFNULL(SUM(scrapQty)/nullif((select completeQty from esop_ProductPlan where esop_ProductPlan.sysno = result2.sysno order by id asc limit 1),0),0)*100 AS decimal(18,2)) rejectionRate,
 	(select pickingState from esop_ProductPlan where esop_ProductPlan.sysno = result2.sysno order by id asc limit 1) pickingState,
 	(select createTime from esop_ProductPlan where esop_ProductPlan.sysno = result2.sysno order by id asc limit 1) createTime,
 	(select remarks from esop_ProductPlan where esop_ProductPlan.sysno = result2.sysno order by id asc limit 1) remarks 
 	from (select 
 	
 	pp.id, pp.state, barcode, sysno, pp.contractno, pp.stationCode, pp.procedureName, pickingState, pickingTime, pp.productCode, p.productName, 
    p.specification, p.remarks itemRemarks, p.unit, planQty, completeQty, qualifiedQty, unqualifiedQty, scrapQty, 
    employee, equipment, planStartdt, planEnddt,  startdt, enddt, pp.remarks, pp.createUser, pp.createTime, 
    pp.modifiedUser, pp.reworkTimes,
    pp.modifiedTime, s.stationName, pl.lineName prodLineName, pp.def_str01, pp.def_str02, pp.def_str03, 
    pp.def_str04, pp.def_str05, pp.def_str06, pp.def_str07, pp.def_str08, pp.def_str09, pp.def_str10, pp.def_num01, 
    pp.def_num02, pp.def_num03, pp.def_num04, pp.def_num05, pp.def_num06, pp.def_num07, pp.def_num08, pp.def_num09, 
    pp.def_num10, pp.def_date01, pp.def_date02, pp.def_date03, pp.def_date04, pp.def_date05, pp.def_int01, 
    pp.def_int02, pp.def_int03, pp.def_int04, pp.def_int05
 	
 	 from esop_ProductPlan pp
			left join esop_Product p on pp.productCode = p.productCode 
			left join esop_Station s on pp.stationCode = s.stationCode
			left join esop_ProdLine pl on s.prodLineId = pl.id) as result2
	group by sysno, contractno, reworkTimes, productCode, productName, specification, unit;


-- go
create view view_productPlanProgress2 as
select 
	case when (state = '0' or state = '1') and planEnddt < now() then '2' when state = '2' then '1' else '0' end state,
	case when state = '2' then null when overdueDays > 0 then overdueDays else null end overdueDays,
	planEnddt, sysno, contractno, productCode, productName, specification, unit, reworkTimes, planQty, completionRate, unqualifiedRate, rejectionRate,
	pickingState, createTime, remarks
	from view_productPlanProgress;