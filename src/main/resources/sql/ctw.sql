/*
Navicat MySQL Data Transfer

Source Server         : zs
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : ctw

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-08-13 16:54:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bank_card
-- ----------------------------
DROP TABLE IF EXISTS `bank_card`;
CREATE TABLE `bank_card` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bank` varchar(50) NOT NULL COMMENT '开卡银行',
  `made_time` date NOT NULL COMMENT '开卡时间',
  `validity_period` date NOT NULL COMMENT '有效期',
  `citizen_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4o3pe71gc9fuxe691mbcdn0nw` (`citizen_id`),
  CONSTRAINT `FK4o3pe71gc9fuxe691mbcdn0nw` FOREIGN KEY (`citizen_id`) REFERENCES `citizen` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_card
-- ----------------------------
INSERT INTO `bank_card` VALUES ('7', '建设银行', '2018-08-09', '2018-08-22', '3');
INSERT INTO `bank_card` VALUES ('8', '工商银行', '2018-08-09', '2018-08-22', '3');
INSERT INTO `bank_card` VALUES ('9', '人民银行', '2018-08-09', '2018-08-22', '3');
INSERT INTO `bank_card` VALUES ('10', '建设银行', '2018-08-09', '2018-08-22', '4');
INSERT INTO `bank_card` VALUES ('11', '1172917', '2018-08-09', '2018-08-22', '4');
INSERT INTO `bank_card` VALUES ('12', '人民银行', '2018-08-09', '2018-08-22', '4');
INSERT INTO `bank_card` VALUES ('13', '工商银行', '2018-08-09', '2018-08-22', '5');
INSERT INTO `bank_card` VALUES ('14', '人民银行', '2018-08-09', '2018-08-22', '5');
INSERT INTO `bank_card` VALUES ('15', '建设银行', '2018-08-09', '2018-08-22', '5');
INSERT INTO `bank_card` VALUES ('19', '建设银行', '2018-08-10', '2018-08-23', '7');
INSERT INTO `bank_card` VALUES ('20', '工商银行', '2018-08-10', '2018-08-23', '7');
INSERT INTO `bank_card` VALUES ('21', '人民银行', '2018-08-10', '2018-08-23', '7');
INSERT INTO `bank_card` VALUES ('22', '建设银行', '2018-08-10', '2018-08-23', '8');
INSERT INTO `bank_card` VALUES ('23', '工商银行', '2018-08-10', '2018-08-23', '8');
INSERT INTO `bank_card` VALUES ('24', '人民银行', '2018-08-10', '2018-08-23', '8');
INSERT INTO `bank_card` VALUES ('25', '人民银行', '2018-08-10', '2018-08-23', '9');
INSERT INTO `bank_card` VALUES ('26', '工商银行', '2018-08-10', '2018-08-23', '9');
INSERT INTO `bank_card` VALUES ('27', '建设银行', '2018-08-10', '2018-08-23', '9');
INSERT INTO `bank_card` VALUES ('28', '工商银行', '2018-08-10', '2018-08-23', '10');
INSERT INTO `bank_card` VALUES ('29', '建设银行', '2018-08-10', '2018-08-23', '10');
INSERT INTO `bank_card` VALUES ('30', '人民银行', '2018-08-10', '2018-08-23', '10');
INSERT INTO `bank_card` VALUES ('31', '人民银行', '2018-08-10', '2018-08-23', '11');
INSERT INTO `bank_card` VALUES ('32', '工商银行', '2018-08-10', '2018-08-23', '11');
INSERT INTO `bank_card` VALUES ('33', '建设银行', '2018-08-10', '2018-08-23', '11');
INSERT INTO `bank_card` VALUES ('34', '建设银行', '2018-08-10', '2018-08-23', '12');
INSERT INTO `bank_card` VALUES ('35', '工商银行', '2018-08-10', '2018-08-23', '12');
INSERT INTO `bank_card` VALUES ('36', '人民银行', '2018-08-10', '2018-08-23', '12');
INSERT INTO `bank_card` VALUES ('37', '工商银行', '2018-08-10', '2018-08-23', '13');
INSERT INTO `bank_card` VALUES ('38', '人民银行', '2018-08-10', '2018-08-23', '13');
INSERT INTO `bank_card` VALUES ('39', '建设银行', '2018-08-10', '2018-08-23', '13');

-- ----------------------------
-- Table structure for citizen
-- ----------------------------
DROP TABLE IF EXISTS `citizen`;
CREATE TABLE `citizen` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `sex` varchar(2) NOT NULL COMMENT '性别-xx女--xy男',
  `address` varchar(50) DEFAULT NULL COMMENT '家庭地址',
  `birthday` date DEFAULT NULL COMMENT '生日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of citizen
-- ----------------------------
INSERT INTO `citizen` VALUES ('3', 'laoyangtou', 'xy', '测试地址', '2018-08-09');
INSERT INTO `citizen` VALUES ('4', 'laoyangtou', 'xy', '测试地址', '2018-08-09');
INSERT INTO `citizen` VALUES ('5', 'laoyangtou', 'xy', '测试地址', '2018-08-09');
INSERT INTO `citizen` VALUES ('7', 'laoyangtou', 'xy', '测试地址', '2018-08-10');
INSERT INTO `citizen` VALUES ('8', 'laoyangtou', 'xy', '测试地址', '2018-08-10');
INSERT INTO `citizen` VALUES ('9', 'laoyangtou', 'xy', '测试地址', '2018-08-10');
INSERT INTO `citizen` VALUES ('10', 'laoyangtou', 'xy', '测试地址', '2018-08-10');
INSERT INTO `citizen` VALUES ('11', 'laoyangtou', 'xy', '测试地址', '2018-08-10');
INSERT INTO `citizen` VALUES ('12', 'laoyangtou', 'xy', '测试地址', '2018-08-10');
INSERT INTO `citizen` VALUES ('13', 'laoyangtou', 'xy', '测试地址', '2018-08-10');

-- ----------------------------
-- Table structure for identity_card
-- ----------------------------
DROP TABLE IF EXISTS `identity_card`;
CREATE TABLE `identity_card` (
  `id` varchar(18) NOT NULL COMMENT '身份证编号',
  `made_time` datetime NOT NULL COMMENT '制卡时间',
  `validity_period` datetime NOT NULL COMMENT '有效期',
  `made_address` varchar(50) DEFAULT NULL COMMENT '制卡地点',
  `citizen_id` int(10) NOT NULL COMMENT '关联的公民id',
  PRIMARY KEY (`id`),
  KEY `FK1d9l16hrh9pj7mnwxkkssvns1` (`citizen_id`),
  CONSTRAINT `FK1d9l16hrh9pj7mnwxkkssvns1` FOREIGN KEY (`citizen_id`) REFERENCES `citizen` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of identity_card
-- ----------------------------
INSERT INTO `identity_card` VALUES ('121573613', '2018-08-09 17:06:10', '2018-08-22 08:59:35', '西虹市公安局', '5');
INSERT INTO `identity_card` VALUES ('148776102', '2018-08-10 16:43:40', '2018-08-23 08:37:05', '西虹市公安局', '9');
INSERT INTO `identity_card` VALUES ('172332596', '2018-08-09 13:59:02', '2018-08-22 05:52:27', '西虹市公安局', '4');
INSERT INTO `identity_card` VALUES ('182458056', '2018-08-10 16:43:46', '2018-08-23 08:37:11', '西虹市公安局', '13');
INSERT INTO `identity_card` VALUES ('203034304', '2018-08-10 16:43:38', '2018-08-23 08:37:03', '西虹市公安局', '8');
INSERT INTO `identity_card` VALUES ('267745228', '2018-08-10 16:43:45', '2018-08-23 08:37:09', '西虹市公安局', '12');
INSERT INTO `identity_card` VALUES ('38654185', '2018-08-10 16:43:43', '2018-08-23 08:37:08', '西虹市公安局', '11');
INSERT INTO `identity_card` VALUES ('405941979', '2018-08-09 13:59:01', '2018-08-22 05:52:26', '西虹市公安局', '3');
INSERT INTO `identity_card` VALUES ('44904746', '2018-08-10 16:43:35', '2018-08-23 08:36:59', '西虹市公安局', '7');
INSERT INTO `identity_card` VALUES ('460946839', '2018-08-10 16:43:42', '2018-08-23 08:37:06', '西虹市公安局', '10');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `login_name` varchar(50) NOT NULL COMMENT '登录名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_name` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('7', '6433', 'vbnagm', '123456');
INSERT INTO `sys_user` VALUES ('8', 'bsadmin', '1234567890', '123456');
INSERT INTO `sys_user` VALUES ('9', '超管来了', 'super', 'e10adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '班级名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_group
-- ----------------------------
INSERT INTO `t_group` VALUES ('6', '4-52班');
INSERT INTO `t_group` VALUES ('7', '2-69班');

-- ----------------------------
-- Table structure for t_syslog
-- ----------------------------
DROP TABLE IF EXISTS `t_syslog`;
CREATE TABLE `t_syslog` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL COMMENT '登录用户主键id',
  `time` datetime DEFAULT NULL COMMENT '操作时间',
  `method` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL COMMENT '执行的细节',
  `ip` varchar(50) DEFAULT NULL COMMENT '操作IP',
  `broswer` varchar(200) DEFAULT NULL COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT NULL COMMENT '操作系统',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_syslog
-- ----------------------------
INSERT INTO `t_syslog` VALUES ('1', '1', '2018-08-13 16:02:52', 'com.zgc.action.UserAction.findAllUser().(find)查找:', '查找所有用户', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36', null);
INSERT INTO `t_syslog` VALUES ('2', '1', '2018-08-13 16:08:55', 'com.zgc.action.UserAction.findAllUser().(find)查找:', '查找所有用户', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36', null);
INSERT INTO `t_syslog` VALUES ('3', '1', '2018-08-13 16:17:05', 'com.zgc.action.UserAction.findAllUser().(find)查找:', '查找所有用户', '127.0.0.1', 'Windows --- Chrome-67.0.3396.99', 'Windows 10');
INSERT INTO `t_syslog` VALUES ('4', '1', '2018-08-13 16:18:58', 'com.zgc.action.UserAction.findAllUser().(find)查找:', '查找所有用户', '127.0.0.1', 'Windows --- Chrome-67.0.3396.99', 'Windows 10');

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('4', 'xxxxx', '26');
INSERT INTO `t_teacher` VALUES ('5', 'xxxxx', '18');
INSERT INTO `t_teacher` VALUES ('6', 'xxxxx', '57');

-- ----------------------------
-- Table structure for t_teacher_group
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher_group`;
CREATE TABLE `t_teacher_group` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `tid` int(10) NOT NULL COMMENT '教师id',
  `gid` int(10) NOT NULL COMMENT '班级ID',
  PRIMARY KEY (`id`),
  KEY `FK1jekrjlsmom6xvw60urb24c1p` (`gid`),
  KEY `FKoklpwyj0xdtnenee7u5ahyd2c` (`tid`),
  CONSTRAINT `FK1jekrjlsmom6xvw60urb24c1p` FOREIGN KEY (`gid`) REFERENCES `t_group` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKoklpwyj0xdtnenee7u5ahyd2c` FOREIGN KEY (`tid`) REFERENCES `t_teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher_group
-- ----------------------------
INSERT INTO `t_teacher_group` VALUES ('5', '4', '6');
INSERT INTO `t_teacher_group` VALUES ('6', '4', '7');
INSERT INTO `t_teacher_group` VALUES ('8', '5', '6');
INSERT INTO `t_teacher_group` VALUES ('9', '5', '7');
INSERT INTO `t_teacher_group` VALUES ('11', '6', '6');
INSERT INTO `t_teacher_group` VALUES ('12', '6', '7');
