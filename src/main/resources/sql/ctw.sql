/*
Navicat MySQL Data Transfer

Source Server         : zs
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : ctw

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-08-09 17:58:14
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of citizen
-- ----------------------------
INSERT INTO `citizen` VALUES ('3', 'laoyangtou', 'xy', '测试地址', '2018-08-09');
INSERT INTO `citizen` VALUES ('4', 'laoyangtou', 'xy', '测试地址', '2018-08-09');
INSERT INTO `citizen` VALUES ('5', 'laoyangtou', 'xy', '测试地址', '2018-08-09');

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '班级名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group
-- ----------------------------

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
INSERT INTO `identity_card` VALUES ('172332596', '2018-08-09 13:59:02', '2018-08-22 05:52:27', '西虹市公安局', '4');
INSERT INTO `identity_card` VALUES ('405941979', '2018-08-09 13:59:01', '2018-08-22 05:52:26', '西虹市公安局', '3');

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
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
