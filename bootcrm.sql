/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.6.17 : Database - boot_crm1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `base_dict` */

DROP TABLE IF EXISTS `base_dict`;

CREATE TABLE `base_dict` (
  `dict_id` varchar(32) NOT NULL,
  `dict_type_code` varchar(10) DEFAULT NULL,
  `dict_type_name` varchar(50) DEFAULT NULL,
  `dict_item_name` varchar(50) DEFAULT NULL,
  `dict_item_code` varchar(10) DEFAULT NULL,
  `dict_sort` int(10) DEFAULT NULL,
  `dict_enable` char(1) DEFAULT NULL,
  `dict_memo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `base_dict` */

insert  into `base_dict`(`dict_id`,`dict_type_code`,`dict_type_name`,`dict_item_name`,`dict_item_code`,`dict_sort`,`dict_enable`,`dict_memo`) values ('001','002','客户来源','电话营销',NULL,1,'1',NULL),('002','002','客户来源','网络营销',NULL,2,'1',NULL),('003','002','客户来源','老客户',NULL,3,'1',NULL),('004','001','客户所属行业','教育培训',NULL,1,'1',NULL),('005','001','客户所属行业','对外贸易',NULL,2,'1',NULL),('006','001','客户所属行业','电子商务',NULL,3,'1',NULL),('007','001','客户所属行业','酒店旅游',NULL,4,'1',NULL),('008','002','客户所属行业','房地产',NULL,5,'1',NULL),('009','006','客户级别','普通客户',NULL,1,'1',NULL),('010','0003','客户级别','VIP客户',NULL,2,'1',NULL),('011','006','客户级别','VIP',NULL,3,'1',NULL);

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `cust_id` int(32) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(50) DEFAULT NULL,
  `cust_user_id` int(32) DEFAULT NULL,
  `cust_create_id` int(32) DEFAULT NULL,
  `cust_source` varchar(50) DEFAULT NULL,
  `cust_industry` varchar(50) DEFAULT NULL,
  `cust_level` varchar(32) DEFAULT NULL,
  `cust_linkman` varchar(50) DEFAULT NULL,
  `cust_phone` varchar(64) DEFAULT NULL,
  `cust_mobile` varchar(16) DEFAULT NULL,
  `cust_zipcode` varchar(10) DEFAULT NULL,
  `cust_address` varchar(100) DEFAULT NULL,
  `cust_createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`cust_id`,`cust_name`,`cust_user_id`,`cust_create_id`,`cust_source`,`cust_industry`,`cust_level`,`cust_linkman`,`cust_phone`,`cust_mobile`,`cust_zipcode`,`cust_address`,`cust_createtime`) values (1,'wwww',NULL,3,'001','004','011','fdfgg','037167788529','18623715678','450001','ggfjjjggj道德观','2018-04-20 08:24:16'),(2,'刘与会',NULL,3,'003','005','009','金晶科技','037123456','16534562345','450000','??????','2018-04-20 08:25:53'),(3,'zhangsan',NULL,3,'003','005','009','??','037123456','16534562345','450000','??????','2018-04-20 08:48:49'),(4,'tyy',NULL,3,'001','005','009','567','1234567','123456789','450000','123','2018-04-20 08:50:18'),(5,'rtty',NULL,3,'001','005','009','454565','3456567788','6778789990','789899','uiuiiiooiooopp','2018-04-20 10:03:06'),(6,'刘敏',NULL,3,'002','005','011','4556566','567789900','233455677','4456777','高新区','2018-04-20 10:18:02'),(7,'刘雪',NULL,3,'001','005','011','张三','1863254245','1356789090','450000','高新区莲花街','2018-04-20 11:26:00'),(8,'gghj个',NULL,3,'002','005','011','ghjhj','1123434545','4556566777','6677677','hghhhjh','2018-04-27 18:03:18'),(9,'李华健康',NULL,3,'008','006','009','黄金黄金进口','434556566','6777888998','78889989','用于uyuuiiu','2018-04-29 20:56:38'),(10,'；；啦啦啦啦啦更加健康',NULL,3,'008','007','009','急急急','778788','899000','899890909','健健康康接口看','2018-04-29 20:57:40'),(11,'UIUI考虑离开',NULL,3,'003','006','011','就看看看了','77900-0--==','67767787','788788','就看看看扩扩绿绿扩','2018-04-29 20:58:34');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` int(32) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(32) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_password` varchar(32) DEFAULT NULL,
  `user_state` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`user_code`,`user_name`,`user_password`,`user_state`) values (3,'m0001','小韩','123','1'),(4,'m0002','小雪','123','1'),(5,'m0003','小石','123','1'),(6,'m0004','小陈','123','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
