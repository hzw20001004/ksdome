CREATE TABLE  hsys_user
(
    id BIGINT(20)  PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT '主键ID',
    name VARCHAR(30) NULL DEFAULT NULL,
    age INT NULL DEFAULT NULL ,
    email VARCHAR(50) NULL DEFAULT NULL,
    salt varchar(50)  DEFAULT NULL,
    create_user INT NULL ,
    create_time datetime NULL DEFAULT NULL ,
    update_user VARCHAR(50) NULL DEFAULT NULL ,
    update_time datetime NULL DEFAULT NULL

);
INSERT INTO hsys_user ( name, age, email) VALUES
( 'Jone', 18, 'test1@baomidou.com'),
( 'Jack', 20, 'test2@baomidou.com'),
( 'Tom', 28, 'test3@baomidou.com'),
( 'Sandy', 21, 'test4@baomidou.com'),
( 'Billie', 24, 'test5@baomidou.com'),
( '韩泽炜', 19, '508578631@qq.com');
select *
from hsys_user;


CREATE TABLE  databasesource
(
    id BIGINT(20)  PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT '主键ID',
    DatasourceId          varchar(225)                   NULL,
    url          varchar(225)                   NULL,
    user_name    varchar(225)                   NULL,
    pass_word    varchar(225)                   NULL,
    code         varchar(225)                   NULL,
    databasetype varchar(225)                   NULL,
    create_user INT  NULL ,
    create_time datetime   NULL  ,
    update_user VARCHAR(50)   NULL  ,
    update_time datetime   NULL
);
INSERT INTO databasesource(DatasourceId, url, user_name, pass_word, code, databasetype)
VALUES ('ks','jdbc:sqlserver://192.168.1.222;DatabaseName=mis032021','sa', 'root', NULL, 'sqlserver'),
       ('tses','jdbc:sqlserver://192.168.1.222;DatabaseName=MISch2020','sa', 'root', NULL, 'sqlserver');
select *
from databasesource;