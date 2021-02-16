/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : fcgl

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-02-16 19:50:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auditorium
-- ----------------------------
DROP TABLE IF EXISTS `auditorium`;
CREATE TABLE `auditorium` (
  `auditorium_id` smallint(6) NOT NULL AUTO_INCREMENT COMMENT '报告厅编号主键',
  `auditorium_name` varchar(20) NOT NULL COMMENT '报告厅名称',
  `username` varchar(20) DEFAULT NULL COMMENT '外键：正在使用者',
  `floor_id` smallint(6) NOT NULL COMMENT '外键：所属楼层编号',
  `build_id` smallint(6) NOT NULL COMMENT '外键：所属楼栋编号',
  `campus_id` smallint(6) NOT NULL COMMENT '外键：所属校区编号',
  `auditorium_area` smallint(6) DEFAULT NULL COMMENT '报告厅面积',
  `auditorium_capacity` smallint(6) NOT NULL COMMENT '可容纳人数',
  `auditorium_state` char(2) NOT NULL DEFAULT '是' COMMENT '状态（是否空闲）',
  `auditorium_detail` mediumtext COMMENT '详情介绍',
  `auditorium_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '报告厅信息添加时间',
  PRIMARY KEY (`auditorium_id`),
  KEY `fk_username10` (`username`),
  KEY `fk_floor_id3` (`floor_id`),
  KEY `fk_build_id3` (`build_id`),
  KEY `fk_campus_id3` (`campus_id`),
  CONSTRAINT `fk_build_id3` FOREIGN KEY (`build_id`) REFERENCES `build` (`build_id`),
  CONSTRAINT `fk_campus_id3` FOREIGN KEY (`campus_id`) REFERENCES `campus` (`campus_id`),
  CONSTRAINT `fk_floor_id3` FOREIGN KEY (`floor_id`) REFERENCES `floor` (`floor_id`),
  CONSTRAINT `fk_username10` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  CONSTRAINT `auditorium_chk_1` CHECK (((`auditorium_state` = _utf8mb4'是') or (`auditorium_state` = _utf8mb4'否')))
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
