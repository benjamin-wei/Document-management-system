/*
 Navicat Premium Data Transfer

 Source Server         : LocalHost
 Source Server Type    : MySQL
 Source Server Version : 50621
 Source Host           : localhost
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 50621
 File Encoding         : utf-8

 Date: 07/01/2018 21:28:02 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `User`
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `name` varchar(100) CHARACTER SET utf8 DEFAULT 'Tom' COMMENT '姓名',
  `sex` varchar(100) CHARACTER SET utf8 DEFAULT '男' COMMENT '性别',
  `birth` INT(11) DEFAULT '00000000' COMMENT '生日',
  `homeAddress` varchar(100) CHARACTER SET utf8 DEFAULT 'Beijing' COMMENT '家庭住址',
  `telephone` INT(11) DEFAULT '00000000000' COMMENT '联系方式',
  `recommender` varchar(100) CHARACTER SET utf8 DEFAULT 'Tom' COMMENT '推荐人',
   `industryClub`varchar(100) CHARACTER SET utf8 DEFAULT 'ccc' COMMENT '行业分会',
  `specialCommittee`varchar(100) CHARACTER SET utf8 DEFAULT 'ddd' COMMENT '专委会',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='能力规范文稿管理系统';
-- ----------------------------
--  Records of `User`
-- ----------------------------
BEGIN;
INSERT INTO `User` VALUES ('张三', '男','19980314','北京','1236382946','aa','b11','c11'), ('李四', '男','19980711','北京','1278201262','bb','d11','c51');
COMMIT;
SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
--  Table structure for `Writer`
-- ----------------------------
/* 提案*/
DROP TABLE IF EXISTS `proposal`;
CREATE TABLE `proposal`(
   `id`int(11)NOT NULL AUTO_INCREMENT comment '编号id',
    `proName`varchar(100)CHARACTER SET utf8 COMMENT'提案名称',
    `proWriter`varchar(100)CHARACTER SET utf8 COMMENT'提案作者',
    `deadline`int(11) COMMENT'截止日期',
    `status`varchar(100) CHARACTER SET utf8 COMMENT'状态',
    `agree` int(11) comment '附议数',
    `oppose` int(11) comment '反对数',
    `content` varchar(1000) CHARACTER SET utf8 comment '提案内容',
PRIMARY KEY(`id`)
)ENGINE InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='能力规范文稿管理系统';
-- ----------------------------
--  Records of `Writer`
-- ----------------------------
BEGIN;
INSERT INTO `proposal` VALUES('01','改宪法','习近平','20180705','通过','100','0','删除不能连任的相关内容');
/*测试用sql语句*/
INSERT INTO `proposal` VALUES('02','医疗改革1','市政府','20200311','审核中','74','26','将挂号费改为医事服务费');
delete from proposal where id = 02;
COMMIT;
SET FOREIGN_KEY_CHECKS = 1;

/*用户表*/

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
    `userName`varchar(100)CHARACTER SET utf8 COMMENT'用户名',
    `passWord`varchar(100)CHARACTER SET utf8 COMMENT'密码',
    `name`varchar(100)CHARACTER SET utf8 COMMENT'姓名',
    `gender`varchar(100)CHARACTER SET utf8 COMMENT'性别',
   `birthday`int(11)NOT NULL COMMENT'出生日期',
   `address`varchar(100)CHARACTER SET utf8 COMMENT'家庭住址',
   `conWay`varchar(100)CHARACTER SET utf8 COMMENT'联系方式',
   `referrer`varchar(100)CHARACTER SET utf8 COMMENT'推荐人',
   `assoName`varchar(100)CHARACTER SET utf8 COMMENT'会名',
    `isAdmin` tinyint(1) COMMENT'是否管理员，1为管理员，0为写者',
PRIMARY KEY(`userName`)
)ENGINE InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='能力规范文稿管理系统';
-- ----------------------------
--  Records of `Writer`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES('admin1','1045','大鸡腿','男','20110808','火焰山','wechat:cjgdkv838','林雨','行业分会','1');
/*测试用sql语句*/
INSERT INTO `user` VALUES('admin2','1045','luffy','男','19970601','小渔村','电话虫:cjgdkv838','','专委会','1');
COMMIT;
SET FOREIGN_KEY_CHECKS = 1;
delete from user where userName = admin2;


/*推荐人表*/