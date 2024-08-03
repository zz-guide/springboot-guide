create database if not exists db DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
use db;

DROP TABLE if exists `student`;
CREATE TABLE `student`
(
    `id`         int(10) unsigned NOT NULL AUTO_INCREMENT,
    `sn`         varchar(15)      NOT NULL DEFAULT '' COMMENT '学号',
    `name`       varchar(20)      NOT NULL DEFAULT '' COMMENT '姓名',
    `username`   varchar(32)      NOT NULL DEFAULT '' COMMENT '账号',
    `password`   varchar(40)      NOT NULL DEFAULT '' COMMENT '密码',
    `salt`       varchar(16)      NOT NULL DEFAULT '' COMMENT '密码盐',
    `mobile`     varchar(20)      NOT NULL DEFAULT '' COMMENT '手机号',
    `age`        tinyint(4)       NOT NULL DEFAULT '0' COMMENT '年龄',
    `gender`     tinyint(4)       NOT NULL DEFAULT '0' COMMENT '性别：1-男；2-女',
    `grade`      varchar(10)      NOT NULL DEFAULT '' COMMENT '年级:例如 三年级',
    `birthday`   date             NOT NULL DEFAULT '1970-01-01' COMMENT '生日',
    `created_at` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `sn` (`sn`) USING BTREE,
    KEY `mobile` (`mobile`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='学生表';

DROP TABLE if exists `user`;
CREATE TABLE `user`
(
    `id`         int unsigned NOT NULL AUTO_INCREMENT,
    `username`   varchar(20)  NOT NULL DEFAULT '' COMMENT '账号',
    `password`   varchar(30)  NOT NULL DEFAULT '' COMMENT '密码',
    `name`       varchar(30)  NOT NULL DEFAULT '' COMMENT '姓名',
    `created_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户表';

DROP TABLE if exists `orders`;
CREATE TABLE `orders`
(
    `id`         int unsigned NOT NULL AUTO_INCREMENT,
    `sn`         varchar(200) NOT NULL DEFAULT '' COMMENT '订单编号',
    `user_id`    int          NOT NULL DEFAULT '0' COMMENT '用户ID',
    `created_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `user_id` (`user_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单表';

DROP TABLE if exists `address`;
CREATE TABLE `address`
(
    `id`         int unsigned NOT NULL AUTO_INCREMENT,
    `name`       varchar(200) NOT NULL DEFAULT '' COMMENT '地址',
    `created_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='地址表';