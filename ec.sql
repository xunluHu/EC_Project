DROP DATABASE IF EXISTS ec_project;
CREATE DATABASE ec_project CHARACTER SET utf8 COLLATE utf8_general_ci;
USE ec_project;
CREATE TABLE users (
  id INT(11) NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(32) DEFAULT NULL UNIQUE,
  PASSWORD VARCHAR(32)DEFAULT NULL,
  mobile VARCHAR(32)DEFAULT NULL,
  email VARCHAR(32)DEFAULT NULL,
  STATUS ENUM('admin','to be verified','normal', 'vip') DEFAULT 'to be verified',
  verification_code VARCHAR(32)DEFAULT NULL,
  PRIMARY KEY(id)
) ENGINE=INNODB AUTO_INCREMENT=1, DEFAULT CHARSET=utf8;

INSERT INTO users(NAME, PASSWORD, mobile, email, STATUS) VALUE("赵钱", "2288","1", "1@126", "admin");
INSERT INTO users(NAME, PASSWORD, mobile, email, STATUS) VALUE("孙俪", "2288","2", "2@126", "normal");
INSERT INTO users(NAME, PASSWORD, mobile, email, STATUS) VALUE("周武", "2288","3", "3@126", "normal");
INSERT INTO users(NAME, PASSWORD, mobile, email, STATUS) VALUE("郑旺", "2288","4", "4@126", "to be verified");
INSERT INTO users(NAME, PASSWORD, mobile, email, STATUS) VALUE("冯成", "2288","5", "5@126", "normal");
INSERT INTO users(NAME, PASSWORD, mobile, email, STATUS) VALUE("楚魏", "2288","6", "6@126", "normal");

