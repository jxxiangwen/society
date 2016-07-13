SELECT NOW();
DROP DATABASE IF EXISTS society;
CREATE DATABASE society
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_bin; #collate建议使用utf8-bin
SELECT NOW();
SHOW WARNINGS;
# SELECT NOW();
# DROP TABLE IF EXISTS example_db.example;
# CREATE TABLE example_db.example(                                                                #常规字段为 int,BIGINT,VARCHAR,text,TINYINT,timestamp
#   `iAutoID` int(10) UNSIGNED NOT NULL COMMENT 'comment' AUTO_INCREMENT,
#   `iIntID` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'comment',                              #财务相关字段，建议使用BIGINT
#   `sVar0` VARCHAR(5) NOT NULL DEFAULT '' COMMENT 'comment',                                       #VARCHAR字段，建议使用长度5,30,50,100,255,500,1000,5000
#   `sVar1` VARCHAR(30) NOT NULL DEFAULT '' COMMENT 'comment',
#   `sVar2` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'comment',
#   `sVar3` VARCHAR(100) NOT NULL DEFAULT '' COMMENT 'comment',
#   `sVar4` VARCHAR(255) NOT NULL DEFAULT '' COMMENT 'comment',
#   `sVar5` VARCHAR(500) NOT NULL DEFAULT '' COMMENT 'comment',
#   `sVar6` VARCHAR(1000) NOT NULL DEFAULT '' COMMENT 'comment',
#   `sVar7` VARCHAR(5000) NOT NULL DEFAULT '' COMMENT 'comment',                                    #使用该长度时，建议分表
#   `sDesc` text NOT NULL COMMENT 'comment',                                                        #存储json格式字段
#   `iStatus` TINYINT(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT 'comment',                             #系统字段，业务请勿使用
#   `iCreateTime` int(10) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '创建时间',                                             #系统字段，业务请勿使用
#   `iUpdateTime` int(10) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '更新时间',                                              #系统字段，业务请勿使用
#   PRIMARY KEY `idx_iAutoID` (`iAutoID`),                                                          #主键，请合理选择
#   KEY `idx_sVar1` (`sVar1`)                                                                       #请加必要的业务相关索引，命名规则为idx_field1_field2
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='comment';
# SELECT NOW();
USE society;

