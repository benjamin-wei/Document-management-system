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
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `management`;
CREATE TABLE `management` (
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
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `management` VALUES ('张三', '男','19980314','北京','1236382946','aa','b11','c11'), ('李四', '男','19980711','北京','1278201262','bb','d11','c51');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
