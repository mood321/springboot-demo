/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.121
 Source Server Type    : MySQL
 Source Server Version : 50645
 Source Host           : 192.168.0.121:3306
 Source Schema         : mybatis-demo

 Target Server Type    : MySQL
 Target Server Version : 50645
 File Encoding         : 65001

 Date: 06/08/2019 23:59:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
