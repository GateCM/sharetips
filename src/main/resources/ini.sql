/*
Navicat MySQL Data Transfer

Source Server         : my阿里
Source Server Version : 50718
Source Host           : rm-uf60446vx71hkx76so.mysql.rds.aliyuncs.com:3306
Source Database       : tip_share

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-01-12 16:28:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for member_address
-- ----------------------------
DROP TABLE IF EXISTS `member_address`;
CREATE TABLE `member_address` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `country` varchar(100) DEFAULT NULL COMMENT '国家',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `province` varchar(100) DEFAULT NULL COMMENT '省',
  `city` varchar(100) DEFAULT NULL COMMENT '市',
  `county` varchar(100) DEFAULT NULL COMMENT '县',
  `area` varchar(100) DEFAULT NULL COMMENT '区',
  `detail` varchar(255) DEFAULT NULL COMMENT '详细',
  `planet` varchar(100) DEFAULT NULL COMMENT '所在星球',
  `member_id` bigint(20) unsigned NOT NULL COMMENT '所属用户ID',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户地址表';

-- ----------------------------
-- Records of member_address
-- ----------------------------

-- ----------------------------
-- Table structure for member_basic
-- ----------------------------
DROP TABLE IF EXISTS `member_basic`;
CREATE TABLE `member_basic` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '0:冻结；1：正常',
  `nickname` varchar(30) DEFAULT NULL COMMENT '昵称',
  `head_url` varchar(255) DEFAULT NULL COMMENT '头像路径',
  `phone_number` varchar(20) DEFAULT NULL COMMENT '手机号',
  `qq` varchar(15) DEFAULT NULL COMMENT 'QQ号',
  `we_chat` varchar(20) DEFAULT NULL COMMENT '微信号',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `sex` tinyint(3) unsigned DEFAULT NULL COMMENT '性别，2种以上性别',
  `password` varchar(80) NOT NULL COMMENT '加密后的密码',
  `salt` varchar(80) NOT NULL COMMENT '盐值',
  `motto` varchar(255) DEFAULT NULL COMMENT '座右铭',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `occupation` varchar(255) DEFAULT NULL COMMENT '职业',
  `total_point` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '历史总积分',
  `current_point` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '当前积分',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_member_nickname` (`nickname`),
  UNIQUE KEY `uk_phone_del` (`phone_number`,`del_f`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='用户基本信息表，用来存储用户最基本的信息。';

-- ----------------------------
-- Records of member_basic
-- ----------------------------
INSERT INTO `member_basic` VALUES ('1', '2017-12-02 16:28:29', null, '1', '纽盖特纽盖特纽盖特', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-27/74051514342863992.png', '15968183204', null, null, null, null, '24fff37db86a2467b3d77bbe2a924dfd', 'bff1a4d5e5f8d49d228c9ee39e8aa622', '千里之行始于足下！', null, null, null, '0', '0', '0');
INSERT INTO `member_basic` VALUES ('11', '2017-12-11 22:51:18', null, '1', '123132423', '/custom/common/image/default_head.png', '15968183203', null, null, null, null, '9fab04de64769afb03f4286584486275', 'a0b3695bd32539b259d42335b735518b', '万里之行始于足下！', null, null, null, '0', '0', '0');
INSERT INTO `member_basic` VALUES ('12', '2017-12-11 22:57:11', null, '1', '小梅梅', '/custom/common/image/default_head.png', '15968120094', null, null, null, null, 'ec60f2efff049948a848f645b49c0f58', '2be850879bc9790c549fbe2af502ec13', '百里之行始于足下！', null, null, null, '0', '0', '0');
INSERT INTO `member_basic` VALUES ('13', '2017-12-11 23:13:43', null, '1', 'edngcnbg', '/custom/common/image/default_head.png', '15968120093', null, null, null, null, 'd31b5ff4a4e31f185f09cf4d4136a509', 'e8b698010e173bc0e0bab3721fc47b03', '十里之行始于足下！', null, null, null, '0', '0', '0');
INSERT INTO `member_basic` VALUES ('14', '2018-01-11 10:32:11', null, '1', '1233', '/custom/common/image/default_head.png', '15968183201', null, null, null, null, 'a7e04a552e97ae3b2813f37ade3c1a06', 'cce0a7eb2923fbaeac7a87ad420155e8', null, null, null, null, '0', '0', '0');
INSERT INTO `member_basic` VALUES ('15', '2018-01-11 10:32:49', null, '1', '121233', '/custom/common/image/default_head.png', '15968183202', null, null, null, null, '5f61e165c63a1bd4302976a15fb7c2a8', '1b4350deccb97e0b9b8df27ac0fee77f', null, null, null, null, '0', '0', '0');
INSERT INTO `member_basic` VALUES ('17', '2018-01-11 10:37:38', null, '1', '123456', '/custom/common/image/default_head.png', '15968183200', null, null, null, null, '8bbee060b7bef49c6cf376b8c56aef51', '5b34731294408576b3be5bebf9e39cbc', null, null, null, null, '0', '0', '0');
INSERT INTO `member_basic` VALUES ('18', '2018-01-12 16:05:48', null, '1', '测试用户1', '/custom/common/image/default_head.png', '15968183211', null, null, null, null, '42be111c5d0d35efcca18fdf328d3c5a', '04da149140a6320fe53b7db9a0da9fab', null, null, null, null, '0', '0', '0');

-- ----------------------------
-- Table structure for member_follow
-- ----------------------------
DROP TABLE IF EXISTS `member_follow`;
CREATE TABLE `member_follow` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `follow_member_id` bigint(20) unsigned NOT NULL COMMENT '被关注用户ID',
  `member_id` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `is_follow` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未关注；1：已关注',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_uk_follow` (`follow_member_id`,`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户关注表，记录用户与被关注用户映射';

-- ----------------------------
-- Records of member_follow
-- ----------------------------

-- ----------------------------
-- Table structure for member_news
-- ----------------------------
DROP TABLE IF EXISTS `member_news`;
CREATE TABLE `member_news` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `member_id` bigint(20) unsigned NOT NULL COMMENT '所属用户ID',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户消息表，记录用户消息';

-- ----------------------------
-- Records of member_news
-- ----------------------------

-- ----------------------------
-- Table structure for member_operation
-- ----------------------------
DROP TABLE IF EXISTS `member_operation`;
CREATE TABLE `member_operation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `member_id` bigint(20) unsigned NOT NULL COMMENT '所属用户ID',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户操作记录表';

-- ----------------------------
-- Records of member_operation
-- ----------------------------

-- ----------------------------
-- Table structure for member_report
-- ----------------------------
DROP TABLE IF EXISTS `member_report`;
CREATE TABLE `member_report` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `member_id` bigint(20) unsigned NOT NULL COMMENT '发起用户ID',
  `submit_info` varchar(500) NOT NULL COMMENT '举报提交信息',
  `relate_id` bigint(20) DEFAULT NULL COMMENT '举报关联ID:评论ID，技巧ID',
  `relate_member_id` bigint(20) unsigned DEFAULT NULL COMMENT '被举报用户ID',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户举报表';

-- ----------------------------
-- Records of member_report
-- ----------------------------

-- ----------------------------
-- Table structure for member_setup
-- ----------------------------
DROP TABLE IF EXISTS `member_setup`;
CREATE TABLE `member_setup` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `member_id` bigint(20) unsigned NOT NULL COMMENT '所属用户ID',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户设置表，保存用户个人设置';

-- ----------------------------
-- Records of member_setup
-- ----------------------------

-- ----------------------------
-- Table structure for member_sign
-- ----------------------------
DROP TABLE IF EXISTS `member_sign`;
CREATE TABLE `member_sign` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `member_id` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `sign_date` date NOT NULL COMMENT '签到日期',
  `gain_point` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '签到获得积分',
  `is_repaired` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:不是补签；1：是补签',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_uk_follow` (`member_id`,`sign_date`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用户签到表，记录用户签到';

-- ----------------------------
-- Records of member_sign
-- ----------------------------
INSERT INTO `member_sign` VALUES ('1', '2018-01-09 14:36:41', '2018-01-09 14:36:44', '1', '2018-01-08', '0', '0', '0');
INSERT INTO `member_sign` VALUES ('5', '2018-01-09 14:48:36', '2018-01-09 14:48:36', '1', '2018-01-06', '0', '0', '0');
INSERT INTO `member_sign` VALUES ('6', '2018-01-09 14:48:59', '2018-01-09 14:48:59', '1', '2018-01-07', '0', '0', '0');
INSERT INTO `member_sign` VALUES ('8', '2018-01-09 14:53:07', '2018-01-09 14:53:07', '1', '2018-01-03', '0', '0', '0');
INSERT INTO `member_sign` VALUES ('9', '2018-01-09 15:01:55', '2018-01-09 15:01:55', '1', '2018-01-01', '0', '0', '0');
INSERT INTO `member_sign` VALUES ('10', '2018-01-09 15:02:52', '2018-01-09 15:02:52', '1', '2018-01-04', '0', '0', '0');
INSERT INTO `member_sign` VALUES ('11', '2018-01-09 15:06:14', '2018-01-09 15:06:14', '1', '2018-01-02', '0', '0', '0');
INSERT INTO `member_sign` VALUES ('12', '2018-01-09 15:06:41', '2018-01-09 15:06:41', '1', '2018-01-09', '0', '0', '0');
INSERT INTO `member_sign` VALUES ('13', '2018-01-10 13:12:43', '2018-01-10 13:12:43', '1', '2018-01-10', '0', '0', '0');
INSERT INTO `member_sign` VALUES ('14', '2018-01-11 10:37:48', '2018-01-11 10:37:48', '1', '2018-01-11', '0', '0', '0');
INSERT INTO `member_sign` VALUES ('15', '2018-01-12 10:05:58', '2018-01-12 10:05:58', '1', '2018-01-12', '0', '0', '0');

-- ----------------------------
-- Table structure for member_tip_collection
-- ----------------------------
DROP TABLE IF EXISTS `member_tip_collection`;
CREATE TABLE `member_tip_collection` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `member_id` bigint(20) unsigned NOT NULL COMMENT '发起用户ID',
  `tip_id` bigint(20) unsigned NOT NULL COMMENT '技巧ID',
  `is_collection` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未收藏；1：已收藏',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_uk_member_tip` (`member_id`,`tip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户技巧收藏表，记录用户与技巧收藏关联';

-- ----------------------------
-- Records of member_tip_collection
-- ----------------------------

-- ----------------------------
-- Table structure for sys_label
-- ----------------------------
DROP TABLE IF EXISTS `sys_label`;
CREATE TABLE `sys_label` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `name` varchar(100) DEFAULT NULL COMMENT '板块名称',
  `code` tinyint(3) unsigned DEFAULT NULL COMMENT '板块码',
  `type` tinyint(3) unsigned DEFAULT NULL COMMENT '1：用户标签；2：技巧标签；3：评论标签',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统标签';

-- ----------------------------
-- Records of sys_label
-- ----------------------------

-- ----------------------------
-- Table structure for sys_member_medal
-- ----------------------------
DROP TABLE IF EXISTS `sys_member_medal`;
CREATE TABLE `sys_member_medal` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `name` varchar(100) DEFAULT NULL COMMENT '勋章名称',
  `code` tinyint(3) unsigned DEFAULT NULL COMMENT '勋章码',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户勋章';

-- ----------------------------
-- Records of sys_member_medal
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统权限';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限映射表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_tip_plate
-- ----------------------------
DROP TABLE IF EXISTS `sys_tip_plate`;
CREATE TABLE `sys_tip_plate` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `name` varchar(100) DEFAULT NULL COMMENT '板块名称',
  `code` tinyint(3) unsigned DEFAULT NULL COMMENT '板块码',
  `parent_plate_id` bigint(20) unsigned DEFAULT NULL COMMENT '所属父板块ID',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='系统技巧板块';

-- ----------------------------
-- Records of sys_tip_plate
-- ----------------------------
INSERT INTO `sys_tip_plate` VALUES ('1', '2018-01-11 11:07:07', '2018-01-11 11:07:11', '服装/首饰', '1', '0', '0');
INSERT INTO `sys_tip_plate` VALUES ('2', '2018-01-11 11:07:31', '2018-01-11 11:07:34', '美容/塑身 ', '2', '0', '0');
INSERT INTO `sys_tip_plate` VALUES ('3', '2018-01-11 11:07:53', '2018-01-11 11:07:55', '美食/烹饪', '3', '0', '0');
INSERT INTO `sys_tip_plate` VALUES ('4', '2018-01-11 11:10:00', '2018-01-11 11:09:57', '购房置业', '4', '0', '0');
INSERT INTO `sys_tip_plate` VALUES ('5', '2018-01-11 11:10:32', '2018-01-11 11:10:36', '家居装修', '5', '0', '0');
INSERT INTO `sys_tip_plate` VALUES ('6', '2018-01-11 11:12:02', '2018-01-11 11:12:00', '家电', '6', '0', '0');
INSERT INTO `sys_tip_plate` VALUES ('7', '2018-01-11 11:12:24', '2018-01-11 11:12:21', '保健养生', '7', '0', '0');
INSERT INTO `sys_tip_plate` VALUES ('8', '2018-01-11 11:12:42', '2018-01-11 11:12:39', '购车养车', '8', '0', '0');
INSERT INTO `sys_tip_plate` VALUES ('9', '2018-01-11 11:12:51', '2018-01-11 11:12:53', '交通出行 ', '9', '0', '0');
INSERT INTO `sys_tip_plate` VALUES ('10', '2018-01-11 11:13:06', '2018-01-11 11:13:09', '购物', '10', '0', '0');
INSERT INTO `sys_tip_plate` VALUES ('11', '2018-01-11 11:13:22', '2018-01-11 11:13:26', '生活常识', '11', '0', '0');
INSERT INTO `sys_tip_plate` VALUES ('12', '2018-01-11 11:13:36', '2018-01-11 11:13:40', '婚嫁 ', '12', '0', '0');
INSERT INTO `sys_tip_plate` VALUES ('13', '2018-01-11 11:13:54', '2018-01-11 11:13:51', '起名', '13', '0', '0');
INSERT INTO `sys_tip_plate` VALUES ('14', '2018-01-11 11:14:03', '2018-01-11 11:14:06', '礼节礼仪', '14', '0', '0');
INSERT INTO `sys_tip_plate` VALUES ('15', '2018-01-11 11:14:16', '2018-01-11 11:14:19', '育儿', '15', '0', '0');
INSERT INTO `sys_tip_plate` VALUES ('16', '2018-01-11 11:14:37', '2018-01-11 11:14:40', '其他', '16', '0', '0');

-- ----------------------------
-- Table structure for sys_tip_prop
-- ----------------------------
DROP TABLE IF EXISTS `sys_tip_prop`;
CREATE TABLE `sys_tip_prop` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `name` varchar(100) DEFAULT NULL COMMENT '道具名称',
  `code` tinyint(3) unsigned DEFAULT NULL COMMENT '道具码',
  `cost_point` bigint(20) unsigned DEFAULT NULL COMMENT '花费积分',
  `duration` int(10) unsigned DEFAULT NULL COMMENT '持续时间（分）',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统技巧道具';

-- ----------------------------
-- Records of sys_tip_prop
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色映射表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for tip_comment
-- ----------------------------
DROP TABLE IF EXISTS `tip_comment`;
CREATE TABLE `tip_comment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `member_id` bigint(20) unsigned NOT NULL COMMENT '发起用户ID',
  `tip_id` bigint(20) unsigned NOT NULL COMMENT '技巧ID',
  `content` varchar(255) NOT NULL COMMENT '评论内容',
  `tf_reply` tinyint(3) unsigned NOT NULL COMMENT '0:不是回复；1：是回复',
  `reply_comment_id` bigint(20) unsigned DEFAULT NULL COMMENT '被回复评论ID',
  `reply_member_id` bigint(20) unsigned DEFAULT NULL COMMENT '被回复用户ID',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='技巧评论表，记录用户对技巧的评论';

-- ----------------------------
-- Records of tip_comment
-- ----------------------------
INSERT INTO `tip_comment` VALUES ('1', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '3', 'dfbdh', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('4', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '3', '正sdfds框架', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('5', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '3', '都是割发代首框架', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('6', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '3', '手动阀发大框架', '1', '5', '1', '0');
INSERT INTO `tip_comment` VALUES ('7', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '3', '沙发上框架', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('8', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '3', 'dgsfdgsgdgd', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('9', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '3', 'sfdagfhj', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('10', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '3', 'sfdagfhjsgdsgdfgdg ', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('11', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '3', 'dgffgdgdg', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('12', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '3', 'dsfgfdgdsg', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('13', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '3', 'dfgdfggdssgf', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('14', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '3', 'dfgdfggdssgfdgfdgf', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('15', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '3', 'dfdgdfgdgd', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('16', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '3', 'dfgdgdsgdf', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('17', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '3', 'dfgsdgf', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('18', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '3', 'dfggfdsgd', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('19', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '3', 'sdfafsdf', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('20', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '74', '热腾腾', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('21', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '118', 're ', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('22', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '118', 're fghdh ', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('23', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '118', 're fghdh dfgshsg', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('24', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '119', 'ghdfhtfhf', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('25', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '119', 'ghdfhtfhf', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('26', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '119', 'ghdfhtfhf', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('27', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '121', '刚放寒假', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('28', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '121', '这个说的不行哦', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('29', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '121', 'VB从', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('30', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '121', 'VB从地方归属感', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('31', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '121', '豆腐干豆腐是', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('32', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '120', 'dfbdfgg', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('33', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '120', 'dfgsgdfgsgd', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('34', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '120', 'ddscsfadssaf', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('35', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '120', '水电费会计不合适的开会就是暴风科技as', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('36', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '120', '天涯海角和', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('37', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '120', '天涯海角和', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('38', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '120', '更符合地方', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('39', '2018-01-08 13:38:15', '2018-01-08 13:38:15', '1', '120', '东方宾馆的', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('40', '2018-01-08 13:39:02', '2018-01-08 13:39:02', '1', '120', '东方宾馆的发', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('41', '2018-01-08 13:39:15', '2018-01-08 13:39:15', '1', '120', '东方宾馆的发2', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('42', '2018-01-08 13:41:04', '2018-01-08 13:41:04', '1', '120', '手动阀发', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('43', '2018-01-08 13:41:21', '2018-01-08 13:41:21', '1', '120', '电饭锅的故事', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('44', '2018-01-08 13:41:40', '2018-01-08 13:41:40', '1', '120', '是飞洒发', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('45', '2018-01-08 13:42:31', '2018-01-08 13:42:31', '1', '120', '是否', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('46', '2018-01-08 13:42:40', '2018-01-08 13:42:40', '1', '120', '刚发的更改部分', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('47', '2018-01-08 13:43:59', '2018-01-08 13:43:59', '1', '120', '大声说', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('48', '2018-01-08 13:44:06', '2018-01-08 13:44:06', '1', '120', '更符合地方', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('49', '2018-01-08 13:44:15', '2018-01-08 13:44:15', '1', '120', '更符合地方发的挂号费', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('50', '2018-01-08 14:18:10', '2018-01-08 14:18:10', '1', '120', 'dfgdsg', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('51', '2018-01-08 14:18:19', '2018-01-08 14:18:19', '1', '120', 'dskjhslgkdjnldkgjunkl', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('52', '2018-01-08 14:40:18', '2018-01-08 14:40:18', '1', '121', '大锅饭', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('53', '2018-01-08 17:22:55', '2018-01-08 17:22:55', '1', '120', '水电费申达股份', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('54', '2018-01-09 13:58:47', '2018-01-09 13:58:47', '1', '126', '小电饭锅地方', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('55', '2018-01-09 13:58:51', '2018-01-09 13:58:51', '1', '126', '小电饭锅地方', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('56', '2018-01-09 13:58:57', '2018-01-09 13:58:57', '1', '126', '小电饭锅地方水电费', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('57', '2018-01-09 13:59:16', '2018-01-09 13:59:16', '1', '126', '沙发上', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('58', '2018-01-09 13:59:26', '2018-01-09 13:59:26', '1', '126', '发的读法', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('59', '2018-01-09 13:59:55', '2018-01-09 13:59:55', '1', '126', ' 发', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('60', '2018-01-09 14:00:14', '2018-01-09 14:00:14', '1', '126', '萨芬的', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('61', '2018-01-09 14:00:24', '2018-01-09 14:00:24', '1', '126', '手动阀', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('62', '2018-01-09 14:00:29', '2018-01-09 14:00:29', '1', '126', '三大发顺丰', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('63', '2018-01-09 14:00:51', '2018-01-09 14:00:51', '1', '126', '安抚', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('64', '2018-01-09 15:47:51', '2018-01-09 15:47:51', '1', '125', '大使馆的', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('65', '2018-01-09 15:48:21', '2018-01-09 15:48:21', '1', '125', '带格式', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('66', '2018-01-11 10:17:46', '2018-01-11 10:17:46', '1', '126', '所发生的', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('67', '2018-01-12 15:47:40', '2018-01-12 15:47:40', '1', '167', 'fs ', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('68', '2018-01-12 15:47:43', '2018-01-12 15:47:43', '1', '167', 'sdfsdafsfasd ', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('69', '2018-01-12 15:47:53', '2018-01-12 15:47:53', '1', '167', '点开链接飞洒客服节哀说翻就翻代课老师那快了', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('70', '2018-01-12 15:48:02', '2018-01-12 15:48:02', '1', '167', '的割发代首功夫大使馆首付款累计啊说服力分开了风口浪尖好地方看数据啊回复快乐十分几哈时空裂缝就很舒服快乐就好沙口路房交会上快乐就好看了金凤凰斯洛伐克就快乐就好昆仑决', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('71', '2018-01-12 15:54:24', '2018-01-12 15:54:24', '1', '167', 'fdgsfs', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('72', '2018-01-12 15:54:29', '2018-01-12 15:54:29', '1', '167', 'fasfd ', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('73', '2018-01-12 16:23:37', '2018-01-12 16:23:37', '12', '169', '假的', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('74', '2018-01-12 16:23:47', '2018-01-12 16:23:47', '12', '169', '枯黄的空间打开了电脑几十块', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('75', '2018-01-12 16:24:02', '2018-01-12 16:24:02', '1', '169', '真的吧', '0', null, null, '0');
INSERT INTO `tip_comment` VALUES ('76', '2018-01-12 16:24:08', '2018-01-12 16:24:08', '1', '169', '第三季度破我就抖擞地奥', '0', null, null, '0');

-- ----------------------------
-- Table structure for tip_comment_thumbs_up
-- ----------------------------
DROP TABLE IF EXISTS `tip_comment_thumbs_up`;
CREATE TABLE `tip_comment_thumbs_up` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `member_id` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `tip_comment_id` bigint(20) unsigned NOT NULL COMMENT '被点赞评论',
  `is_thumbs_up` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未点赞；1：已点赞',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_uk_tip_comment_member` (`member_id`,`tip_comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='技巧评论点赞表';

-- ----------------------------
-- Records of tip_comment_thumbs_up
-- ----------------------------

-- ----------------------------
-- Table structure for tip_content
-- ----------------------------
DROP TABLE IF EXISTS `tip_content`;
CREATE TABLE `tip_content` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `type` tinyint(3) DEFAULT NULL COMMENT '类型(1 原创；2：转载)',
  `status` tinyint(3) unsigned NOT NULL COMMENT '状态\r\n	STATUS_PRIVATE(0, "私人状态"),\r\n\r\n	STATUS_RELEASE(1, "发布状态"),\r\n\r\n	STATUS_DRAFT(2, "草稿状态");',
  `title` varchar(255) NOT NULL COMMENT '技巧标题',
  `head_img` varchar(255) DEFAULT NULL COMMENT '题图路径',
  `content` text NOT NULL COMMENT '内容（html格式）',
  `belong_member_id` bigint(20) unsigned NOT NULL COMMENT '所属用户ID',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=170 DEFAULT CHARSET=utf8 COMMENT='技巧内容表';

-- ----------------------------
-- Records of tip_content
-- ----------------------------
INSERT INTO `tip_content` VALUES ('1', '2017-12-19 14:09:48', '2017-12-19 14:09:48', '1', '2', '这是第一个标题电风扇', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/10171514518108018.ico', '<p>请输入内容电饭锅十多个电饭锅<br></p><p>胜多负少让分公司隔壁<br></p><p>sddsghhgo;o\'i<br></p><p><br>dfhydyhfh</p><p>vbn<br></p><p><br>水电费发放</p><p><br><img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2017-12-29/5871514518318247.gif\" style=\"max-width:100%;\"></p><p><br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('2', '2017-12-16 23:05:31', '2017-12-16 23:05:31', '1', '2', '这是第二个标题', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-16/13201513436716692.gif', '<p>请输入内容</p><p>是的发生发的<img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2017-12-16/34751513436725062.jpg\" style=\"max-width:100%;\">水电费三分</p><p>sfd</p><p>sfdasaf</p><p>十分大<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('3', '2017-12-16 23:08:28', '2017-12-16 23:08:28', '1', '1', '这是第三个标题这是第三个标题', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-16/35641513436898804.gif', '<p>请输入内容</p><p>是的发生发的<img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2017-12-16/34751513436725062.jpg\" style=\"max-width:100%;\">水电费三分阿达<br></p><p>sfd</p><p>sfdasaf</p><p>十分大<br></p><p><br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('4', '2017-12-19 16:20:24', '2017-12-19 16:20:24', '1', '2', '这是第二个标sd', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-16/13201513436716692.gif', '<p>请输入内容</p><p>是的发生发的<img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2017-12-16/34751513436725062.jpg\" style=\"max-width:100%;\">水电费三分</p><p>sfd</p><p>sfdasaf</p><p>十分大<br></p><p><br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('5', '2017-12-19 16:20:51', '2017-12-19 16:20:51', '1', '2', '这是第二个标题', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-23/34081514011718741.jpg', '<p>请输入内容</p><p>是的发生发的<img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2017-12-16/34751513436725062.jpg\" style=\"max-width:100%;\">水电费三分</p><p>sfd</p><p>sfdasaf</p><p>十分大<br></p><p><br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('6', '2017-12-19 16:36:31', '2017-12-19 16:36:31', '1', '1', '这是第二个标题这是第三个标题', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-16/13201513436716692.gif', '<p>请输入内容</p><p>是的发生发的<img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2017-12-16/34751513436725062.jpg\" style=\"max-width:100%;\">水电费三分阿达<br></p><p>sfd</p><p>sfdasaf</p><p>十分大<br></p><p><br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('7', '2017-12-19 16:36:34', '2017-12-19 16:36:34', '1', '2', '这是第二个标题', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-16/13201513436716692.gif', '<p>请输入内容</p><p>是的发生发的<img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2017-12-16/34751513436725062.jpg\" style=\"max-width:100%;\">水电费三分</p><p>sfd</p><p>sfdasaf</p><p>十分大<br></p><p><br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('8', '2017-12-19 16:36:45', '2017-12-19 16:36:45', '1', '1', '这是第人数个标题这是第三个标题', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-16/13201513436716692.gif', '<p>请输入内容</p><p>是的发生发的<img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2017-12-16/34751513436725062.jpg\" style=\"max-width:100%;\">水电费三分</p><p>sfd</p><p>sfdasaf</p><p>十分大<br></p><p><br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('9', '2017-12-19 16:38:00', '2017-12-19 16:38:00', '1', '2', '这是第人数个标题', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-19/54951513672726077.png', '<p>请输入内容</p><p>是的发生发的<img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2017-12-16/34751513436725062.jpg\" style=\"max-width:100%;\">水电费三分大幅度发鬼地方郭德纲的腹股沟第三个但是广度高<br></p><p>sfd</p><p>sfdasaf电热风格豆腐干豆腐<br></p><p>十分大<br></p><p><br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('10', '2017-12-19 16:52:41', '2017-12-19 16:52:41', '1', '2', '单位的带我飞', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-19/33771513673555440.gif', '<p>生栋覆屋服务服务费<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('11', '2017-12-19 16:52:42', '2017-12-19 16:52:42', '1', '1', '单位的带我飞这是第三个标题', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-19/33771513673555440.gif', '<p>生栋覆屋服务服务费<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('12', '2017-12-19 16:52:43', '2017-12-19 16:52:43', '1', '2', '单位的带我飞', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-19/33771513673555440.gif', '<p>生栋覆屋服务服务费<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('13', '2017-12-29 11:38:32', '2017-12-29 11:38:32', '1', '2', '十多个帝国时代', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/79151514518702769.gif', '<p><br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('14', '2017-12-29 11:38:35', '2017-12-29 11:38:35', '1', '2', '十多个帝国时代', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/79151514518702769.gif', '<p><br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('15', '2017-12-29 11:38:38', '2017-12-29 11:38:38', '1', '2', '十多个帝国时代', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/79151514518702769.gif', '<p><br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('16', '2017-12-29 11:38:41', '2017-12-29 11:38:41', '1', '2', '十多个帝国时代', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/79151514518702769.gif', '<p><br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('17', '2017-12-29 11:38:44', '2017-12-29 11:38:44', '1', '2', '十多个帝国时代', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/79151514518702769.gif', '<p><br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('18', '2017-12-29 11:38:47', '2017-12-29 11:38:47', '1', '2', '十多个帝国时代', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/79151514518702769.gif', '<p><br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('19', '2017-12-29 11:38:50', '2017-12-29 11:38:50', '1', '2', '十多个帝国时代', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/79151514518702769.gif', '<p><br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('20', '2017-12-29 11:38:53', '2017-12-29 11:38:53', '1', '2', '十多个帝国时代', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/79151514518702769.gif', '<p><br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('21', '2017-12-29 11:38:57', '2017-12-29 11:38:57', '1', '2', '十多个帝国时代', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/79151514518702769.gif', '<p><br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('22', '2017-12-29 11:38:59', '2017-12-29 11:38:59', '1', '2', '十多个帝国时代', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/79151514518702769.gif', '<p><br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('23', '2017-12-29 11:39:03', '2017-12-29 11:39:03', '1', '2', '十多个帝国时代', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/79151514518702769.gif', '<p><br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('24', '2017-12-29 11:39:06', '2017-12-29 11:39:06', '1', '2', '十多个帝国时代', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/79151514518702769.gif', '<p><br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('25', '2017-12-29 11:39:09', '2017-12-29 11:39:09', '1', '2', '十多个帝国时代', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/79151514518702769.gif', '<p><br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('26', '2017-12-29 11:39:34', '2017-12-29 11:39:34', '1', '2', '十多个帝国时', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/31171514518773853.gif', '<p>的<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('27', '2017-12-29 11:39:37', '2017-12-29 11:39:37', '1', '2', '十多个帝国时', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/31171514518773853.gif', '<p>的<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('28', '2017-12-29 11:39:40', '2017-12-29 11:39:40', '1', '2', '十多个帝国时', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/31171514518773853.gif', '<p>的<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('29', '2017-12-29 11:39:43', '2017-12-29 11:39:43', '1', '2', '十多个帝国时', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/31171514518773853.gif', '<p>的<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('30', '2017-12-29 11:39:46', '2017-12-29 11:39:46', '1', '2', '十多个帝国时', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/31171514518773853.gif', '<p>的<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('31', '2017-12-29 11:39:49', '2017-12-29 11:39:49', '1', '2', '十多个帝国时', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/31171514518773853.gif', '<p>的<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('32', '2017-12-29 11:39:52', '2017-12-29 11:39:52', '1', '2', '十多个帝国时', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/31171514518773853.gif', '<p>的<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('33', '2017-12-29 11:39:55', '2017-12-29 11:39:55', '1', '2', '十多个帝国时', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/31171514518773853.gif', '<p>的<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('34', '2017-12-29 11:39:58', '2017-12-29 11:39:58', '1', '2', '十多个帝国时', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/31171514518773853.gif', '<p>的<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('35', '2017-12-29 11:40:01', '2017-12-29 11:40:01', '1', '2', '十多个帝国时', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/31171514518773853.gif', '<p>的<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('36', '2017-12-29 11:40:04', '2017-12-29 11:40:04', '1', '2', '十多个帝国时', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/31171514518773853.gif', '<p>的<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('37', '2017-12-29 11:40:07', '2017-12-29 11:40:07', '1', '2', '十多个帝国时', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/31171514518773853.gif', '<p>的<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('38', '2017-12-29 11:40:10', '2017-12-29 11:40:10', '1', '2', '十多个帝国时', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/31171514518773853.gif', '<p>的<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('39', '2017-12-29 11:40:13', '2017-12-29 11:40:13', '1', '2', '十多个帝国时', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/31171514518773853.gif', '<p>的<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('40', '2017-12-29 11:41:21', '2017-12-29 11:41:21', '1', '2', '第三个是', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/65731514518880296.ico', '<p>的鬼斧神工的<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('41', '2017-12-29 11:44:58', '2017-12-29 11:44:58', '1', '2', '的广东省股份', null, '<p><br>谁打得过谁</p>', '1', '0');
INSERT INTO `tip_content` VALUES ('42', '2017-12-29 11:45:28', '2017-12-29 11:45:28', '1', '2', '的广东省', null, '<p><br>谁打得过谁第三方二哥<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('43', '2017-12-29 11:46:32', '2017-12-29 11:46:32', '1', '2', '的广东省', null, '<p>东方肝胆<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('44', '2017-12-29 11:46:54', '2017-12-29 11:46:54', '1', '2', '水电费', null, '<p>三顿饭发<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('45', '2017-12-29 11:46:57', '2017-12-29 11:46:57', '1', '2', '水电费', null, '<p>三顿饭发的割发代首<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('46', '2017-12-29 11:47:03', '2017-12-29 11:47:03', '1', '2', '水电费', null, '<p>三顿饭发的割发代首去公司及顾问IQ噢安静的<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('47', '2017-12-29 11:47:06', '2017-12-29 11:47:06', '1', '2', '水电费', null, '<p>三顿饭发的割发代首去公司及顾问IQ噢安静的司法局离开设计费离开家kljlsfjla</p><p><br></p><p><br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('48', '2017-12-29 11:47:09', '2017-12-29 11:47:09', '1', '2', '水电费', null, '<p>三顿饭发的割发代首去公司及顾问IQ噢安静的司法局离开设计费离开家kljlsfjla</p><p><br></p><p>健康的开发的框架和反馈接口<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('49', '2017-12-29 11:47:18', '2017-12-29 11:47:18', '1', '2', '水电费', null, '<p>三顿饭发的割发代首去公司及顾问IQ噢安静的司法局离开设计费离开家kljlsfjla</p><p><br></p><p>健康的开发的框架和反馈接口 <br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('50', '2017-12-29 11:47:21', '2017-12-29 11:47:21', '1', '2', '水电费', null, '<p>三顿饭发的割发代首去公司及顾问IQ噢安静的司法局离开设计费离开家kljlsfjla</p><p><br></p><p>健康的开发的框架和反馈接口 爱上了房间里疯狂就爱上了附件为立法上看见<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('51', '2017-12-29 11:47:24', '2017-12-29 11:47:24', '1', '2', '水电费', null, '<p>三顿饭发的割发代首去公司及顾问IQ噢安静的司法局离开设计费离开家kljlsfjla</p><p><br></p><p>健康的开发的框架和反馈接口 爱上了房间里疯狂就爱上了附件为立法上看见老师傅了快乐女看见<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('52', '2017-12-29 11:47:30', '2017-12-29 11:47:30', '1', '2', '水电费', null, '<p>三顿饭发的割发代首去公司及顾问IQ噢安静的司法局离开设计费离开家kljlsfjla</p><p><br></p><p>健康的开发的框架和反馈接口 爱上了房间里疯狂就爱上了附件为立法上看见老师傅了快乐女看见是大法师方式方法轻微而快乐无人工清理不付款就爱说不定，模拟 <br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('53', '2017-12-29 11:47:33', '2017-12-29 11:47:33', '1', '2', '水电费', null, '<p>三顿饭发的割发代首去公司及顾问IQ噢安静的司法局离开设计费离开家kljlsfjla</p><p><br></p><p>健康的开发的框架和反馈接口 爱上了房间里疯狂就爱上了附件为立法上看见老师傅了快乐女看见是大法师方式方法轻微而快乐无人工清理不付款就爱说不定，模拟三顿饭发额外热潜伏期未发生发顺丰<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('54', '2017-12-29 11:47:36', '2017-12-29 11:47:36', '1', '2', '水电费', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/22011514519256045.ico', '<p>三顿饭发的割发代首去公司及顾问IQ噢安静的司法局离开设计费离开家kljlsfjla</p><p><br></p><p>健康的开发的框架和反馈接口 爱上了房间里疯狂就爱上了附件为立法上看见老师傅了快乐女看见是大法师方式方法轻微而快乐无人工清理不付款就爱说不定，模拟三顿饭发额外热潜伏期未发生发顺丰<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('55', '2017-12-29 14:47:07', '2017-12-29 14:47:07', '1', '2', '发生过很多个', null, '<p>东方故事<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('56', '2017-12-29 14:47:16', '2017-12-29 14:47:16', '1', '2', '发生过很多个', null, '<p>东方故事地方<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('57', '2017-12-29 14:47:19', '2017-12-29 14:47:19', '1', '2', '发生过很多个', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/90771514530038846.gif', '<p>东方故事地方<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('58', '2017-12-29 14:47:34', '2017-12-29 14:47:34', '1', '2', '发生过很多个手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/5591514530045987.ico', '<p>东方故事地方<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('59', '2017-12-29 15:15:44', '2017-12-29 15:15:44', '1', '2', '发生过很多个手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/93581514530058279.gif', '<p>东方故事地方<img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2017-12-29/99861514531742872.gif\" style=\"max-width:100%;\"></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('60', '2017-12-29 15:15:56', '2017-12-29 15:15:56', '1', '2', '发生过很多个手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/93581514530058279.gif', '<p>东方故事地方<img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2017-12-29/99861514531742872.gif\" style=\"max-width:100%;\"><img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2017-12-29/9691514531753630.png\" style=\"max-width:100%;\"></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('61', '2017-12-29 15:15:59', '2017-12-29 15:15:59', '1', '2', '发生过很多个手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/93581514530058279.gif', '<p>东方故事地方<img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2017-12-29/99861514531742872.gif\" style=\"max-width:100%;\"></p><p><img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2017-12-29/9691514531753630.png\" style=\"max-width:100%;\"></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('62', '2017-12-29 15:16:02', '2017-12-29 15:16:02', '1', '2', '发生过很多个手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/93581514530058279.gif', '<p>东方故事地方<img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2017-12-29/99861514531742872.gif\" style=\"max-width:100%;\"></p><p align=\"center\"><img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2017-12-29/9691514531753630.png\" style=\"max-width:100%;\"></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('63', '2017-12-29 15:27:01', '2017-12-29 15:27:01', '1', '2', '发生过很多个手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/10351514532416159.gif', '<p>的国防生的<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('64', '2017-12-29 15:28:49', '2017-12-29 15:28:49', '1', '2', '发生过很多个手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/98011514532521078.gif', '<p>地方<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('65', '2017-12-29 15:28:55', '2017-12-29 15:28:55', '1', '2', '发生过很多个手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/51141514532532331.gif', '<p>地方<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('66', '2017-12-29 15:29:14', '2017-12-29 15:29:14', '1', '2', '发生过很多个手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/98121514532547992.png', '<p>覆盖<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('67', '2017-12-29 15:29:23', '2017-12-29 15:29:23', '1', '2', '发生过很多个手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/98121514532547992.png', '<p>覆盖水电费<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('68', '2017-12-29 15:30:51', '2017-12-29 15:30:51', '1', '2', '发生过很多个手动阀', null, '<p>的方式发给<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('69', '2017-12-29 15:30:54', '2017-12-29 15:30:54', '1', '2', '发生过很多个手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/52201514532653308.png', '<p>的方式发给<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('70', '2017-12-29 15:31:15', '2017-12-29 15:31:15', '1', '2', '的方式更多', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/52201514532653308.png', '<p>的方式发给<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('71', '2017-12-29 15:31:18', '2017-12-29 15:31:18', '1', '2', '的方式更多', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/52201514532653308.png', '<p>地方郭德纲双方各三国杀法国队<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('72', '2017-12-29 15:41:07', '2017-12-29 15:41:07', '1', '2', 'dgds', null, '<p>&nbsp;sdg<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('73', '2017-12-29 15:41:16', '2017-12-29 15:41:16', '1', '2', 'dsfdzsf ', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/30381514533295267.gif', '<br><p>asdfdsfasfsdfasdffsdsfafsdfafffshfkljsdhfsluhiwuhrfklsdfhsdkljchlisuhflsifhsldfhsaluehfklfhklhflkhjdslfhuspifuha<br></p><p>fgsgfd<br></p><p>g fggddgfsgfdsg<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('74', '2017-12-29 16:33:20', '2017-12-29 16:33:20', '1', '1', '是的范德萨', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/68271514536392911.gif', '<p>东方肝胆<br></p><p>十多个<br></p><p><br>第三个是否绑定豆腐干很多事</p><p>sdgfs发<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('75', '2017-12-29 16:36:56', '2017-12-29 16:37:00', '1', '1', '水电费', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/7021514536614111.png', '<p>水电费<br></p><p><br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('76', '2017-12-29 16:37:35', '2017-12-29 16:37:35', '1', '2', ' 地方该公司', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/55131514536647515.png', '<p>大股东分公司<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('77', '2017-12-29 16:37:38', '2017-12-29 16:37:38', '1', '1', ' 地方该公司', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/55131514536647515.png', '<p>大股东分公司<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('78', '2017-12-29 16:38:40', '2017-12-29 16:38:40', '1', '2', '覆盖', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/76021514536713456.gif', '<p>大锅饭<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('79', '2017-12-29 16:38:49', '2017-12-29 16:38:49', '1', '2', '覆盖', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/76021514536713456.gif', '<p>大锅饭规范化<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('80', '2017-12-29 16:42:17', '2017-12-29 16:42:17', '1', '2', '双方都打算读法', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/48671514536932477.png', '<p>手动阀电风扇<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('81', '2017-12-29 16:42:22', '2017-12-29 16:42:22', '1', '2', '双方都打算读法', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/48671514536932477.png', '<p>手动阀电风扇鼎折覆餗<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('82', '2017-12-29 16:46:57', '2017-12-29 16:46:57', '1', '2', '双方都打算读法', null, '<p>大锅饭<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('83', '2017-12-29 16:51:15', '2018-01-03 10:15:17', '1', '1', '手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/42711514537472016.gif', '<p>手动阀<br></p><p><br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('84', '2017-12-29 16:51:18', '2017-12-29 16:51:18', '1', '2', '手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/42711514537472016.gif', '<p>手动阀<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('85', '2017-12-29 16:51:21', '2017-12-29 16:51:21', '1', '2', '手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/42711514537472016.gif', '<p>手动阀<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('86', '2017-12-29 16:51:24', '2017-12-29 16:51:24', '1', '2', '手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/42711514537472016.gif', '<p>手动阀<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('87', '2017-12-29 16:51:27', '2017-12-29 16:51:27', '1', '2', '手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/42711514537472016.gif', '<p>手动阀<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('88', '2017-12-29 16:51:30', '2017-12-29 16:51:30', '1', '2', '手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/42711514537472016.gif', '<p>手动阀<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('89', '2017-12-29 16:51:37', '2017-12-29 16:51:37', '1', '2', '手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/42711514537472016.gif', '<p>手动阀<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('90', '2017-12-29 16:51:38', '2017-12-29 16:51:38', '1', '2', '手动阀', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/42711514537472016.gif', '<p>手动阀<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('91', '2017-12-29 16:52:24', '2017-12-29 16:52:24', '1', '2', '手动阀', null, '<p>手动阀<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('92', '2017-12-29 16:53:33', '2017-12-29 16:53:33', '1', '2', '手动阀', null, '<p>都是<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('93', '2017-12-29 16:53:36', '2017-12-29 16:53:36', '1', '2', '手动阀', null, '<p>都是<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('94', '2017-12-29 16:53:39', '2017-12-29 16:53:39', '1', '2', '手动阀', null, '<p>都是<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('95', '2017-12-29 16:53:42', '2017-12-29 16:53:42', '1', '2', '手动阀', null, '<p>都是<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('96', '2017-12-29 16:53:45', '2017-12-29 16:53:45', '1', '2', '手动阀', null, '<p>都是<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('97', '2017-12-29 16:53:56', '2017-12-29 16:53:56', '1', '2', '手动阀', null, '<p>返回<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('98', '2017-12-29 16:55:55', '2017-12-29 16:55:55', '1', '2', '手动阀', null, '<p>&nbsp;覆盖<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('99', '2017-12-29 16:56:26', '2017-12-29 16:56:26', '1', '2', '手动阀', null, '<p>是多少<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('100', '2017-12-29 16:56:54', '2017-12-29 16:56:54', '1', '2', '手动阀', null, '<p>&nbsp;豆腐干豆腐<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('101', '2017-12-29 16:57:03', '2017-12-29 16:57:03', '1', '2', '手动阀', null, '<p>&nbsp;豆腐干豆腐郭德纲发的广东省<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('102', '2017-12-29 16:58:35', '2017-12-29 16:58:35', '1', '2', '手动阀', null, '<p>手动阀<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('103', '2017-12-29 17:00:18', '2017-12-29 17:00:18', '1', '2', '手动阀', null, '<p>sdfg <br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('104', '2017-12-29 17:00:21', '2017-12-29 17:01:03', '1', '2', '手动阀', null, '<p>sdfg dfs <br></p><p>sfasfsf <br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('105', '2017-12-29 17:01:54', '2017-12-29 17:01:54', '1', '2', 'sfa ', null, '<p>sfa <br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('106', '2017-12-29 17:02:24', '2017-12-29 17:02:24', '1', '2', 'sfa ', null, '<p>sfdsf <br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('107', '2017-12-29 17:13:40', '2017-12-29 17:13:40', '1', '2', 'asdfs ', null, '<p>sdfa <br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('108', '2017-12-29 17:14:21', '2017-12-29 17:14:21', '1', '2', '107dfg ', null, '<p>sdfa <br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('109', '2017-12-29 17:16:47', '2017-12-29 17:16:47', '1', '2', '108sdfa', null, '<p>asdfa <br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('110', '2017-12-29 17:16:59', '2017-12-29 17:16:59', '1', '2', '108sdfa', null, '<p>asdfa sdfgdssdgdfgdgfdgsg<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('111', '2017-12-29 17:17:11', '2017-12-29 17:17:11', '1', '2', '108sdfa', null, '<p>sfdsd<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('112', '2017-12-29 17:17:17', '2018-01-09 09:41:50', '1', '2', '108sdfa', null, '<p>热容易让韩国电饭锅<br></p><p><br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('113', '2017-12-29 17:17:26', '2017-12-29 17:17:26', '1', '2', '1111111', null, '<p>sfdsdxcgdsfgdgfdfgddgdsgdfgdsg<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('114', '2017-12-29 17:17:29', '2018-01-02 11:24:39', '1', '1', '323442423424', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2018-01-02/38801514863453506.gif', '<p>测试保存<br></p><p><br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('115', '2017-12-29 17:18:08', '2017-12-29 17:50:34', '1', '1', 'qqqq', null, '<p>对方考虑是否会是浪费那快递费难道是开放后付款<br></p><p><br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('116', '2017-12-29 17:49:53', '2017-12-29 17:49:58', '1', '1', '电饭锅 ', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2017-12-29/70031514540994375.png', '<p>豆腐干豆腐是的<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('117', '2018-01-02 16:58:16', '2018-01-02 16:58:19', '1', '1', '是大法师服务热情', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2018-01-02/40391514883492623.png', '<p>大商股份第三方第三个的<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('118', '2018-01-02 16:59:22', '2018-01-02 16:59:28', '1', '1', '的规范地方', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2018-01-02/91741514883558064.gif', '<p>对方广东省郭德纲<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('119', '2018-01-04 17:22:22', '2018-01-04 17:22:22', '1', '1', '巧除衣服上的可乐渍', null, '<p>\n服染上了可乐污迹，应该立刻用冷水或中性洗衣剂清洗。残余污迹，可进行漂白处理。\n\n</p>', '1', '0');
INSERT INTO `tip_content` VALUES ('120', '2018-01-04 17:24:38', '2018-01-04 17:30:44', '1', '1', '的司法改革', null, '<p>十多个<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('121', '2018-01-08 09:44:04', '2018-01-08 09:44:04', '1', '1', '的覆盖率还是给司空见惯考虑实际', null, '<h1><span style=\"background-color: rgb(238, 236, 224);\">覆盖和儿童的和</span></h1><p><i>dfgsdfdg</i></p><p><img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2018-01-08/35171515375800235.gif\" style=\"max-width:100%;\"></p><p><u>地方广东省科技活动官方说</u></p><p><br></p><p><strike><br></strike></p><p><strike>单方事故计划接口</strike></p><p><br></p><p><br></p><p><br></p><p><img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2018-01-08/46391515375808044.gif\" style=\"max-width:100%;\"></p><table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></tbody></table><p>的水果蛋糕发</p><p><br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('122', '2018-01-08 16:12:41', '2018-01-08 16:12:41', '1', '1', '高大上', 'http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/23/2018-01-08/29161515399157073.gif', '<p>第三方广东省<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('123', '2018-01-09 13:47:54', '2018-01-09 13:48:00', '1', '1', '测试', null, '<p>撒打发士大夫撒范德萨发顺丰是否打佛挡杀佛asf 大是大非撒发as发大厦发as发萨芬 大声道发as发送 发送到 安抚是发萨芬as发按时发生发as<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('124', '2018-01-09 13:48:29', '2018-01-09 13:48:34', '1', '1', '第三个是个的', null, '<p><img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2018-01-09/87971515476906801.gif\" style=\"max-width: 100%;\" width=\"1223\" height=\"200\"></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('125', '2018-01-09 13:55:44', '2018-01-09 13:55:46', '1', '1', '电饭锅电饭锅', null, '<p>先达股份付付付付多付过多多过多付过多 大锅饭给对方刚发的电饭锅电饭锅地方个电饭锅电<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('126', '2018-01-09 13:56:13', '2018-01-09 13:56:14', '1', '1', '第三方广东省', null, '<p>的说法是否的地方士大夫撒这是的发的撒打算士大夫撒发生是大法师读法是大法师读法水电费大厦发阿斯顿发生爱上<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('127', '2018-01-10 17:35:30', '2018-01-12 10:41:33', '2', '2', '2313', null, '<p>sdfsfsfdgfssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss</p><p><img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2018-01-10/71441515577165765.png\" style=\"max-width:100%;\"></p><p>ssssssssssdffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff<br></p><p><img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2018-01-10/51321515577161328.gif\" style=\"max-width:100%;\"></p><p><br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('128', '2018-01-11 09:20:19', '2018-01-11 09:22:12', '1', '1', '11', null, '<blockquote><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\"></p></blockquote><table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></tbody></table><p><br></p><p><br><img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2018-01-11/52861515633669862.gif\" style=\"max-width:100%;\"></p><p><img src=\"http://sharetip.oss-cn-hangzhou.aliyuncs.com/tip/1/2018-01-11/32201515633674759.png\" style=\"max-width: 100%;\" width=\"279\" height=\"279\"></p><p><br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('129', '2018-01-11 10:08:16', '2018-01-11 10:09:08', '1', '2', '地方不合法的', null, '<p>地方更好地方规划发担任分公司<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('130', '2018-01-11 10:51:44', '2018-01-11 17:33:46', '1', '1', '的幸福感的', null, '<p><br><a href=\"sdffd\" target=\"_blank\">werrer</a></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('131', '2018-01-11 10:52:00', '2018-01-11 10:52:00', '1', '1', '电风扇', null, '<p>十多个<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('132', '2018-01-11 16:37:33', '2018-01-11 16:37:39', '1', '2', 'rtretrew ', null, '<p>sfasdfsffdsdffsfdasfdsf</p><p>dsfs</p><p><br></p><p>fas</p><p>f</p><p>s</p><p>fas</p><p>f</p><p>as<br></p>', '1', '1');
INSERT INTO `tip_content` VALUES ('133', '2018-01-11 17:34:11', '2018-01-11 17:34:20', '1', '1', 'sdg', null, '<p>sffdfsff<a href=\"https://www.baidu.com/baidu?wd=%E7%9F%A5%E4%B9%8E&amp;tn=monline_4_dg&amp;ie=utf-8\" target=\"_blank\">sdfsfsfs</a></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('134', '2018-01-12 10:29:48', '2018-01-12 10:30:24', '1', '2', '1', null, '<p>&nbsp;手动阀发送到人工费单方事故身份她阿尔发说说<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('135', '2018-01-12 11:43:02', '2018-01-12 11:43:02', '2', '2', '是否', null, '<p>是<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('136', '2018-01-12 11:47:01', '2018-01-12 11:47:23', '2', '2', '水电费', null, '<p>发<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('137', '2018-01-12 11:53:23', '2018-01-12 11:53:23', '2', '2', '算法', null, '<p>&nbsp;地方<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('138', '2018-01-12 11:53:45', '2018-01-12 11:53:55', '2', '2', '啊啊', null, '<p>啊v<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('139', '2018-01-12 11:54:13', '2018-01-12 11:54:13', '2', '2', '胜多负少', null, '<p>水电费<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('140', '2018-01-12 13:14:05', '2018-01-12 13:15:54', '1', '2', '水电费', null, '<p>萨芬的<br></p><p><br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('164', '2018-01-12 13:50:46', '2018-01-12 13:52:51', '1', '2', '第三方士大夫', null, '<p>水电费大商股份<br></p><p>电饭锅<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('165', '2018-01-12 13:54:10', '2018-01-12 13:54:22', '2', '2', '的归属感古代诗歌', null, '<p>是范德萨<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('166', '2018-01-12 13:55:45', '2018-01-12 15:02:28', '1', '2', '请输入标题', null, '<p>&nbsp;无数人特别 <br></p><p><br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('167', '2018-01-12 15:46:02', '2018-01-12 15:46:03', '1', '1', '沙发沙发上发顺丰撒方式', null, '<p>水电费大厦发沙发沙发上打发<br></p>', '1', '0');
INSERT INTO `tip_content` VALUES ('168', '2018-01-12 15:56:01', '2018-01-12 15:56:02', '1', '1', '第一个测试', null, '<p>沙发沙发沙发上发大厦 水电费as发萨芬发斯蒂芬安抚啊<br></p>', '12', '0');
INSERT INTO `tip_content` VALUES ('169', '2018-01-12 16:06:10', '2018-01-12 16:06:10', '2', '1', '是的冯绍峰三', null, '<p>打算发送 <br></p>', '18', '0');

-- ----------------------------
-- Table structure for tip_label
-- ----------------------------
DROP TABLE IF EXISTS `tip_label`;
CREATE TABLE `tip_label` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `tip_id` bigint(20) unsigned NOT NULL COMMENT '技巧ID',
  `label_id` bigint(20) unsigned NOT NULL COMMENT '标签ID',
  `member_id` bigint(20) unsigned NOT NULL COMMENT '贴标签的用户ID',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_uk_tip_label` (`tip_id`,`label_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='技巧与标签映射表';

-- ----------------------------
-- Records of tip_label
-- ----------------------------

-- ----------------------------
-- Table structure for tip_plate
-- ----------------------------
DROP TABLE IF EXISTS `tip_plate`;
CREATE TABLE `tip_plate` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `tip_id` bigint(20) unsigned NOT NULL COMMENT '技巧ID',
  `plate_id_1` bigint(20) unsigned DEFAULT NULL COMMENT '板块ID',
  `plate_id_2` bigint(20) unsigned DEFAULT NULL COMMENT '板块ID',
  `plate_id_3` bigint(20) unsigned DEFAULT NULL COMMENT '板块ID',
  `plate_id_4` bigint(20) unsigned DEFAULT NULL COMMENT '板块ID',
  `plate_id_5` bigint(20) unsigned DEFAULT NULL COMMENT '板块ID',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_uk_tip_plate` (`tip_id`,`plate_id_1`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='技巧与板块映射表';

-- ----------------------------
-- Records of tip_plate
-- ----------------------------
INSERT INTO `tip_plate` VALUES ('1', '2018-01-12 13:50:46', '2018-01-12 13:50:46', '164', '2', '13', null, null, null, '0');
INSERT INTO `tip_plate` VALUES ('2', '2018-01-12 13:54:10', '2018-01-12 13:54:10', '165', '2', '6', null, null, null, '0');
INSERT INTO `tip_plate` VALUES ('3', '2018-01-12 15:02:28', '2018-01-12 15:02:28', '166', '6', '10', '10', null, null, '0');
INSERT INTO `tip_plate` VALUES ('4', '2018-01-12 15:46:03', '2018-01-12 15:46:03', '167', '2', '1', '11', null, null, '0');
INSERT INTO `tip_plate` VALUES ('5', '2018-01-12 15:56:02', '2018-01-12 15:56:02', '168', '2', '4', '6', null, null, '0');
INSERT INTO `tip_plate` VALUES ('6', '2018-01-12 16:06:10', '2018-01-12 16:06:10', '169', '2', '4', '6', null, null, '0');

-- ----------------------------
-- Table structure for tip_prop
-- ----------------------------
DROP TABLE IF EXISTS `tip_prop`;
CREATE TABLE `tip_prop` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `prop_id` bigint(20) unsigned NOT NULL COMMENT '道具ID',
  `tip_id` bigint(20) unsigned NOT NULL COMMENT '技巧ID',
  `is_effective` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:已失效；1：未失效',
  `name` varchar(100) DEFAULT NULL COMMENT '道具名称（冗余）',
  `code` tinyint(3) unsigned DEFAULT NULL COMMENT '道具码（冗余）',
  `cost_point` bigint(20) unsigned DEFAULT NULL COMMENT '花费积分（冗余）',
  `duration` int(10) unsigned DEFAULT NULL COMMENT '持续时间（分）',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='技巧道具映射';

-- ----------------------------
-- Records of tip_prop
-- ----------------------------

-- ----------------------------
-- Table structure for tip_thumbs_up
-- ----------------------------
DROP TABLE IF EXISTS `tip_thumbs_up`;
CREATE TABLE `tip_thumbs_up` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '统一主键',
  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '记录最近更新时间',
  `member_id` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `tip_id` bigint(20) unsigned NOT NULL COMMENT '技巧ID',
  `thumbs_up_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未点赞；1：已点赞 ;',
  `del_f` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未删除；1：删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_uk_member_tip_thumbs_up` (`member_id`,`tip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='技巧点赞表';

-- ----------------------------
-- Records of tip_thumbs_up
-- ----------------------------
