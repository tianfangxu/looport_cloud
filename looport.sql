/*
Navicat MySQL Data Transfer

Source Server         : location
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : looport

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2019-03-24 21:53:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for acct_menu
-- ----------------------------
DROP TABLE IF EXISTS `acct_menu`;
CREATE TABLE `acct_menu` (
  `id` varchar(32) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `order` varchar(5) DEFAULT NULL COMMENT '排序',
  `pid` varchar(32) DEFAULT NULL COMMENT '父id',
  `level` varchar(2) DEFAULT NULL COMMENT '等级',
  `methods` varchar(2000) DEFAULT NULL COMMENT '菜单内方法，已json格式保存数据（{}）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of acct_menu
-- ----------------------------
INSERT INTO `acct_menu` VALUES ('0001', '系统', '0', '0000', '1', '[]');
INSERT INTO `acct_menu` VALUES ('00010001', '用户', '0', '0001', '2', '[{\"name\":\"查询\",\"code\":\"query\"},{\"name\":\"删除\",\"code\":\"delete\"}]');
INSERT INTO `acct_menu` VALUES ('00010002', '部门', '1', '0001', '2', '[]');
INSERT INTO `acct_menu` VALUES ('00010003', '菜单', '2', '0001', '2', '[]');
INSERT INTO `acct_menu` VALUES ('00010004', '权限', '3', '0001', '2', '[]');
INSERT INTO `acct_menu` VALUES ('0002', '业务', '2', '0000', '1', '[{\"name\":\"查询\",\"code\":\"rtpl8e\"}]');
INSERT INTO `acct_menu` VALUES ('00020001', '订单', '1', '0002', '2', '[{\"name\":\"新增\",\"code\":\"im6uhc\"}]');
INSERT INTO `acct_menu` VALUES ('00020002', '购物车', '2', '0002', '2', '[{\"name\":\"新增\",\"code\":\"1cnvrr\"},{\"name\":\"删除\",\"code\":\"4al1u\"}]');
INSERT INTO `acct_menu` VALUES ('0003', '数据', '1', '0000', '1', '[]');
INSERT INTO `acct_menu` VALUES ('0004', '论坛', '3', '0000', '1', '[]');
INSERT INTO `acct_menu` VALUES ('0005', '评价', '4', '0000', '1', '[]');
INSERT INTO `acct_menu` VALUES ('0006', '风控', '5', '0000', '1', '[]');

-- ----------------------------
-- Table structure for acct_role
-- ----------------------------
DROP TABLE IF EXISTS `acct_role`;
CREATE TABLE `acct_role` (
  `id` varchar(32) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `menuid` varchar(1000) DEFAULT NULL COMMENT '以数组的形式保存数据([''1'',''2'']...)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of acct_role
-- ----------------------------
INSERT INTO `acct_role` VALUES ('1', '超级管理员', '[]');

-- ----------------------------
-- Table structure for acct_user
-- ----------------------------
DROP TABLE IF EXISTS `acct_user`;
CREATE TABLE `acct_user` (
  `id` varchar(32) NOT NULL,
  `nike` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `roleid` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `createuser` varchar(32) DEFAULT NULL,
  `createname` varchar(50) DEFAULT NULL,
  `createtime` varchar(14) DEFAULT NULL,
  `modifyuser` varchar(32) DEFAULT NULL,
  `modifyname` varchar(50) DEFAULT NULL,
  `modifytime` varchar(14) DEFAULT NULL,
  `deleteyuser` varchar(32) DEFAULT NULL,
  `deletename` varchar(50) DEFAULT NULL,
  `deletetime` varchar(14) DEFAULT NULL,
  `flag` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of acct_user
-- ----------------------------
INSERT INTO `acct_user` VALUES ('0e1238a6129d4bd4845097d2877dff80', '张曼玉', 'user6', '123', null, '1', '张三', '20190324174913', null, null, null, null, null, null, '0');
INSERT INTO `acct_user` VALUES ('1', '张三', 'admin', '123', null, null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `acct_user` VALUES ('299fb1d0af3d43368f5505403825fecb', '李四', 'user1', '123', null, '1', '张三', '20190323141307', null, null, null, null, null, null, '0');
INSERT INTO `acct_user` VALUES ('4f75ea23052d4aeab850abd0ab4c0f48', '赵六', 'user3', '123', null, '1', '张三', '20190323141538', null, null, null, null, null, null, '0');
INSERT INTO `acct_user` VALUES ('550e77ec80284b90ab105c82008688c8', '王五', 'user2', '123', null, '1', '张三', '20190323141500', null, null, null, null, null, null, '0');
INSERT INTO `acct_user` VALUES ('cfc7118611b9408384c7ba3166e1b2ee', '谢霆锋', 'user5', '123', null, '1', '张三', '20190323144552', null, null, null, null, null, null, '0');
INSERT INTO `acct_user` VALUES ('ec490e3a1ef84abcbe1fd315b6f67007', '王宝强', 'user4', '123', null, '1', '张三', '20190323141635', null, null, null, null, null, null, '0');
