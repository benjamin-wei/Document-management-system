/* 提案*/
DROP TABLE IF EXISTS `proposal`;
CREATE TABLE `proposal`(
   `id`int(11)NOT NULL AUTO_INCREMENT comment '编号id',
    `proName`varchar(100)CHARACTER SET utf8 COMMENT'提案名称',
    `proWriter`varchar(100)CHARACTER SET utf8 COMMENT'提案作者',
    `deadline`int(11) NOT NULL DEFAULT 20201105 COMMENT'截止日期',
    `status`varchar(100) CHARACTER SET utf8 DEFAULT '审核中' COMMENT'状态',
    `agree` int(11) NOT NULL DEFAULT 0 comment '附议数',
    `oppose` int(11) NOT NULL DEFAULT 0 comment '反对数',
    `content` varchar(1000) CHARACTER SET utf8 comment '提案内容',
PRIMARY KEY(`id`)
)ENGINE InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='能力规范文稿管理系统';


BEGIN;
INSERT INTO `proposal` VALUES('01','改宪法','习近平','20180705','通过','100','0','删除不能连任的相关内容');
INSERT INTO `proposal` VALUES('02','医疗改革1','市政府','20200311','审核中','74','26','将挂号费改为医事服务费');
INSERT INTO `proposal` VALUES('03','教学改革1','大鸡腿','20190621','审核中','88','12','将所有政治课程从义务教育中删除');
COMMIT;
SET FOREIGN_KEY_CHECKS = 1;
/*测试用sql语句*/
-- delete from proposal where id = 02;
-- INSERT INTO `proposal` (proName,proWriter,content) VALUES('教学改革1','大鸡腿','将所有政治课程从义务教育中删除');

/*用户表*/

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
    `userName`varchar(100)CHARACTER SET utf8 COMMENT'用户名',
    `passWord`varchar(256)CHARACTER SET utf8 COMMENT'密码',
    `name`varchar(100)CHARACTER SET utf8 COMMENT'姓名',
    `gender`varchar(100)CHARACTER SET utf8 COMMENT'性别',
   `birthday`int(11) COMMENT'出生日期',
   `address`varchar(100)CHARACTER SET utf8 COMMENT'家庭住址',
   `conWay`varchar(100)CHARACTER SET utf8 COMMENT'联系方式',
   `referrer`varchar(100)CHARACTER SET utf8 COMMENT'推荐人',
   `assoName`varchar(100)CHARACTER SET utf8 COMMENT'会名',
    `isAdmin` int(10) NOT NULL DEFAULT 0 COMMENT'是否管理员，0为审核未通过，1为写者，2为管理员',
PRIMARY KEY(`userName`)
)ENGINE InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='能力规范文稿管理系统';
-- ----------------------------
--  Records of `Writer`
-- ----------------------------
BEGIN;
-- admin1/nobody1密码为1045，writer1密码为7646
INSERT INTO `user` VALUES('admin1','1000:8dd5956fad34c96a06bce20ebfb9444b9f726a2ede99b766:d2fa7a218c8fa16d2814ab70dc76c78ec4021bb651bd2b94','大鸡腿','男','20110808','火焰山','wechat:cjgdkv838','一位长者','行业分会','2');
INSERT INTO `user` VALUES('writer1','1000:209f6fc86621471c2bb9025ec84decc7de07a80a88647f58:92f3b371faec910b88ad51212ff9ef46dd5099ce3213d2cb','luffy','男','19970601','小渔村','电话虫:cjgdkv838','蜂花护发素','专委会','1');
INSERT INTO `user` VALUES('nobody1','1000:8dd5956fad34c96a06bce20ebfb9444b9f726a2ede99b766:d2fa7a218c8fa16d2814ab70dc76c78ec4021bb651bd2b94','rose','女','19900721','海边','海螺','蜂花护发素','研究会','0');
COMMIT;
SET FOREIGN_KEY_CHECKS = 1;
/*测试用sql语句*/
-- select * from user;
-- delete from user where userName = 'nobody1';

/*评论表*/

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`(
    `id`int(11) COMMENT'对应提案的id',
    `name`varchar(100)CHARACTER SET utf8 COMMENT'评论人',
    `content` varchar(1000) CHARACTER SET utf8 COMMENT'评论内容',
    `time` TIMESTAMP NOT NULL default CURRENT_TIMESTAMP COMMENT'评论时间,格式为YYYY-MM-DD HH:MM:SS',
PRIMARY KEY(`content`)
)ENGINE InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='能力规范文稿管理系统';
/*自动补上系统时间的写法*/
INSERT INTO `comment` (id,name,content) VALUES ('1','一位长者','轻关易道，通商宽衣');
-- INSERT INTO `comment` VALUES ('1','一位长者','轻关易道，通商宽衣','2017-06-06 11:45:03');

/*推荐人表*/
DROP TABLE IF EXISTS `referrer`;
CREATE TABLE `referrer`(
    `name`varchar(100)CHARACTER SET utf8 COMMENT'推荐人姓名',
    `jobTitle` varchar(1000) CHARACTER SET utf8 COMMENT'职称',
    `company`varchar(100)CHARACTER SET utf8 COMMENT'单位',
    `position`varchar(100)CHARACTER SET utf8 COMMENT'职务',
    `phone`varchar(100)CHARACTER SET utf8 COMMENT'电话',
    `email`varchar(100)CHARACTER SET utf8 COMMENT'邮箱',
    `nobody`varchar(100)CHARACTER SET utf8 COMMENT'被推荐人',
    `reason`varchar(100)CHARACTER SET utf8 COMMENT'推荐原因',
PRIMARY KEY(`name`,`nobody`)
)ENGINE InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='能力规范文稿管理系统';

-- INSERT INTO `referrer` VALUES ('一位长者','主任医师','BJUT','医生','13030066666','BigBrother@gmail.com','大鸡腿','长得好看');
-- INSERT INTO `referrer` VALUES ('蜂花护发素','架构师','BJUT','工程师','13030097560','heiehi@gmail.com','rose','代码水平一流，学东西快，特聪明');
