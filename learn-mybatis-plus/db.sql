create database if not exists mp DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
use mp;

DROP TABLE if exists `user`;
CREATE TABLE `user`
(
    `id`              int unsigned NOT NULL AUTO_INCREMENT,
    `name`            varchar(30)  NOT NULL DEFAULT '' COMMENT '姓名',
    `age`             tinyint(4)   NOT NULL DEFAULT '0' COMMENT '密码',
    `address_ids`     varchar(200) NOT NULL DEFAULT '' COMMENT '地址ids',
    `created_at`      datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`      datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `data_updated_at` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
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