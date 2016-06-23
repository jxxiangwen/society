SELECT NOW();
CREATE DATABASE society DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;                         #collate建议使用utf8-bin
SELECT NOW();
SHOW WARNINGS;
# SELECT NOW();
# DROP TABLE IF EXISTS example_db.example;
# CREATE TABLE example_db.example(                                                                #常规字段为 int,bigint,varchar,text,tinyint,timestamp
#   `iAutoID` int(10) UNSIGNED NOT NULL COMMENT 'comment' AUTO_INCREMENT,
#   `iIntID` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'comment',                              #财务相关字段，建议使用bigint
#   `sVar0` varchar(5) NOT NULL DEFAULT '' COMMENT 'comment',                                       #varchar字段，建议使用长度5,30,50,100,255,500,1000,5000
#   `sVar1` varchar(30) NOT NULL DEFAULT '' COMMENT 'comment',
#   `sVar2` varchar(50) NOT NULL DEFAULT '' COMMENT 'comment',
#   `sVar3` varchar(100) NOT NULL DEFAULT '' COMMENT 'comment',
#   `sVar4` varchar(255) NOT NULL DEFAULT '' COMMENT 'comment',
#   `sVar5` varchar(500) NOT NULL DEFAULT '' COMMENT 'comment',
#   `sVar6` varchar(1000) NOT NULL DEFAULT '' COMMENT 'comment',
#   `sVar7` varchar(5000) NOT NULL DEFAULT '' COMMENT 'comment',                                    #使用该长度时，建议分表
#   `sDesc` text NOT NULL COMMENT 'comment',                                                        #存储json格式字段
#   `iStatus` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT 'comment',                             #系统字段，业务请勿使用
#   `iCreateTime` int(10) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '创建时间',                                             #系统字段，业务请勿使用
#   `iUpdateTime` int(10) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '更新时间',                                              #系统字段，业务请勿使用
#   PRIMARY KEY `idx_iAutoID` (`iAutoID`),                                                          #主键，请合理选择
#   KEY `idx_sVar1` (`sVar1`)                                                                       #请加必要的业务相关索引，命名规则为idx_field1_field2
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='comment';
# SELECT NOW();
SELECT NOW();
DROP TABLE IF EXISTS example_db.example;
CREATE TABLE example_db.example(
  `iAutoID` int(10) UNSIGNED NOT NULL COMMENT 'comment' AUTO_INCREMENT,
  `iIntID` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'comment',
  `sVar0` varchar(5) NOT NULL DEFAULT '' COMMENT 'comment',
  `sVar2` varchar(50) NOT NULL DEFAULT '' COMMENT 'comment',
  `sVar3` varchar(100) NOT NULL DEFAULT '' COMMENT 'comment',
  `sVar4` varchar(255) NOT NULL DEFAULT '' COMMENT 'comment',
  `sVar5` varchar(500) NOT NULL DEFAULT '' COMMENT 'comment',
  `sVar6` varchar(1000) NOT NULL DEFAULT '' COMMENT 'comment',
  `sVar7` varchar(5000) NOT NULL DEFAULT '' COMMENT 'comment',
  `sDesc` text NOT NULL COMMENT 'comment',
  `iStatus` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT 'comment',
  `iCreateTime` int(10) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '创建时间',
  `iUpdateTime` int(10) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '更新时间',
  PRIMARY KEY `idx_iAutoID` (`iAutoID`),
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='comment';
SELECT NOW();