create database boke charset utf8mb4;
use boke;
--用户名
create table user (
id int primary key auto_increment comment '自增id',
username varchar(100) not null unique comment '用户名',
nickname varchar(100) not null comment'昵称',
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
--评论
create table comments (
id int primary key auto_increment comment '自增id',
user_id int not null comment '评论者id',
article_id int not null comment'评论文章id',
content varchar(200) not null comment'评论内容',
published_at datetime not null comment'发表时间'
);
--点赞关系
create table like_relations (
user_id int not null comment '评论者id',
article_id int not null comment'评论文章id',
primary key (user_id,article_id)
);