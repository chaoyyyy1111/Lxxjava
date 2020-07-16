create database hjb_boke charset utf8mb4;
use hjb_boke;
--用户名
create table users (
id int primary key auto_increment comment '自增id',
username varchar(100) not null unique comment '用户名',
password varchar(100) not null comment'密码'
);
--文章
create table articles (
id int primary key auto_increment comment '自增id',
author_id int not null comment'作者id',
title varchar(200) not null comment '标题',
content text not null comment'正文',
published_at datetime not null comment'发表时间'
);