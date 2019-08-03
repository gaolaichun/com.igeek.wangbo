/*
 Navicat Premium Data Transfer

 Source Server         : MySql5.5
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : ayou

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 02/08/2019 13:35:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for body_qualifications
-- ----------------------------
DROP TABLE IF EXISTS `body_qualifications`;
CREATE TABLE `body_qualifications`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主体资质认证表',
  `certificate_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件类型',
  `certificate_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件图片',
  `registration_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册号',
  `unit_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位名称',
  `legal_person` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人',
  `premises` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经营场所',
  `license_period` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执照期限',
  `sid` int(11) NULL DEFAULT NULL COMMENT '商家ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of body_qualifications
-- ----------------------------
INSERT INTO `body_qualifications` VALUES (1, '港澳通行证', '', '10086', '小淮娘', '张三', '无锡市', '美食', 1);
INSERT INTO `body_qualifications` VALUES (2, '食品安全证', ' ', '100500002', '奥斯卡', '李四', '无锡市', '餐饮', 2);
INSERT INTO `body_qualifications` VALUES (3, '经营许可证', '3.jpg', '100500003', '多伦多', '王五', '无锡市', '火锅', 3);
INSERT INTO `body_qualifications` VALUES (4, NULL, NULL, NULL, NULL, '刘备', NULL, NULL, 4);
INSERT INTO `body_qualifications` VALUES (5, NULL, '/file/2019-07/2019-07-30/a74a4af679ce4b43b7bcd76b29077ab8.jpg', NULL, NULL, '张飞', NULL, NULL, 5);

-- ----------------------------
-- Table structure for consumption
-- ----------------------------
DROP TABLE IF EXISTS `consumption`;
CREATE TABLE `consumption`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '消费表',
  `consumptionPatterns` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消费方式（支付宝/微信）',
  `statement` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消费明细',
  `creteTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  `uid` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for database
-- ----------------------------
DROP TABLE IF EXISTS `database`;
CREATE TABLE `database`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `meaning` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `data_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名称',
  `create_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of database
-- ----------------------------
INSERT INTO `database` VALUES (1, '用户表', 'user', 'lixiang', '2019-07-11 18:10:31');
INSERT INTO `database` VALUES (2, '用户关注中间表', 'follow', 'wangbo', '2019-07-16 14:22:33');
INSERT INTO `database` VALUES (3, '商户表', 'shop', 'chenwei', '2019-07-19 09:36:09');
INSERT INTO `database` VALUES (4, '店内设施', 'installation', 'wangbo', '2019-07-24 15:17:10');
INSERT INTO `database` VALUES (5, '派对表', 'party', 'chenwei', '2019-07-19 11:00:39');
INSERT INTO `database` VALUES (6, '消费表', 'consumption', 'chenwei', '2019-07-19 11:31:09');
INSERT INTO `database` VALUES (7, '经纬度表', 'seat', 'wangbo', '2019-07-19 13:32:40');
INSERT INTO `database` VALUES (8, '行业资质表', 'industry_qualification', NULL, '2019-07-23 13:05:55');
INSERT INTO `database` VALUES (9, '订单表', 'order', NULL, '2019-07-23 13:06:56');
INSERT INTO `database` VALUES (10, '套餐表', 'package', NULL, '2019-07-23 13:07:48');
INSERT INTO `database` VALUES (11, '套餐详情表', 'package_detail', NULL, '2019-07-23 13:08:23');
INSERT INTO `database` VALUES (12, '商家分类表', 'shop_category', NULL, '2019-07-23 13:09:49');
INSERT INTO `database` VALUES (13, '门店营业时间表', 'shop_opening_hours', NULL, '2019-07-23 13:10:38');
INSERT INTO `database` VALUES (14, '商家相册', 'shop_picture', NULL, '2019-07-23 13:11:16');
INSERT INTO `database` VALUES (15, '个人资质认证表', 'personal_qualification', NULL, '2019-07-26 14:08:57');
INSERT INTO `database` VALUES (16, '主体资质表', 'body_qualifications', NULL, '2019-07-26 14:09:39');
INSERT INTO `database` VALUES (17, '套餐分类表', 'package_ category', 'wangbo', '2019-07-26 14:42:27');
INSERT INTO `database` VALUES (18, '账单表', 'shop_bill', 'lixiang', '2019-07-31 17:36:30');
INSERT INTO `database` VALUES (19, '商家提现表', 'shop_withdraw', 'lixiang', '2019-08-01 10:40:56');

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gid` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of follow
-- ----------------------------
INSERT INTO `follow` VALUES (1, '123456', '456123');
INSERT INTO `follow` VALUES (2, '456123', '123456');
INSERT INTO `follow` VALUES (3, '123456', '654987');
INSERT INTO `follow` VALUES (4, '456123', '654987');
INSERT INTO `follow` VALUES (5, '654987', '123456');

-- ----------------------------
-- Table structure for industry_qualification
-- ----------------------------
DROP TABLE IF EXISTS `industry_qualification`;
CREATE TABLE `industry_qualification`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '行业资质表ID',
  `certificate_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件类型',
  `certificate_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件图片',
  `license_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '许可证编号',
  `unit_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位名称',
  `legal_person` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人',
  `premises` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经营场所',
  `business_project` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经营项目',
  `license_period` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执照期限',
  `sid` int(11) NULL DEFAULT NULL COMMENT '商家ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of industry_qualification
-- ----------------------------
INSERT INTO `industry_qualification` VALUES (1, '经营生产证', '1.jpg', '100500002', '小淮娘', '张三', '无锡市', '美食', '2018.12.15', 1);
INSERT INTO `industry_qualification` VALUES (2, '食品安全证', '2.jpg', '100500002', '奥斯卡', '李四', '无锡市', '餐饮', '2018.12.19', 2);
INSERT INTO `industry_qualification` VALUES (3, '身份证', '3.jpg', NULL, NULL, '马芸', NULL, NULL, NULL, 3);
INSERT INTO `industry_qualification` VALUES (4, '身份证', '/file/2019-07/2019-07-30/928605fe32b34daea777cc2a25f952ca.jpg', NULL, NULL, '曹操', NULL, NULL, NULL, 4);
INSERT INTO `industry_qualification` VALUES (5, NULL, '5.jpg', NULL, NULL, '张飞', NULL, NULL, NULL, 5);

-- ----------------------------
-- Table structure for installation
-- ----------------------------
DROP TABLE IF EXISTS `installation`;
CREATE TABLE `installation`  (
  `id` int(11) NOT NULL COMMENT '店内设施id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of installation
-- ----------------------------
INSERT INTO `installation` VALUES (1, '免费wifi');
INSERT INTO `installation` VALUES (2, '停车服务');
INSERT INTO `installation` VALUES (3, '市中心');
INSERT INTO `installation` VALUES (4, '靠地铁站');
INSERT INTO `installation` VALUES (5, '网红打卡');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单表ID',
  `order_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `uid` int(11) NULL DEFAULT NULL COMMENT '下单人ID',
  `price` double(30, 2) NULL DEFAULT NULL COMMENT '订单金额',
  `order_time` datetime NULL DEFAULT NULL COMMENT '下单时间',
  `coupon` int(11) NULL DEFAULT 0 COMMENT '优惠券id，若未使用则为0',
  `red_package` int(11) NULL DEFAULT 0 COMMENT '红包id，若未使用红包则是0',
  `pay_time` datetime NULL DEFAULT NULL COMMENT '支付时间',
  `sid` int(11) NULL DEFAULT NULL COMMENT '商家ID',
  `order_status` int(11) NULL DEFAULT 5 COMMENT '订单状态(5未接单，1完成,4,进行中，3无效)',
  `participants` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参加人数',
  `package_id` int(11) NULL DEFAULT NULL COMMENT '套餐ID',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `party_id` int(11) NULL DEFAULT NULL COMMENT '派对id',
  `party_time` datetime NULL DEFAULT NULL COMMENT '參加派對時間',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, '123456', 12, 6000.00, '2019-07-28 17:44:39', 0, 0, '2019-07-29 23:59:59', 1, 1, '10', 1, '啦啦啦啦', 1, '2019-07-30 00:00:01');
INSERT INTO `order` VALUES (2, '321654', 23, 500.00, '2019-07-24 17:46:30', 0, 0, '2019-07-30 00:01:44', 1, 1, '5', 1, '哈哈哈哈哈哈', 2, '2019-07-29 23:59:59');
INSERT INTO `order` VALUES (3, '520520', 520, 520.00, '2019-07-30 09:10:00', 0, 0, '2019-07-30 10:10:02', 1, 1, '2', 1, '嘿嘿嘿嘿', 3, '2019-07-25 15:43:50');
INSERT INTO `order` VALUES (4, '321654654', 321, 654.00, '2019-07-29 18:07:02', 0, 0, '2019-07-29 18:07:10', 1, 1, '6', 2, '默默默默默默', 4, '2019-07-18 15:44:01');
INSERT INTO `order` VALUES (5, '987987', 987, 68.00, '2019-07-17 15:42:02', 0, 0, '2019-07-17 15:42:22', 1, 1, '5', 1, '嘻嘻嘻嘻嘻嘻', 5, '2019-06-12 15:44:07');

-- ----------------------------
-- Table structure for package
-- ----------------------------
DROP TABLE IF EXISTS `package`;
CREATE TABLE `package`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '套餐表ID',
  `sid` int(11) NULL DEFAULT NULL COMMENT '商家id',
  `package_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '套餐名称',
  `package_status` int(11) NULL DEFAULT 0 COMMENT '套餐状态（1上架，0下架，-1售罄）',
  `start_time` datetime NULL DEFAULT NULL COMMENT '售卖开始时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '售卖结束时间',
  `priority` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '优先级',
  `sale` int(11) NULL DEFAULT NULL COMMENT '月销售份数',
  `package_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '套餐图片',
  `people_number` int(11) NULL DEFAULT NULL COMMENT '套餐人数',
  `current_stock` int(10) NULL DEFAULT NULL COMMENT '当前库存',
  `max_stock` int(10) NULL DEFAULT NULL COMMENT '最大库存',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '套餐价格',
  `package_category` int(11) NULL DEFAULT NULL COMMENT '套餐类别id',
  `package_sort` int(11) NULL DEFAULT NULL COMMENT '默认排序功能',
  `opens` int(11) NULL DEFAULT 0 COMMENT '次日库存置满开关（1.开启。0.关闭）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of package
-- ----------------------------
INSERT INTO `package` VALUES (1, 1, '情侣套餐', 0, '2019-07-23 15:29:01', '2019-07-23 15:29:09', '1', 10, NULL, 10, 200, 6000, 100.34, 3, 1, 1);
INSERT INTO `package` VALUES (2, 1, '多人套餐', 1, '2019-07-23 15:29:38', '2019-07-23 15:29:41', '2', 30, '', 10, 300, 6000, 100.34, 3, 2, 1);
INSERT INTO `package` VALUES (3, 2, '多人套餐', -1, '2019-07-23 15:29:38', '2019-07-23 15:29:41', '2', 20, '', 10, 10, 6000, 100.34, 2, 1, 1);
INSERT INTO `package` VALUES (4, 1, '测试套餐名', 1, NULL, NULL, NULL, NULL, NULL, 10, 500, 1000, 100000.00, 1, 0, 1);

-- ----------------------------
-- Table structure for package_category
-- ----------------------------
DROP TABLE IF EXISTS `package_category`;
CREATE TABLE `package_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '套餐类别id',
  `package_category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '套餐分类名',
  `sid` int(11) NULL DEFAULT NULL COMMENT '商家id',
  `category_order` int(11) NULL DEFAULT NULL COMMENT '套餐类别排序',
  `sort_mode` int(11) NULL DEFAULT 0 COMMENT '套餐排序方式（1销量排序，0默认category_order排序，-1库存排序）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of package_category
-- ----------------------------
INSERT INTO `package_category` VALUES (1, '两人餐', 1, 1, 1);
INSERT INTO `package_category` VALUES (2, '5-8人套餐', 1, 2, 2);
INSERT INTO `package_category` VALUES (3, '8-10人套餐', 1, 3, 3);
INSERT INTO `package_category` VALUES (4, '百人大桌', 1, 4, 4);

-- ----------------------------
-- Table structure for package_detail
-- ----------------------------
DROP TABLE IF EXISTS `package_detail`;
CREATE TABLE `package_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '套餐详情表ID',
  `package_id` int(11) NULL DEFAULT NULL COMMENT '套餐ID',
  `dish_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜品名字',
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜品份数',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '菜品价格',
  ` goods_sort` int(11) NULL DEFAULT NULL COMMENT '菜品默认排序功能',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of package_detail
-- ----------------------------
INSERT INTO `package_detail` VALUES (1, 1, '红烧猪蹄', '2份', 132.00, 1);
INSERT INTO `package_detail` VALUES (2, 1, '凉拌黄瓜', '1份', 15.00, 2);
INSERT INTO `package_detail` VALUES (3, 2, '红烧大肠', '2份', 50.00, 1);
INSERT INTO `package_detail` VALUES (4, 2, '口水鸡', '1份', 60.00, 2);
INSERT INTO `package_detail` VALUES (5, 2, '麻辣小龙虾', '1份', 150.00, 3);

-- ----------------------------
-- Table structure for party
-- ----------------------------
DROP TABLE IF EXISTS `party`;
CREATE TABLE `party`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '派对表ID',
  `pid` int(11) NULL DEFAULT NULL COMMENT '派对ID',
  `uid` int(11) NULL DEFAULT NULL COMMENT '组织者ID',
  `sid` int(11) NULL DEFAULT NULL COMMENT '商家ID',
  `model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模式（AA/请客）',
  `agreed_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '约定时间（飯點）',
  `limit_person` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '限定人数',
  `limit_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '限定性别',
  `limit_age` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '限定年龄',
  `trust` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信任度',
  `all_uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参加人ID集合',
  `price` double(30, 2) NULL DEFAULT NULL COMMENT '价格',
  `party_instruction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '派对说明',
  `create_time` datetime NULL DEFAULT NULL COMMENT '发起时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of party
-- ----------------------------
INSERT INTO `party` VALUES (1, 10001, 1, 1, 'AA', NULL, '2', '女', '20-30岁', NULL, NULL, 500.00, '约会吃饭', NULL);

-- ----------------------------
-- Table structure for personal_qualification
-- ----------------------------
DROP TABLE IF EXISTS `personal_qualification`;
CREATE TABLE `personal_qualification`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '个人资质认证表ID',
  `certificate_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件类型',
  `realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `certificate_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件号码',
  `certification_status` int(11) NULL DEFAULT 0 COMMENT '认证状态(个人身份认证，1：审核通过，0，审核未通过)',
  `sid` int(11) NULL DEFAULT NULL COMMENT '商家ID',
  `idcard_picone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证正面照',
  `idcard_pictwo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证反面照',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of personal_qualification
-- ----------------------------
INSERT INTO `personal_qualification` VALUES (1, '身份证', '马云', '321084199602210212', 0, 1001, '1.jpg', '2.jpg');
INSERT INTO `personal_qualification` VALUES (2, '身份证', '李四', '321084199802212230', 1, 2, NULL, NULL);
INSERT INTO `personal_qualification` VALUES (3, '身份证', '王五', '321084199802212231', 0, 3, NULL, NULL);
INSERT INTO `personal_qualification` VALUES (4, NULL, '白客', '321084199605255556', 0, 1004, '', '');

-- ----------------------------
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '经纬度表id',
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户uid',
  `longitude` double(255, 6) NULL DEFAULT NULL COMMENT '经度',
  `latitude` double(255, 6) NULL DEFAULT NULL COMMENT '纬度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of seat
-- ----------------------------
INSERT INTO `seat` VALUES (1, '123456', 106.206654, 29.490295);
INSERT INTO `seat` VALUES (2, '456123', 106.581515, 29.615467);
INSERT INTO `seat` VALUES (3, '654987', 106.381515, 29.515467);

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商家表ID',
  `shop_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家用户名（登录app)',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家登录密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家名称',
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在地区',
  `longitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经度',
  `latitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `certification_status` int(11) NULL DEFAULT 0 COMMENT '认证状态(个人身份认证，1：通过，0，不通过)',
  `industry_qualification` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行业资质',
  `subject_qualification` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主体资质',
  `special_qualification` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '特殊资质',
  `headlink` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门店头像连接',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家电话(必填）',
  `phone_sec` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家电话(选填)',
  `phone_thr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家电话(选填)',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家地址',
  `second_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '次营分类id',
  `main_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主营分类id',
  `wallet` double(11, 2) NULL DEFAULT NULL COMMENT '钱包(余额)',
  `hold_no` int(20) NULL DEFAULT NULL COMMENT '举办次数',
  `shop_qr_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门店二维码',
  `business_hourone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '营业时间段1',
  `business_hourtwo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业时间段2',
  `business_hourthree` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业时间段3',
  `announcement` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门店公告',
  `shop_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门店简介',
  `bill` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票',
  `business_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开店1，关店0',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门店相册',
  `priority` int(11) NULL DEFAULT 1 COMMENT '优先级（1是最低优先级）',
  `warm_prompt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '温馨提示',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES (1, '13348101810', '888888', '蓝莲花', '江苏省无锡市梁溪区', '106.206654', '29.490295', 1, '无', '无', NULL, '/file/2019-07/2019-07-27/09ac670628c34108aff3448faed1adac.jpg', '188888', '10086', '10020', '三阳广场大东方百货201', '自助', '酒吧', 10000.00, 10, '二维码1.jpg', '5:30-9:30 ', '16:00-18:00', '21:00-24:00', '门店每周日休息，谢谢', '网红店', '不提供', '1', '6.jpg', 1, '停车免费 免费茶水 免费提供WIFI');
INSERT INTO `shop` VALUES (2, '13380609030', '888888', '奥斯卡', '江苏省无锡市新区', '106.206654', '29.490295', 1, '无', '无', NULL, 'http://jingyan.baidu.com/album/46650658daf97df549e5f833.html?picindex=1', '119', '911', '114', '无锡市梁溪区清扬路1号', '异国料理', '香锅火锅', 10000.00, 10, '二维码2.jpg', '5:30-9:30 ', '16:00-18:00', '21:00-24:00', '门店每周日休息，谢谢', '网红店', '不提供', '1', 'http://cdn.duitang.com/uploads/item/201410/06/20141006213125_PtNn8.thumb.700_0.jpeg', 1, '免费提供WIFI');
INSERT INTO `shop` VALUES (3, '13380609060', '888888', '多伦多', '江苏省无锡市锡山区', '106.206654', '29.490295', 1, '无', '无', NULL, 'http://jingyan.baidu.com/album/46650658daf97df549e5f833.html?picindex=1', '119', '114', ' 119', '无锡市梁溪区清扬路2号', '异国料理', '香锅火锅', 10000.00, 10, '二维码3jpg', '5:30-9:30 ', '16:00-18:00', '21:00-24:00', '门店每周日休息，谢谢', '网红店', '不提供', '1', 'http://cdn.duitang.com/uploads/item/201410/06/20141006213125_PtNn8.thumb.700_0.jpeg', 1, '免费提供WIFI');
INSERT INTO `shop` VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '9:00-10:00', '12:00-17:00', NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `shop` VALUES (5, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '9:00-10:00', '12:00-17:00', '18:00-23:00', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `shop` VALUES (6, NULL, NULL, '大渝火锅', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, '110', '119', '10086', NULL, NULL, NULL, NULL, NULL, NULL, '9:00-10:00', '12:00-17:00', '18:00-23:00', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `shop` VALUES (7, NULL, NULL, '云浮酒店', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL);

-- ----------------------------
-- Table structure for shop_bill
-- ----------------------------
DROP TABLE IF EXISTS `shop_bill`;
CREATE TABLE `shop_bill`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NULL DEFAULT NULL COMMENT '商户id',
  `type_transcation` int(11) NULL DEFAULT NULL COMMENT '交易类型,1账单结算，2余额充值，3余额提现',
  `describe_transcation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易描述',
  `money` double(30, 2) NULL DEFAULT NULL COMMENT '金额',
  `total_money` double(30, 2) NULL DEFAULT NULL COMMENT '可用余额',
  `status_transcation` int(11) NULL DEFAULT 0 COMMENT '交易状态,0失败，1成功',
  `status_settlement` int(11) NULL DEFAULT NULL COMMENT '结算状态，0未结算，1已结算(提现或充值无该属性)',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `zfb_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '若为提现，填入支付宝账号',
  `create_time` datetime NULL DEFAULT NULL COMMENT '生成账单时间',
  `finish_time` datetime NULL DEFAULT NULL COMMENT '完成时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for shop_category
-- ----------------------------
DROP TABLE IF EXISTS `shop_category`;
CREATE TABLE `shop_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商家分类表',
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shop_category
-- ----------------------------
INSERT INTO `shop_category` VALUES (1, '餐饮', '2019-07-25 19:15:33');
INSERT INTO `shop_category` VALUES (2, 'KTV', '2019-07-25 19:15:59');
INSERT INTO `shop_category` VALUES (3, '酒吧', '2019-07-25 19:16:21');
INSERT INTO `shop_category` VALUES (4, '轰趴', '2019-07-25 19:16:30');
INSERT INTO `shop_category` VALUES (5, '影院', '2019-07-25 19:19:42');
INSERT INTO `shop_category` VALUES (6, '电竞', '2019-07-25 19:19:57');
INSERT INTO `shop_category` VALUES (7, '棋牌', '2019-07-31 09:14:31');
INSERT INTO `shop_category` VALUES (8, '密室', '2019-07-31 09:14:34');
INSERT INTO `shop_category` VALUES (9, '健身/运动', '2019-07-31 09:14:37');
INSERT INTO `shop_category` VALUES (10, '户外拓展', '2019-07-31 09:14:40');

-- ----------------------------
-- Table structure for shop_opening_hours
-- ----------------------------
DROP TABLE IF EXISTS `shop_opening_hours`;
CREATE TABLE `shop_opening_hours`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '门店营业时间表ID',
  `sid` int(11) NULL DEFAULT NULL COMMENT '门店ID',
  `start_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `opening_hours` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业时间（选择周一到周日）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shop_opening_hours
-- ----------------------------
INSERT INTO `shop_opening_hours` VALUES (1, 1, '2019-07-24 08:00:00', '2019-07-24 12:00:00', '');
INSERT INTO `shop_opening_hours` VALUES (2, 1, '2019-07-24 14:00:00', '2019-07-24 18:00:00', '周一到周五');
INSERT INTO `shop_opening_hours` VALUES (3, 1, '2019-07-26 20:00:00', '2019-07-26 23:00:00', '周一到周五');
INSERT INTO `shop_opening_hours` VALUES (4, 2, '2019-07-24 08:00:00', '2019-07-24 12:00:00', '周一到周六');
INSERT INTO `shop_opening_hours` VALUES (5, 2, '2019-07-24 14:00:00', '2019-07-24 18:00:00', '周一到周六');

-- ----------------------------
-- Table structure for shop_picture
-- ----------------------------
DROP TABLE IF EXISTS `shop_picture`;
CREATE TABLE `shop_picture`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商家相册表',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `picture_category` int(11) NULL DEFAULT NULL COMMENT '1门店，2大堂，3后厨，4其他',
  `sid` int(11) NULL DEFAULT NULL COMMENT '商家ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '时间',
  `check_status` int(11) NULL DEFAULT 0 COMMENT '图片审核状态（1：通过，0，未通过）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shop_picture
-- ----------------------------
INSERT INTO `shop_picture` VALUES (1, '/file/2019-07/2019-07-29/b177cffa8db0495aa48bb29705ad8229.jpg', 1, 1, '2019-07-23 17:17:27', 0);

-- ----------------------------
-- Table structure for special_qualification
-- ----------------------------
DROP TABLE IF EXISTS `special_qualification`;
CREATE TABLE `special_qualification`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '特殊资质认证表(补充资质)',
  `certificate_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件类型',
  `certificate_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件图片',
  `license_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '许可证编号',
  `unit_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位名称',
  `premises` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经营场所',
  `legal_person` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人',
  `license_period` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业期限',
  `sid` int(11) NULL DEFAULT NULL COMMENT '商家ID',
  `certification_status` int(11) NULL DEFAULT 0 COMMENT '认证状态(个人身份认证，1：通过，0，未通过)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of special_qualification
-- ----------------------------
INSERT INTO `special_qualification` VALUES (1, '100', '', '100200', '多伦多', '无锡市梁溪区', '张三', '长期有效', 1001, 0);
INSERT INTO `special_qualification` VALUES (2, '清真证', '/file/2019-07/2019-07-26/592d0b2db94143aa9744072421d45971.jpg', '100021', '奥斯卡', '无锡市滨湖区', '李四', '2020.01.01', 1002, 0);
INSERT INTO `special_qualification` VALUES (3, NULL, NULL, NULL, NULL, NULL, '关羽', NULL, 1003, 0);
INSERT INTO `special_qualification` VALUES (4, NULL, '/file/2019-07/2019-07-30/4c047e8e3c314fe0b417c5f706c9fd90.jpg', NULL, NULL, NULL, '张飞', NULL, 1004, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表ID',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `birth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生日',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别：1男性，2女性',
  `headlink` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像链接',
  `balance` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '余额',
  `home` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家乡',
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业',
  `credit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信誉度',
  `canjia_party` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参加过的派对次数',
  `zuzhi_party` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发起派对的次数',
  `real_name` int(11) NULL DEFAULT 0 COMMENT '0未实名，1已实名',
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '5位数字，唯一，5位相同数字排除',
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `aspiration_label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '心仪标签',
  `register_time` datetime NULL DEFAULT NULL COMMENT '注册时间',
  `weixin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信绑定',
  `qq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'qq绑定',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '15050687107', '123', '小黄鸭', '2019/10/12', 16, 1, NULL, '100', '南京', 'java', '60', '6', '3', 0, '123456', '[吃饭, 睡觉]', '[旅游, K歌]', NULL, NULL, NULL);
INSERT INTO `user` VALUES (2, '18912480392', '123456', '白天鹅', '1992/10/10', 18, 2, NULL, '1000', '宿迁', 'java', '80', '5', '2', 0, '456123', '[旅游, K歌]', '[抽烟, 喝酒]', NULL, NULL, NULL);
INSERT INTO `user` VALUES (3, '18896982020', '123456', '小魔仙', '1991/10/10', 19, 1, NULL, '1000', '无锡', 'c', '70', '4', '2', 0, '654987', '[吃饭, 睡觉]', '[抽烟, 喝酒]', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` int(11) NOT NULL,
  `endtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (110, '2019-08-01 20:57:37');

-- ----------------------------
-- Procedure structure for test
-- ----------------------------
DROP PROCEDURE IF EXISTS `test`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `test`()
BEGIN
update userinfo set endtime = now() where id = '110';
END
;;
delimiter ;

-- ----------------------------
-- Event structure for e_test
-- ----------------------------
DROP EVENT IF EXISTS `e_test`;
delimiter ;;
CREATE DEFINER = `root`@`%` EVENT `e_test`
ON SCHEDULE
EVERY '60' SECOND STARTS '2019-08-01 17:52:37'
ON COMPLETION PRESERVE
DO call test()
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
