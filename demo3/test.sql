CREATE TABLE `user`
(
    `id`         int unsigned NOT NULL AUTO_INCREMENT,
    `username`   varchar(20) NOT NULL DEFAULT '' COMMENT '账号',
    `password`   varchar(30) NOT NULL DEFAULT '0' COMMENT '密码',
    `name`       varchar(30) NOT NULL DEFAULT '0' COMMENT '姓名',
    `created_at` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

CREATE TABLE `orders`
(
    `id`         int unsigned NOT NULL AUTO_INCREMENT,
    `sn`         varchar(200) NOT NULL DEFAULT '' COMMENT '订单编号',
    `user_id`    int          NOT NULL DEFAULT '0' COMMENT '用户ID',
    `created_at` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='订单表';


CREATE TABLE `address`
(
    `id`         int unsigned NOT NULL AUTO_INCREMENT,
    `name`       varchar(200) NOT NULL DEFAULT '' COMMENT '地址',
    `created_at` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='地址表';