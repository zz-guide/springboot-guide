CREATE TABLE `student`
(
    `id`         int(10) unsigned NOT NULL AUTO_INCREMENT,
    `name`       varchar(20) NOT NULL DEFAULT '' COMMENT '姓名',
    `age`        tinyint(4) NOT NULL DEFAULT '0' COMMENT '年龄',
    `created_at` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生表';