CREATE TABLE category (
  id INT(11) NOT NULL AUTO_INCREMENT,
  pcid INT(11) NOT NULL DEFAULT 0,
  NAME VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=INNODB  AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT  INTO `category`(`id`,`pcid`,`NAME`) VALUES 
(5,0,'外语学习'),
(6,5,'商务英语'),
(7,5,'中级口译'),
(8,0,'IT前沿必读'),
(9,5,'英语基础'),
(10,8,'大数据'),
(11,8,'计算机语言'),
(12,8,'人工智能'),
(13,0,'琴棋书画'),
(14,13,'书法'),
(15,0,'工业生产'),
(16,0,'娱乐至死'),
(17,0,'爱的供养'),
(18,8,'web开发'),
(19,5,'日语'),
(20,16,'漫画'),
(21,16,'游戏'),
(22,15,'自动化'),
(23,15,'数控'),
(24,15,'材料'),
(25,15,'设计'),
(26,13,'诗词'),
(27,13,'美食'),
(28,15,'电工电子'),
(29,13,'棋'),
(30,13,'书'),
(31,13,'画'),
(32,17,'他山之石可以攻玉');

CREATE TABLE product (
  id INT(11) NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(255) DEFAULT NULL,
  subTitle VARCHAR(255) DEFAULT NULL,
  originalPrice FLOAT DEFAULT NULL,
  promotePrice FLOAT DEFAULT NULL,
  stock INT(11) DEFAULT NULL,
  STATUS ENUM('unknown','上架', '下架') DEFAULT '上架',
  cid INT(11) DEFAULT NULL,
  createDate DATETIME DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_product_category FOREIGN KEY (cid) REFERENCES category (id)
) ENGINE=INNODB  DEFAULT CHARSET=utf8;
INSERT  INTO `product`(`id`,`NAME`,`subTitle`,`originalPrice`,`promotePrice`,`stock`,`STATUS`,`cid`,`createDate`) VALUES 
(1,'实战口译','（林超伦）实战口译',666,666,66,'上架',7,'2018-05-31 18:40:22'),
(2,'商务英语','英语考试口语',666,666,66,'上架',6,'2018-05-31 16:15:49'),
(3,'新概念英语','英语考试口语',666,666,66,'上架',9,'2018-05-31 16:14:36'),
(6,'Hadoop数据分析平台','IT经典',888,88,88,'上架',10,'2018-05-31 18:42:33'),
(7,'毛笔','书法全集',944,838,12,'上架',14,'2018-05-31 17:17:53'),
(8,'JavaEE（黑马）','Java企业级应用',1,1,1,'上架',18,'2018-05-31 19:51:53'),
(9,'日语合集','日语合集',1,1,1,'上架',19,'2018-05-31 19:45:28'),
(10,'万词班','万词班',1,1,1,'上架',9,'2018-05-31 19:49:07');


CREATE TABLE order_ (
  id INT(11) NOT NULL AUTO_INCREMENT,
  orderCode VARCHAR(255) DEFAULT NULL,
  mobile VARCHAR(255) DEFAULT NULL,
  email VARCHAR(255) DEFAULT NULL,
  createDate DATETIME DEFAULT NULL,
  uid INT(11) DEFAULT NULL,
  STATUS ENUM('已下单','已付款','已发货', '已确认', '已评论', '已取消', '已退款') DEFAULT '已下单',
  PRIMARY KEY (id),
  CONSTRAINT fk_order_user FOREIGN KEY (uid) REFERENCES users (id)
) ENGINE=INNODB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS orderitem; 
CREATE TABLE orderitem (
  id INT(11) NOT NULL AUTO_INCREMENT,
  pid INT(11) DEFAULT NULL,
  uid INT(11) DEFAULT NULL,
  oid INT(11) DEFAULT NULL,
  number INT(11) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_orderitem_user FOREIGN KEY (uid) REFERENCES users (id),
  CONSTRAINT fk_orderitem_product FOREIGN KEY (pid) REFERENCES product (id),
  CONSTRAINT fk_orderitem_order FOREIGN KEY (oid) REFERENCES order_ (id)
) ENGINE=INNODB  DEFAULT CHARSET=utf8;

CREATE TABLE property (
  id INT(11) NOT NULL AUTO_INCREMENT,
  cid INT(11) DEFAULT NULL,
  NAME VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_property_category FOREIGN KEY (cid) REFERENCES category (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE propertyvalue (
  id INT(11) NOT NULL AUTO_INCREMENT,
  pid INT(11) DEFAULT NULL,
  ptid INT(11) DEFAULT NULL,
  VALUE VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_propertyvalue_property FOREIGN KEY (ptid) REFERENCES property (id),
  CONSTRAINT fk_propertyvalue_product FOREIGN KEY (pid) REFERENCES product (id)
) ENGINE=INNODB  DEFAULT CHARSET=utf8;


CREATE TABLE `productextension` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `pid` INT(11) DEFAULT NULL,
  `TYPE` VARCHAR(255) DEFAULT NULL,
  `pansource` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_extension` (`pid`),
  CONSTRAINT `fk_extension` FOREIGN KEY (`pid`) REFERENCES `product` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

INSERT  INTO `productextension`(`id`,`pid`,`TYPE`,`pansource`) VALUES 
(1,8,'jpg','链接：https://pan.baidu.com/s/1nw_chqXtyHrELSizGpbCkA 密码：t1gp'),
(2,1,'jpg','链接：https://pan.baidu.com/s/1zDaBHXICJqiOn4Qz-xW1pA 密码：mh8j'),
(3,2,'jpg','链接：https://pan.baidu.com/s/1Tde8IoYomu3_Vjxz3VPc1A 密码：8430'),
(4,3,'jpg','链接：https://pan.baidu.com/s/1u-5v8YeI8xVUt52Kr3q9Gg 密码：dzdg'),
(5,6,'jpg','链接：https://pan.baidu.com/s/16ljpHoC2HqiB3an0-OCrog 密码：mber'),
(6,7,'jpg','链接：https://pan.baidu.com/s/1sY5RezY9Gqj-AFLGQjizAw 密码：iupa'),
(7,9,'jpg','链接：https://pan.baidu.com/s/1bqJm0gAJB5nQvUPOpuKPaA 密码：cxe3'),
(8,10,'jpg','链接：https://pan.baidu.com/s/1mBTXyzbsQwKPEPOk9XNVlA 密码：5xff');