SELECT NOW();
DROP TABLE IF EXISTS user;
CREATE TABLE user (
  `id`          BIGINT(20) UNSIGNED NOT NULL
  COMMENT '主键'                               AUTO_INCREMENT,
  `user_id`     BIGINT(20)          NOT NULL DEFAULT 0
  COMMENT '学号',
  `user_name`   VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '姓名',
  `password`    VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '密码',
  `college`     VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '学院',
  `major`       VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '专业',
  `create_time` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '创建时间',
  `update_time` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '更新时间',
  PRIMARY KEY `idx_iAutoID` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '用户表';
SELECT NOW();

INSERT INTO user (user_id, user_name, password, college, major, create_time, update_time)
  VALUE
  (10000, 'zxw', 'YmNiMTVmODIxNDc5YjRkNTc3MmJkMGNhODY2YzAwYWQ1ZjkyNmUzNTgwNzIwNjU5Y2M4MGQzOWM5ZDA5ODAyYQ==', '计算机',
   '计算机', unix_timestamp(now()), unix_timestamp(now()));

SELECT NOW();
DROP TABLE IF EXISTS admin_user;
CREATE TABLE admin_user (
  `id`          BIGINT(20) UNSIGNED NOT NULL
  COMMENT '主键'                               AUTO_INCREMENT,
  `user_id`     BIGINT(20)          NOT NULL DEFAULT 0
  COMMENT '学号',
  `user_name`   VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '姓名',
  `password`    VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '密码',
  `college`     VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '学院',
  `major`       VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '专业',
  `create_time` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '创建时间',
  `update_time` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '更新时间',
  PRIMARY KEY `idx_iAutoID` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '管理员表';
SELECT NOW();

INSERT INTO admin_user (user_id, user_name, password, college, major, create_time, update_time)
  VALUE
  (10000, 'zxw', 'YmNiMTVmODIxNDc5YjRkNTc3MmJkMGNhODY2YzAwYWQ1ZjkyNmUzNTgwNzIwNjU5Y2M4MGQzOWM5ZDA5ODAyYQ==', '计算机',
   '计算机', unix_timestamp(now()), unix_timestamp(now()));

SELECT NOW();
DROP TABLE IF EXISTS vote_type;
CREATE TABLE vote_type (
  `id`               BIGINT(20) UNSIGNED NOT NULL
  COMMENT '主键'                                    AUTO_INCREMENT,
  `type_name`        VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '类别名',
  `parent_type_name` VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '父类别名',
  `create_time`      BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '创建时间',
  `update_time`      BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '更新时间',
  PRIMARY KEY `idx_iAutoID` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '投票类别表';
SELECT NOW();

INSERT INTO vote_type (type_name, parent_type_name, create_time, update_time)
  VALUE ('记名投票', '记名投票', unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO vote_type (type_name, parent_type_name, create_time, update_time)
  VALUE ('不记名投票', '记名投票', unix_timestamp(now()), unix_timestamp(now()));

SELECT NOW();
DROP TABLE IF EXISTS vote_topic;
CREATE TABLE vote_topic (
  `id`           BIGINT(20) UNSIGNED NOT NULL
  COMMENT '主键'                                AUTO_INCREMENT,
  `user_id`      BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '创建者学号',
  `title`        VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '投票主题',
  `start_time`   DATE NOT NULL
  COMMENT '开始时间',
  `end_time`     DATE NOT NULL
  COMMENT '结束时间',
  `vote_type_id` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '投票类别表ID',
  `create_time`  BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '创建时间',
  `update_time`  BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '更新时间',
  PRIMARY KEY `idx_iAutoID` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '投票主题表';
SELECT NOW();

INSERT INTO vote_topic (user_id, title, start_time, end_time, vote_type_id, create_time, update_time)
  VALUE (10000, '计算机学院调查记名投票', curdate(), '2017-4-19 00:00:00',
         (SELECT id
          FROM vote_type
          WHERE type_name = '记名投票'),
         unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO vote_topic (user_id, title, start_time, end_time, vote_type_id, create_time, update_time)
  VALUE (10000, '计算机学院调查不记名投票', curdate(), '2017-4-19 00:00:00',
         (SELECT id
          FROM vote_type
          WHERE type_name = '不记名投票'),
         unix_timestamp(now()), unix_timestamp(now()));

SELECT NOW();
DROP TABLE IF EXISTS vote_topic_number;
CREATE TABLE vote_topic_number (
  `id`                     BIGINT(20) UNSIGNED NOT NULL
  COMMENT '主键'                                          AUTO_INCREMENT,
  `vote_topic_id`          BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '投票项目属于的主题ID',
  `vote_topic_vote_number` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '主题ID总投票数',
  `create_time`            BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '创建时间',
  `update_time`            BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '更新时间',
  PRIMARY KEY `idx_iAutoID` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '投票数目表';
SELECT NOW();

SELECT NOW();
DROP TABLE IF EXISTS vote_subject_type;
CREATE TABLE vote_subject_type (
  `id`          BIGINT(20) UNSIGNED NOT NULL
  COMMENT '主键'                               AUTO_INCREMENT,
  `type_name`   VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '类别名',
  `create_time` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '创建时间',
  `update_time` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '更新时间',
  PRIMARY KEY `idx_iAutoID` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '投票项目类别表';
SELECT NOW();

INSERT INTO vote_subject_type (type_name, create_time, update_time)
  VALUE ('单选题', unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO vote_subject_type (type_name, create_time, update_time)
  VALUE ('多选题', unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO vote_subject_type (type_name, create_time, update_time)
  VALUE ('主观题', unix_timestamp(now()), unix_timestamp(now()));

SELECT NOW();
DROP TABLE IF EXISTS vote_subject;
CREATE TABLE vote_subject (
  `id`                   BIGINT(20) UNSIGNED NOT NULL
  COMMENT '主键'                                        AUTO_INCREMENT,
  `title`                VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '项目主题',
  `vote_subject_type_id` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '投票项目类别表ID',
  `vote_topic_id`        BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '投票项目属于的主题ID',
  `create_time`          BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '创建时间',
  `update_time`          BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '更新时间',
  PRIMARY KEY `idx_iAutoID` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '投票项目表';
SELECT NOW();


INSERT INTO vote_subject (title, vote_subject_type_id, vote_topic_id, create_time, update_time) VALUE
  ('记名投票---是否是男生？', (SELECT id
                     FROM vote_subject_type
                     WHERE type_name = '单选题'), (SELECT id
                                                FROM vote_topic
                                                WHERE title = '计算机学院调查记名投票'), unix_timestamp(now()),
   unix_timestamp(now()));
INSERT INTO vote_subject (title, vote_subject_type_id, vote_topic_id, create_time, update_time) VALUE
  ('记名投票---喜欢吃什么？', (SELECT id
                     FROM vote_subject_type
                     WHERE type_name = '多选题'), (SELECT id
                                                FROM vote_topic
                                                WHERE title = '计算机学院调查记名投票'), unix_timestamp(now()),
   unix_timestamp(now()));
INSERT INTO vote_subject (title, vote_subject_type_id, vote_topic_id, create_time, update_time) VALUE
  ('记名投票---有什么意见？', (SELECT id
                     FROM vote_subject_type
                     WHERE type_name = '主观题'), (SELECT id
                                                FROM vote_topic
                                                WHERE title = '计算机学院调查记名投票'), unix_timestamp(now()),
   unix_timestamp(now()));
INSERT INTO vote_subject (title, vote_subject_type_id, vote_topic_id, create_time, update_time) VALUE
  ('不记名投票---是否是男生？', (SELECT id
                      FROM vote_subject_type
                      WHERE type_name = '单选题'), (SELECT id
                                                 FROM vote_topic
                                                 WHERE title = '计算机学院调查不记名投票'), unix_timestamp(now()),
   unix_timestamp(now()));
INSERT INTO vote_subject (title, vote_subject_type_id, vote_topic_id, create_time, update_time) VALUE
  ('不记名投票---喜欢吃什么？', (SELECT id
                      FROM vote_subject_type
                      WHERE type_name = '多选题'), (SELECT id
                                                 FROM vote_topic
                                                 WHERE title = '计算机学院调查不记名投票'), unix_timestamp(now()),
   unix_timestamp(now()));
INSERT INTO vote_subject (title, vote_subject_type_id, vote_topic_id, create_time, update_time) VALUE
  ('不记名投票---有什么意见？', (SELECT id
                      FROM vote_subject_type
                      WHERE type_name = '主观题'), (SELECT id
                                                 FROM vote_topic
                                                 WHERE title = '计算机学院调查不记名投票'), unix_timestamp(now()),
   unix_timestamp(now()));


SELECT NOW();
DROP TABLE IF EXISTS vote_item;
CREATE TABLE vote_item (
  `id`              BIGINT(20) UNSIGNED NOT NULL
  COMMENT '主键'                                   AUTO_INCREMENT,
  `content`         VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '项目内容',
  `vote_subject_id` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '投票项目表ID',
  `create_time`     BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '创建时间',
  `update_time`     BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '更新时间',
  PRIMARY KEY `idx_iAutoID` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '项目选项表';
SELECT NOW();

INSERT INTO vote_item (content, vote_subject_id, create_time, update_time) VALUE
  ('男生', (SELECT id
          FROM vote_subject
          WHERE title =
                '记名投票---是否是男生？'), unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO vote_item (content, vote_subject_id, create_time, update_time) VALUE
  ('女生', (SELECT id
          FROM vote_subject
          WHERE title =
                '记名投票---是否是男生？'), unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO vote_item (content, vote_subject_id, create_time, update_time) VALUE
  ('苹果', (SELECT id
          FROM vote_subject
          WHERE title =
                '记名投票---喜欢吃什么？'), unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO vote_item (content, vote_subject_id, create_time, update_time) VALUE
  ('桃子', (SELECT id
          FROM vote_subject
          WHERE title =
                '记名投票---喜欢吃什么？'), unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO vote_item (content, vote_subject_id, create_time, update_time) VALUE
  ('草莓', (SELECT id
          FROM vote_subject
          WHERE title =
                '记名投票---喜欢吃什么？'), unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO vote_item (content, vote_subject_id, create_time, update_time) VALUE
  ('香蕉', (SELECT id
          FROM vote_subject
          WHERE title =
                '记名投票---喜欢吃什么？'), unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO vote_item (content, vote_subject_id, create_time, update_time) VALUE
  ('男生', (SELECT id
          FROM vote_subject
          WHERE title =
                '不记名投票---是否是男生？'), unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO vote_item (content, vote_subject_id, create_time, update_time) VALUE
  ('女生', (SELECT id
          FROM vote_subject
          WHERE title =
                '不记名投票---是否是男生？'), unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO vote_item (content, vote_subject_id, create_time, update_time) VALUE
  ('苹果', (SELECT id
          FROM vote_subject
          WHERE title =
                '不记名投票---喜欢吃什么？'), unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO vote_item (content, vote_subject_id, create_time, update_time) VALUE
  ('桃子', (SELECT id
          FROM vote_subject
          WHERE title =
                '不记名投票---喜欢吃什么？'), unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO vote_item (content, vote_subject_id, create_time, update_time) VALUE
  ('草莓', (SELECT id
          FROM vote_subject
          WHERE title =
                '不记名投票---喜欢吃什么？'), unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO vote_item (content, vote_subject_id, create_time, update_time) VALUE
  ('香蕉', (SELECT id
          FROM vote_subject
          WHERE title =
                '不记名投票---喜欢吃什么？'), unix_timestamp(now()), unix_timestamp(now()));

SELECT NOW();
DROP TABLE IF EXISTS vote_subject_result;
CREATE TABLE vote_subject_result (
  `id`                  BIGINT(20) UNSIGNED NOT NULL
  COMMENT '主键'                                       AUTO_INCREMENT,
  `user_id`             BIGINT(20) UNSIGNED          DEFAULT 0
  COMMENT '投票者学号',
  `result_vote_item_id` BIGINT(1) UNSIGNED           DEFAULT 0
  COMMENT '客观题结果',
  `content_result`      VARCHAR(1000)                DEFAULT ''
  COMMENT '主观题结果',
  `vote_subject_id`     BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '投票项目表ID',
  `create_time`         BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '创建时间',
  `update_time`         BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '更新时间',
  PRIMARY KEY `idx_iAutoID` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '项目结果表';
SELECT NOW();

# 暂时缺少event表

SELECT NOW();
DROP TABLE IF EXISTS message_type;
CREATE TABLE message_type (
  `id`          BIGINT(20) UNSIGNED NOT NULL
  COMMENT '主键'                               AUTO_INCREMENT,
  `user_id`     BIGINT(20) UNSIGNED          DEFAULT 0
  COMMENT '消息接受者学号',
  `type_name`   VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '消息类别名',
  `create_time` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '创建时间',
  `update_time` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '更新时间',
  PRIMARY KEY `idx_iAutoID` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '留言类别表';
SELECT NOW();

SELECT NOW();
DROP TABLE IF EXISTS message;
CREATE TABLE message (
  `id`              BIGINT(20) UNSIGNED NOT NULL
  COMMENT '主键'                                   AUTO_INCREMENT,
  `user_id`         BIGINT(20) UNSIGNED          DEFAULT 0
  COMMENT '消息发送者学号',
  `title`           VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '消息标题',
  `content`         VARCHAR(1000)       NOT NULL DEFAULT ''
  COMMENT '消息内容',
  `is_passed`       TINYINT(1) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '是否通过',
  `message_type_id` BIGINT(20) UNSIGNED          DEFAULT 0
  COMMENT '留言类别表ID',
  `create_time`     BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '创建时间',
  `update_time`     BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '更新时间',
  PRIMARY KEY `idx_iAutoID` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '留言表';
SELECT NOW();

SELECT NOW();
DROP TABLE IF EXISTS response;
CREATE TABLE response (
  `id`          BIGINT(20) UNSIGNED NOT NULL
  COMMENT '主键'                               AUTO_INCREMENT,
  `user_id`     BIGINT(20) UNSIGNED          DEFAULT 0
  COMMENT '回复发送者学号',
  `title`       VARCHAR(255)        DEFAULT ''
  COMMENT '回复标题',
  `content`     VARCHAR(1000)       NOT NULL DEFAULT ''
  COMMENT '回复内容',
  `message_id`  BIGINT(20) UNSIGNED          DEFAULT 0
  COMMENT '留言表ID',
  `create_time` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '创建时间',
  `update_time` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0
  COMMENT '更新时间',
  PRIMARY KEY `idx_iAutoID` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '回复表';
SELECT NOW();