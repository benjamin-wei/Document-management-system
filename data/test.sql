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
DROP TABLE IF EXISTS `Writer`;
CREATE TABLE `Writer`(
   `id`int(11)NOT NULL AUTO_INCREMENT,
    `proName`varchar(100)CHARACTER SET utf8 DEFAULT 'abc'COMMENT'提案名称',
    `proWriter`varchar(100)CHARACTER SET utf8 DEFAULT'Tom'COMMENT'提案作者',
    `deadline`int(11)DEFAULT'00000000'COMMENT'截止日期',
    `status`varchar(100)DEFAULT'ACCEPT'COMMENT'状态',
    `result`int(11)DEFAULT'0'COMMENT'提交结果',
PRIMARY KEY(`id`)
)ENGINE InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='能力规范文稿管理系统';
-- ----------------------------
--  Records of `Writer`
-- ----------------------------
BEGIN;
INSERT INTO `Writer` VALUES('01','AAA','aaa','20051102','ACCEPT','0'),('02','BBB','bbb','20080908','UNACCEPT','1'),('03','CCC','ccc','20100208','ACCEPT','0');
COMMIT;
SET FOREIGN_KEY_CHECKS = 1;