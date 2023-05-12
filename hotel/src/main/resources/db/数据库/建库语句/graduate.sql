/*
Navicat MySQL Data Transfer

Source Server         : lomysql
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : graduate

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2020-06-15 07:53:53
*/

use graduate;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `announcement`
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `announcementId` int(11) NOT NULL AUTO_INCREMENT,
  `staffId` int(11) DEFAULT NULL,
  `announcementTitle` varchar(200) DEFAULT NULL,
  `announcementContent` varchar(200) DEFAULT NULL,
  `announcementType` int(11) DEFAULT NULL,
  `announcementState` int(11) DEFAULT NULL,
  `activityTime` varchar(200) DEFAULT NULL,
  `announcementTime` date DEFAULT NULL,
  PRIMARY KEY (`announcementId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('2', '1', '欢迎市领导莅临视察', '热烈欢迎市领导莅临视察，本店深感荣幸', '0', '0', null, '2020-06-09');
INSERT INTO `announcement` VALUES ('3', '1', '入住折扣', '凡在当日进行入住的客户可以享受折扣', '1', '1', '2020-06-12', '2020-06-10');

-- ----------------------------
-- Table structure for `checkin`
-- ----------------------------
DROP TABLE IF EXISTS `checkin`;
CREATE TABLE `checkin` (
  `checkinId` int(11) NOT NULL AUTO_INCREMENT,
  `roomId` int(11) DEFAULT NULL,
  `roomTypeId` int(11) DEFAULT NULL,
  `staffId` int(11) DEFAULT NULL,
  `usersId` int(11) DEFAULT NULL,
  `clientId` int(11) DEFAULT NULL,
  `checkinTime` datetime DEFAULT NULL,
  `DepartureTime` datetime DEFAULT NULL,
  `checkinDay` int(11) DEFAULT NULL,
  `checkinForegift` double DEFAULT NULL,
  PRIMARY KEY (`checkinId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkin
-- ----------------------------
INSERT INTO `checkin` VALUES ('10', '13', '8', '1', '0', '8', '2020-06-09 15:44:00', '2020-06-11 00:00:00', '2', '260');
INSERT INTO `checkin` VALUES ('11', '14', '8', '1', '0', '9', '2020-06-09 21:05:00', '2020-06-09 00:00:00', '1', '130');
INSERT INTO `checkin` VALUES ('12', '20', '8', '1', '0', '10', '2020-06-10 08:24:00', '2020-06-14 00:00:00', '4', '520');
INSERT INTO `checkin` VALUES ('13', '16', '8', '1', '6', '0', '2020-06-10 08:26:00', '2020-06-12 00:00:00', '2', '260');
INSERT INTO `checkin` VALUES ('14', '26', '8', '1', '0', '11', '2020-06-10 08:27:00', '2020-06-10 00:00:00', '1', '130');
INSERT INTO `checkin` VALUES ('15', '18', '8', '1', '0', '12', '2020-06-10 08:40:00', '2020-06-12 00:00:00', '2', '60');
INSERT INTO `checkin` VALUES ('16', '13', '8', '1', '0', '13', '2020-06-10 08:43:00', '2020-06-12 00:00:00', '2', '60');
INSERT INTO `checkin` VALUES ('17', '30', '9', '1', '0', '14', '2020-06-10 12:27:00', '2020-06-12 00:00:00', '2', '280');
INSERT INTO `checkin` VALUES ('18', '35', '10', '1', '0', '15', '2020-06-10 12:28:00', '2020-06-14 00:00:00', '4', '600');
INSERT INTO `checkin` VALUES ('19', '37', '11', '1', '0', '16', '2020-06-10 12:29:00', '2020-06-11 00:00:00', '1', '140');
INSERT INTO `checkin` VALUES ('20', '44', '12', '1', '0', '17', '2020-06-10 12:30:00', '2020-06-18 00:00:00', '8', '1200');
INSERT INTO `checkin` VALUES ('21', '46', '13', '1', '0', '18', '2020-06-10 12:31:00', '2020-06-13 00:00:00', '3', '510');
INSERT INTO `checkin` VALUES ('22', '31', '9', '1', '0', '19', '2020-06-10 13:54:00', '2020-06-14 00:00:00', '4', '360');
INSERT INTO `checkin` VALUES ('23', '15', '8', '1', '0', '20', '2020-06-10 14:17:00', '2020-06-13 00:00:00', '3', '390');

-- ----------------------------
-- Table structure for `checkout`
-- ----------------------------
DROP TABLE IF EXISTS `checkout`;
CREATE TABLE `checkout` (
  `checkOutId` int(11) NOT NULL AUTO_INCREMENT,
  `usersId` int(11) DEFAULT NULL,
  `clientId` int(11) DEFAULT NULL,
  `staffId` int(11) DEFAULT NULL,
  `roomId` int(11) DEFAULT NULL,
  `checkOutTime` datetime DEFAULT NULL,
  `amountReceived` double DEFAULT NULL,
  PRIMARY KEY (`checkOutId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkout
-- ----------------------------
INSERT INTO `checkout` VALUES ('1', '0', '9', '1', '14', '2020-06-09 21:06:00', '0');
INSERT INTO `checkout` VALUES ('2', '0', '11', '1', '26', '2020-06-10 08:28:00', '0');
INSERT INTO `checkout` VALUES ('3', '0', '8', '1', '13', '2020-06-10 08:35:00', '-260');
INSERT INTO `checkout` VALUES ('4', '0', '19', '1', '31', '2020-06-10 13:54:00', '-220');
INSERT INTO `checkout` VALUES ('5', '0', '20', '1', '15', '2020-06-10 14:18:00', '-260');

-- ----------------------------
-- Table structure for `client`
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `clientId` int(11) NOT NULL AUTO_INCREMENT,
  `clientName` varchar(150) DEFAULT NULL,
  `clientIdCard` varchar(200) DEFAULT NULL,
  `clientPhone` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`clientId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('8', '王五', '452424199502251234', '18808541234');
INSERT INTO `client` VALUES ('9', '赵磊', '452424199505251314', '13856781234');
INSERT INTO `client` VALUES ('10', '唐飞', '452424199801181234', '13754681234');
INSERT INTO `client` VALUES ('11', '唐清', '4524241995112051234', '18808451234');
INSERT INTO `client` VALUES ('12', '唐唐', '452424199605261234', '13788681234');
INSERT INTO `client` VALUES ('13', '张一', '452424199968681234', '13588685468');
INSERT INTO `client` VALUES ('14', '黄飞', '452424199656871234', '13955558888');
INSERT INTO `client` VALUES ('15', '黎', '452424198801181234', '15807745487');
INSERT INTO `client` VALUES ('16', '刘', '452424199659891234', '13707845687');
INSERT INTO `client` VALUES ('17', '周', '452424199654981234', '1375687459');
INSERT INTO `client` VALUES ('18', '雍', '452424196859871234', '13754691245');
INSERT INTO `client` VALUES ('19', '宋', '452424199807541234', '13708895468');
INSERT INTO `client` VALUES ('20', '唐钦机', '452424199710071314', '13707849274');

-- ----------------------------
-- Table structure for `clientconsumptionrecord`
-- ----------------------------
DROP TABLE IF EXISTS `clientconsumptionrecord`;
CREATE TABLE `clientconsumptionrecord` (
  `clientConsumptionRecordId` int(11) NOT NULL AUTO_INCREMENT,
  `clientId` int(11) DEFAULT NULL,
  `staffId` int(11) DEFAULT NULL,
  `clientConsumptionTime` datetime DEFAULT NULL,
  `clientConsumptionMoney` double DEFAULT NULL,
  `clientConsumptionManner` int(11) DEFAULT NULL,
  PRIMARY KEY (`clientConsumptionRecordId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clientconsumptionrecord
-- ----------------------------
INSERT INTO `clientconsumptionrecord` VALUES ('10', '8', '1', '2020-06-09 15:44:00', '130', '0');
INSERT INTO `clientconsumptionrecord` VALUES ('11', '9', '1', '2020-06-09 21:05:00', '130', '0');
INSERT INTO `clientconsumptionrecord` VALUES ('12', '10', '1', '2020-06-10 08:24:00', '520', '0');
INSERT INTO `clientconsumptionrecord` VALUES ('13', '11', '1', '2020-06-10 08:27:00', '130', '0');
INSERT INTO `clientconsumptionrecord` VALUES ('14', '12', '1', '2020-06-10 08:40:00', '60', '0');
INSERT INTO `clientconsumptionrecord` VALUES ('15', '13', '1', '2020-06-10 08:43:00', '60', '0');
INSERT INTO `clientconsumptionrecord` VALUES ('16', '14', '1', '2020-06-10 12:27:00', '280', '0');
INSERT INTO `clientconsumptionrecord` VALUES ('17', '15', '1', '2020-06-10 12:28:00', '600', '0');
INSERT INTO `clientconsumptionrecord` VALUES ('18', '16', '1', '2020-06-10 12:29:00', '140', '0');
INSERT INTO `clientconsumptionrecord` VALUES ('19', '17', '1', '2020-06-10 12:30:00', '1200', '0');
INSERT INTO `clientconsumptionrecord` VALUES ('20', '18', '1', '2020-06-10 12:31:00', '510', '0');
INSERT INTO `clientconsumptionrecord` VALUES ('21', '19', '1', '2020-06-10 13:54:00', '360', '0');
INSERT INTO `clientconsumptionrecord` VALUES ('22', '20', '1', '2020-06-10 14:17:00', '390', '0');

-- ----------------------------
-- Table structure for `income`
-- ----------------------------
DROP TABLE IF EXISTS `income`;
CREATE TABLE `income` (
  `incomeId` int(11) NOT NULL AUTO_INCREMENT,
  `roomTypeId` int(11) DEFAULT NULL,
  `staffId` int(11) DEFAULT NULL,
  `paymentMethod` int(11) DEFAULT NULL,
  `incomeType` int(11) DEFAULT NULL,
  `incomeTime` datetime DEFAULT NULL,
  `incomeMoney` double DEFAULT NULL,
  PRIMARY KEY (`incomeId`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of income
-- ----------------------------
INSERT INTO `income` VALUES ('10', '8', '1', '0', '0', '2020-06-09 15:44:00', '130');
INSERT INTO `income` VALUES ('11', '9', '1', '0', '1', '2020-06-09 15:46:06', '200');
INSERT INTO `income` VALUES ('12', '8', '1', '0', '0', '2020-06-09 21:05:00', '130');
INSERT INTO `income` VALUES ('13', '8', '1', '0', '0', '2020-06-10 08:24:00', '520');
INSERT INTO `income` VALUES ('14', '8', '1', '0', '1', '2020-06-10 08:25:42', '200');
INSERT INTO `income` VALUES ('15', '8', '1', '0', '0', '2020-06-10 08:26:00', '260');
INSERT INTO `income` VALUES ('16', '8', '1', '0', '0', '2020-06-10 08:27:00', '130');
INSERT INTO `income` VALUES ('17', '8', '1', '0', '0', '2020-06-10 08:40:00', '60');
INSERT INTO `income` VALUES ('18', '8', '1', '0', '1', '2020-06-10 08:42:59', '200');
INSERT INTO `income` VALUES ('19', '8', '1', '0', '0', '2020-06-10 08:43:00', '60');
INSERT INTO `income` VALUES ('20', '9', '1', '0', '0', '2020-06-10 12:27:00', '280');
INSERT INTO `income` VALUES ('21', '10', '1', '0', '0', '2020-06-10 12:28:00', '600');
INSERT INTO `income` VALUES ('22', '11', '1', '0', '0', '2020-06-10 12:29:00', '140');
INSERT INTO `income` VALUES ('23', '12', '1', '0', '0', '2020-06-10 12:30:00', '1200');
INSERT INTO `income` VALUES ('24', '13', '1', '0', '0', '2020-06-10 12:31:00', '510');
INSERT INTO `income` VALUES ('25', '9', '1', '0', '1', '2020-06-10 13:53:48', '200');
INSERT INTO `income` VALUES ('26', '9', '1', '0', '0', '2020-06-10 13:54:00', '360');
INSERT INTO `income` VALUES ('27', '8', '1', '0', '0', '2020-06-10 14:17:00', '390');

-- ----------------------------
-- Table structure for `maintain`
-- ----------------------------
DROP TABLE IF EXISTS `maintain`;
CREATE TABLE `maintain` (
  `maintainId` int(11) NOT NULL AUTO_INCREMENT,
  `roomId` int(11) DEFAULT NULL,
  `staffId` int(11) DEFAULT NULL,
  `maintainCause` varchar(200) DEFAULT NULL,
  `maintainStartTime` datetime DEFAULT NULL,
  `maintainFinishTime` datetime DEFAULT NULL,
  `maintainStatus` int(11) DEFAULT NULL,
  `maintainResult` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`maintainId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of maintain
-- ----------------------------
INSERT INTO `maintain` VALUES ('1', '17', '1', '空调损坏', '2020-06-09 15:55:35', null, '2', null);
INSERT INTO `maintain` VALUES ('2', '15', '1', '窗户破损', '2020-06-09 21:29:15', '2020-06-09 21:29:29', '0', '更换窗户');
INSERT INTO `maintain` VALUES ('3', '26', '1', '热水器故障', '2020-06-09 21:29:49', '2020-06-09 21:29:58', '0', '更换热水器');
INSERT INTO `maintain` VALUES ('4', '23', '1', '床垫塌陷', '2020-06-09 21:30:19', '2020-06-09 21:30:31', '0', '更换床垫');
INSERT INTO `maintain` VALUES ('5', '36', '1', '空调损坏', '2020-06-09 21:30:54', null, '2', null);
INSERT INTO `maintain` VALUES ('6', '38', '1', '桌椅破损', '2020-06-09 21:31:10', '2020-06-09 21:31:21', '0', '更换桌椅');
INSERT INTO `maintain` VALUES ('7', '45', '1', '地板瓷砖破裂', '2020-06-09 21:31:51', null, '2', null);
INSERT INTO `maintain` VALUES ('8', '48', '1', '电视接收出现问题', '2020-06-09 21:32:13', '2020-06-09 21:32:19', '0', '完成维修');

-- ----------------------------
-- Table structure for `reservation`
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `reservationId` int(11) NOT NULL AUTO_INCREMENT,
  `roomId` int(11) DEFAULT NULL,
  `roomTypeId` int(11) DEFAULT NULL,
  `staffId` int(11) DEFAULT NULL,
  `reservationName` varchar(200) DEFAULT NULL,
  `reservationIdCard` varchar(200) DEFAULT NULL,
  `reservationPhoneNumber` varchar(200) DEFAULT NULL,
  `reservationTime` datetime DEFAULT NULL,
  `unsubscribeTime` datetime DEFAULT NULL,
  `ExpectedTimeOfArrival` datetime DEFAULT NULL,
  `reservationOccupancyDays` int(11) DEFAULT NULL,
  `reservationStatus` int(11) DEFAULT NULL,
  `reservationForegift` double DEFAULT NULL,
  `unsubscribeForegift` double DEFAULT NULL,
  PRIMARY KEY (`reservationId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reservation
-- ----------------------------
INSERT INTO `reservation` VALUES ('3', '29', '0', '1', '李四', '452424199802141314', '13712345678', '2020-06-09 15:46:06', null, '2020-06-09 18:00:00', '2', '0', '200', null);
INSERT INTO `reservation` VALUES ('4', '18', '0', '1', '唐唐', '452424199605261234', '13788681234', '2020-06-10 08:25:42', null, '2020-06-10 18:00:00', '2', '1', '200', null);
INSERT INTO `reservation` VALUES ('5', '13', '0', '1', '张一', '452424199968681234', '13588685468', '2020-06-10 08:42:59', null, '2020-06-10 18:00:00', '2', '1', '200', null);
INSERT INTO `reservation` VALUES ('6', '0', '13', '0', '李四', '452424199802141314', '13812345678', null, null, '2020-06-10 18:00:00', '3', '3', '0', null);
INSERT INTO `reservation` VALUES ('7', '31', '0', '1', '宋', '452424199807541234', '13708895468', '2020-06-10 13:53:48', null, '2020-06-10 18:00:00', '2', '1', '200', null);

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `roomId` int(11) NOT NULL AUTO_INCREMENT,
  `roomTypeId` int(11) DEFAULT NULL,
  `roomNumber` varchar(50) DEFAULT NULL,
  `roomSanitation` int(11) DEFAULT NULL,
  `roomStatus` int(11) DEFAULT NULL,
  `roomStorey` varchar(100) DEFAULT NULL,
  `roomWindow` varchar(200) DEFAULT NULL,
  `roomBed` varchar(200) DEFAULT NULL,
  `roomGuestNumber` int(11) DEFAULT NULL,
  `roomFacility` text,
  `checkinId` int(11) DEFAULT NULL,
  PRIMARY KEY (`roomId`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('13', '8', '201', '0', '2', '2', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('14', '8', '202', '1', '0', '2', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('15', '8', '203', '0', '0', '2', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('16', '8', '204', '0', '2', '2', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('17', '8', '205', '2', '0', '2', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('18', '8', '206', '0', '2', '2', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('19', '8', '207', '0', '0', '2', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('20', '8', '208', '0', '2', '2', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('21', '8', '209', '0', '0', '2', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('22', '8', '210', '0', '0', '2', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('23', '8', '211', '0', '0', '2', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('24', '8', '212', '0', '0', '2', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('25', '8', '213', '0', '0', '2', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('26', '8', '214', '1', '0', '2', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('27', '8', '215', '0', '0', '2', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('28', '8', '216', '0', '0', '2', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('29', '9', '301', '0', '1', '3', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('30', '9', '302', '0', '2', '3', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('31', '9', '303', '1', '0', '3', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('32', '9', '304', '0', '0', '3', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('33', '9', '305', '0', '0', '3', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('34', '10', '401', '0', '0', '4', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('35', '10', '402', '0', '2', '4', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('36', '10', '403', '2', '0', '4', '0', '1.8米单人床', '1', '空调热水器', null);
INSERT INTO `room` VALUES ('37', '11', '501', '0', '2', '5', '0', '1.8米双人床', '2', '空调热水器', null);
INSERT INTO `room` VALUES ('38', '11', '502', '0', '0', '5', '0', '1.8米双人床', '2', '空调热水器', null);
INSERT INTO `room` VALUES ('39', '11', '503', '0', '0', '5', '0', '1.8米双人床', '2', '空调热水器', null);
INSERT INTO `room` VALUES ('40', '11', '504', '0', '0', '5', '0', '1.8米双人床', '2', '空调热水器', null);
INSERT INTO `room` VALUES ('41', '11', '505', '0', '0', '5', '0', '1.8米双人床', '2', '空调热水器', null);
INSERT INTO `room` VALUES ('42', '12', '601', '0', '0', '6', '0', '1.8米双人床', '2', '空调热水器', null);
INSERT INTO `room` VALUES ('43', '12', '602', '0', '0', '6', '0', '1.8米双人床', '2', '空调热水器', null);
INSERT INTO `room` VALUES ('44', '12', '603', '0', '2', '6', '0', '1.8米双人床', '2', '空调热水器', null);
INSERT INTO `room` VALUES ('45', '12', '604', '2', '0', '6', '0', '1.8米双人床', '2', '空调热水器', null);
INSERT INTO `room` VALUES ('46', '13', '701', '0', '2', '7', '0', '1.8米双人床', '2', '空调热水器', null);
INSERT INTO `room` VALUES ('47', '13', '702', '0', '0', '7', '0', '1.8米双人床', '2', '空调热水器', null);
INSERT INTO `room` VALUES ('48', '13', '703', '0', '0', '7', '0', '1.8米双人床', '2', '空调热水器', null);
INSERT INTO `room` VALUES ('49', '13', '704', '0', '0', '7', '0', '1.8米双人床', '2', '空调热水器', null);
INSERT INTO `room` VALUES ('50', '13', '705', '0', '0', '7', '0', '1.8米双人床', '2', '空调热水器', null);
INSERT INTO `room` VALUES ('51', '13', '706', '0', '0', '7', '0', '1.8米双人床', '2', '空调热水器', null);

-- ----------------------------
-- Table structure for `roomrate`
-- ----------------------------
DROP TABLE IF EXISTS `roomrate`;
CREATE TABLE `roomrate` (
  `roomrateId` int(11) NOT NULL AUTO_INCREMENT,
  `roomTypeId` int(11) DEFAULT NULL,
  `listPrice` double DEFAULT NULL,
  `individualPrice` double DEFAULT NULL,
  `vipPrice` double DEFAULT NULL,
  PRIMARY KEY (`roomrateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roomrate
-- ----------------------------

-- ----------------------------
-- Table structure for `roomtype`
-- ----------------------------
DROP TABLE IF EXISTS `roomtype`;
CREATE TABLE `roomtype` (
  `roomTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `roomTypeName` varchar(200) DEFAULT NULL,
  `roomTypeImage` varchar(255) DEFAULT NULL,
  `roomTypeStatus` int(11) DEFAULT NULL,
  `roomTypeArea` double DEFAULT NULL,
  `roomTypeTimingMode` int(11) DEFAULT NULL,
  `listPrice` double DEFAULT NULL,
  `individualPrice` double DEFAULT NULL,
  `vipPrice` double DEFAULT NULL,
  PRIMARY KEY (`roomTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roomtype
-- ----------------------------
INSERT INTO `roomtype` VALUES ('8', '普通单人房', '60a441fc-1142-4c98-b996-d15224170013null', '0', '20', '0', '140', '130', '130');
INSERT INTO `roomtype` VALUES ('9', '标准单人房', '038aca28-9925-46a7-942f-c17ac4e5c032null', '0', '25', '0', '150', '140', '140');
INSERT INTO `roomtype` VALUES ('10', '豪华单人房', '5141ab85-648e-4fec-b770-a870af5a792bnull', '0', '30', '0', '160', '150', '150');
INSERT INTO `roomtype` VALUES ('11', '普通双人房', '19527372-ef22-4410-95d2-c2f9724e19efnull', '0', '25', '0', '150', '140', '140');
INSERT INTO `roomtype` VALUES ('12', '标准双人房', '243e9ba9-afe4-4eea-bf36-9264e8a84a85null', '0', '30', '0', '160', '150', '150');
INSERT INTO `roomtype` VALUES ('13', '豪华双人房', '141a8ce1-39ac-475e-9a7f-e3d4785190e3null', '0', '35', '0', '180', '170', '170');
INSERT INTO `roomtype` VALUES ('14', '家庭房', 'a169b952-441f-41f4-b1c2-707ae83bd849null', '0', '35', '0', '160', '150', '150');

-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `staffId` int(11) NOT NULL AUTO_INCREMENT,
  `staffAccount` varchar(200) DEFAULT NULL,
  `staffPassword` varchar(200) DEFAULT NULL,
  `staffName` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`staffId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', 'admin', 'admin', 'admin');

-- ----------------------------
-- Table structure for `userconsumptionrecord`
-- ----------------------------
DROP TABLE IF EXISTS `userconsumptionrecord`;
CREATE TABLE `userconsumptionrecord` (
  `userConsumptionRecordId` int(11) NOT NULL AUTO_INCREMENT,
  `usersId` int(11) DEFAULT NULL,
  `staffId` int(11) DEFAULT NULL,
  `userConsumptionTime` datetime DEFAULT NULL,
  `userConsumptionMoney` double DEFAULT NULL,
  `userConsumptionManner` int(11) DEFAULT NULL,
  PRIMARY KEY (`userConsumptionRecordId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userconsumptionrecord
-- ----------------------------
INSERT INTO `userconsumptionrecord` VALUES ('1', '6', '1', '2020-06-10 08:26:00', '260', '0');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `usersId` int(11) NOT NULL AUTO_INCREMENT,
  `userVipId` varchar(200) DEFAULT NULL,
  `userPass` varchar(200) DEFAULT NULL,
  `userRealName` varchar(200) DEFAULT NULL,
  `userIdCard` varchar(200) DEFAULT NULL,
  `userPhone` varchar(200) DEFAULT NULL,
  `userIntegral` int(11) DEFAULT NULL,
  PRIMARY KEY (`usersId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('6', 'vip147258', '123456', '李四', '452424199802141314', '13812345678', null);
INSERT INTO `users` VALUES ('7', 'vip123', '123456', '张三', '452424200012341234', '13712341234', null);
