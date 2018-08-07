/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : unicorndb

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-08-07 17:19:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cloud_files
-- ----------------------------
DROP TABLE IF EXISTS `cloud_files`;
CREATE TABLE `cloud_files` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(200) DEFAULT NULL,
  `real_name` varchar(200) DEFAULT NULL,
  `upload_time` datetime DEFAULT NULL,
  `upload_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cloud_files
-- ----------------------------
INSERT INTO `cloud_files` VALUES ('2', 'qwqwqw', '头像.jpg', '2018-08-01 14:57:15', 'user');
INSERT INTO `cloud_files` VALUES ('3', '1533176527620.jpg', '头像.jpg', '2018-08-02 10:22:08', 'user');
INSERT INTO `cloud_files` VALUES ('5', '1533091669936.pptx', 'Spring boot.pptx', '2018-08-01 10:47:50', 'user');
INSERT INTO `cloud_files` VALUES ('6', '1533091669936.pptx', 'Spring boot.pptx', '2018-08-01 10:47:50', 'user');
INSERT INTO `cloud_files` VALUES ('7', '1533091669936.pptx', 'Spring boot.pptx', '2018-08-01 10:47:50', 'user');
INSERT INTO `cloud_files` VALUES ('8', '1533091669936.pptx', 'Spring boot.pptx', '2018-08-01 10:47:50', 'user');

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源表id',
  `url` text COMMENT '资源链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '/admin');
INSERT INTO `resource` VALUES ('2', '/user');
INSERT INTO `resource` VALUES ('3', '/hello');
INSERT INTO `resource` VALUES ('4', '/');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(20) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'USER');
INSERT INTO `role` VALUES ('2', 'ADMIN');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色资源中间表id',
  `role_id` bigint(20) DEFAULT NULL,
  `resource_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES ('1', '1', '2');
INSERT INTO `role_resource` VALUES ('2', '1', '3');
INSERT INTO `role_resource` VALUES ('4', '2', '1');
INSERT INTO `role_resource` VALUES ('5', '2', '2');
INSERT INTO `role_resource` VALUES ('6', '2', '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'chm', '123456');
INSERT INTO `user` VALUES ('2', 'lmm', '123456');
INSERT INTO `user` VALUES ('3', 'lb', '123456');
INSERT INTO `user` VALUES ('4', 'hff', '123456');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '中间表id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');
INSERT INTO `user_role` VALUES ('3', '3', '2');
INSERT INTO `user_role` VALUES ('4', '4', '2');
