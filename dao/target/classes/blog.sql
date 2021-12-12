DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`
(
    `id`          bigint(20)    NOT NULL COMMENT 'blog id',
    `body`        text          NOT NULL COMMENT '主体',
    `likes`       bigint(20)             DEFAULT 0 COMMENT '喜欢数',
    `topic`       varchar(1024)          DEFAULT NULL COMMENT '主题',
    `visit_count` bigint(20)             DEFAULT 0 COMMENT '浏览记录',
    `title`       varchar(1024) NOT NULL COMMENT '标题',
    `created`     timestamp(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated`     timestamp(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    `deleted`     timestamp(3) DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='博客表';

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id` bigint(20) NOT NULL COMMENT '用户id',
    `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
    `nickname` varchar(255) NOT NULL COMMENT '用户昵称',
    `status` varchar(16) DEFAULT 'NORMAL' NOT NULL COMMENT '状态',
    `role` varchar(64)  NOT NULL COMMENT '角色',
    `password`  varchar(1024) NOT NULL COMMENT '密码',
    `created` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_email` (`email`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

DROP TABLE IF EXISTS `user_operation_log`;
create table `user_operation_log`
(
    `request_id` bigint(20) NOT NULL COMMENT 'request_id',
    `method` varchar(64) DEFAULT NULL COMMENT '请求方法',
    `request_body` text DEFAULT NULL COMMENT '请求体',
    `response_body` text DEFAULT NULL COMMENT '响应体',
    `user_id` bigint(20) DEFAULT NULL COMMENT '请求者id',
    `request_params` text DEFAULT NULL COMMENT 'request参数',
    `status` int  DEFAULT NULL COMMENT '状态码',
    `url`   varchar(1024)   DEFAULT NULL  COMMENT 'url',
    `created` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (`request_id`),
    INDEX `idx_user_id` (user_id),
    INDEX `idx_created` (created)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='用户操作日志';

DROP TABLE IF EXISTS `time_record`;
create table `time_record`
(
    `id`          bigint(20)    NOT NULL COMMENT 'blog id',
    `timestamp`    timestamp(3) NOT NULL COMMENT '服务器起始运行时间',
    `created`     timestamp(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `updated`     timestamp(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    `deleted`     timestamp(3) DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='时间记录';