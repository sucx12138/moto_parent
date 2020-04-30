/*
 Navicat Premium Data Transfer

 Source Server         : localDb
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : springboot

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 30/04/2020 17:09:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for clientdetails
-- ----------------------------
DROP TABLE IF EXISTS `clientdetails`;
CREATE TABLE `clientdetails`  (
  `appId` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL,
  `resourceIds` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `appSecret` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `grantTypes` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `redirectUrl` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `authorities` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `access_token_validity` int(11) NULL DEFAULT NULL,
  `refresh_token_validity` int(11) NULL DEFAULT NULL,
  `additionalInformation` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `autoApproveScopes` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`appId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token`  (
  `token_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `token` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `authentication_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL,
  `user_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `client_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `authentication` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `refresh_token` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_approvals
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals`  (
  `userId` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `clientId` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `expiresAt` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `lastModifiedAt` timestamp(0) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`  (
  `client_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '客户端id',
  `resource_ids` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL COMMENT '资源',
  `client_secret` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL COMMENT '范围',
  `authorized_grant_types` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL COMMENT '授权模式',
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL COMMENT '回调url',
  `authorities` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL COMMENT '权限',
  `access_token_validity` int(11) NULL DEFAULT NULL COMMENT '请求授权次数',
  `refresh_token_validity` int(11) NULL DEFAULT NULL COMMENT '刷新次数',
  `additional_information` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `autoapprove` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token`  (
  `token_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `token` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `authentication_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL,
  `user_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `client_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code`  (
  `code` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `authentication` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token`  (
  `token_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `token` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `authentication` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_authority
-- ----------------------------
DROP TABLE IF EXISTS `s_authority`;
CREATE TABLE `s_authority`  (
  `ID` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '主键id',
  `CODE` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '权限code',
  `NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '权限名称',
  `CREATE_TIME` datetime(0) NOT NULL,
  `CREATE_IP` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL,
  `CREATE_USER` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL,
  `UPDATE_USER` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `UPDATE_IP` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `STATUS` int(5) NOT NULL,
  `REMARK` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_authority
-- ----------------------------
INSERT INTO `s_authority` VALUES ('1', 'code_1', '权限1', '2020-04-22 14:41:09', '127.0.0.1', NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `s_authority` VALUES ('2', 'code_2', '权限2', '2020-04-22 14:41:09', '127.0.0.1', NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `s_authority` VALUES ('3', 'code_3', '权限3', '2020-04-22 14:41:09', '127.0.0.1', NULL, NULL, NULL, NULL, 1, NULL);

-- ----------------------------
-- Table structure for s_menu
-- ----------------------------
DROP TABLE IF EXISTS `s_menu`;
CREATE TABLE `s_menu`  (
  `ID` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '主键id',
  `CODE` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '菜单代码',
  `NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '菜单名称',
  `TYPE` int(5) NOT NULL COMMENT '菜单类型【1-主菜单 2-功能型FORM元素】',
  `URL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL COMMENT '菜单链接',
  `ICON` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `CREATE_USER` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `CREATE_TIME` datetime(0) NOT NULL,
  `CREATE_IP` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL,
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL,
  `UPDATE_USER` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `UPDATE_IP` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `STATUS` int(5) NOT NULL,
  `REMARK` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_role
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role`  (
  `ID` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '主键id',
  `CODE` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '角色code',
  `NAME` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '角色名称',
  `CREATE_USER` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `CREATE_TIME` datetime(0) NOT NULL,
  `CREATE_IP` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL,
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL,
  `UPDATE_USER` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `UPDATE_IP` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `STATUS` int(5) NOT NULL,
  `REMARK` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES ('1', '1', '管理员角色', NULL, '2020-04-15 14:26:07', '127.0.0.1', NULL, NULL, NULL, 1, NULL);
INSERT INTO `s_role` VALUES ('2', '2', '会员角色', NULL, '2020-04-15 14:26:07', '127.0.0.1', NULL, NULL, NULL, 1, NULL);
INSERT INTO `s_role` VALUES ('3', '3', '普通角色', NULL, '2020-04-15 14:26:07', '127.0.0.1', NULL, NULL, NULL, 1, NULL);

-- ----------------------------
-- Table structure for s_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `s_role_authority`;
CREATE TABLE `s_role_authority`  (
  `ID` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL,
  `ROLE_ID` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '角色id',
  `AUTHORITY_ID` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '权限id',
  `CREATE_USER` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `CREATE_TIME` datetime(0) NOT NULL,
  `CREATE_IP` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL,
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL,
  `UPDATE_USER` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `UPDATE_IP` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `STATUS` int(5) NOT NULL,
  `REMARK` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_role_authority
-- ----------------------------
INSERT INTO `s_role_authority` VALUES ('1', '1', '1', NULL, '2020-04-22 14:42:08', '127.0.0.1', NULL, NULL, NULL, 1, NULL);
INSERT INTO `s_role_authority` VALUES ('2', '1', '2', NULL, '2020-04-22 14:42:08', '127.0.0.1', NULL, NULL, NULL, 1, NULL);

-- ----------------------------
-- Table structure for s_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `s_role_menu`;
CREATE TABLE `s_role_menu`  (
  `ID` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL,
  `ROLE_ID` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '角色id',
  `MENU_ID` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '菜单id',
  `CREATE_USER` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `CREATE_TIME` datetime(0) NOT NULL,
  `CREATE_IP` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL,
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL,
  `UPDATE_USER` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `UPDATE_IP` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `STATUS` int(5) NOT NULL,
  `REMARK` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user`  (
  `ID` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '主键id',
  `USER_CODE` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '用户账号',
  `USER_NAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '密码',
  `PHONE` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL COMMENT '手机',
  `ID_CARD` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL COMMENT '身份证',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '创建人',
  `CREATE_IP` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '创建ip',
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATE_IP` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL COMMENT '更新ip',
  `STATUS` int(5) NOT NULL COMMENT '状态',
  `REMARK` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci COMMENT = '系统用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', 'admin', '管理员', '123456', '13588755555', NULL, '2020-04-22 14:24:49', 'root', '127.0.0.1', NULL, NULL, NULL, 1, NULL);

-- ----------------------------
-- Table structure for s_user_role
-- ----------------------------
DROP TABLE IF EXISTS `s_user_role`;
CREATE TABLE `s_user_role`  (
  `ID` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL,
  `ROLE_ID` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '角色id',
  `USER_ID` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL COMMENT '用户id',
  `CREATE_USER` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `CREATE_TIME` datetime(0) NOT NULL,
  `CREATE_IP` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NOT NULL,
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL,
  `UPDATE_USER` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `UPDATE_IP` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `STATUS` int(5) NOT NULL,
  `REMARK` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_user_role
-- ----------------------------
INSERT INTO `s_user_role` VALUES ('1', '1', '1', NULL, '2020-04-22 14:27:24', '127.0.0.1', NULL, NULL, NULL, 1, NULL);
INSERT INTO `s_user_role` VALUES ('2', '2', '1', NULL, '2020-04-22 14:27:24', '127.0.0.1', NULL, NULL, NULL, 1, NULL);
INSERT INTO `s_user_role` VALUES ('3', '3', '1', NULL, '2020-04-22 14:27:24', '127.0.0.1', NULL, NULL, NULL, 1, NULL);

SET FOREIGN_KEY_CHECKS = 1;
