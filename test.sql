CREATE TABLE `student`
(
    `id`         int(10) unsigned NOT NULL AUTO_INCREMENT,
    `name`       varchar(20) NOT NULL DEFAULT '' COMMENT '姓名',
    `age`        tinyint(4) NOT NULL DEFAULT '0' COMMENT '年龄',
    `created_at` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生表';

CREATE TABLE `teacher`
(
    `id`         int(10) unsigned NOT NULL AUTO_INCREMENT,
    `name`       varchar(20) NOT NULL DEFAULT '' COMMENT '姓名',
    `age`        tinyint(4) NOT NULL DEFAULT '0' COMMENT '年龄',
    `created_at` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='教师表';

CREATE TABLE `user`
(
    `id`         int(10) unsigned NOT NULL AUTO_INCREMENT,
    `username`   varchar(20) NOT NULL DEFAULT '' COMMENT '账号',
    `password`   varchar(30) NOT NULL DEFAULT '0' COMMENT '密码',
    `name`       varchar(30) NOT NULL DEFAULT '0' COMMENT '姓名',
    `created_at` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

CREATE TABLE `orders`
(
    `id`         int(10) unsigned NOT NULL AUTO_INCREMENT,
    `sn`         varchar(200) NOT NULL DEFAULT '' COMMENT '订单编号',
    `user_id`    int(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
    `created_at` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';