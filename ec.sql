DROP DATABASE IF EXISTS ec_project;
CREATE DATABASE ec_project;
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

INSERT INTO category(id, NAME) VALUE(5, "外语学习"); 
INSERT INTO category(pcid, NAME) VALUE(5, "商务英语"); 
INSERT INTO category(pcid, NAME) VALUE(5, "中级口译"); 
INSERT INTO category(NAME) VALUE("IT经典"); 

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

INSERT INTO product(NAME, subTitle, originalPrice, promotePrice, stock, cid, createDate) VALUE("某江口译","英语考试口语",666,666,66,5,'2018-04-13 16:43:32');
INSERT INTO product(NAME, subTitle, originalPrice, promotePrice, stock, cid, createDate) VALUE("商务英语","英语考试口语",666,666,66,5,'2018-04-13 16:43:32');
INSERT INTO product(NAME, subTitle, originalPrice, promotePrice, stock, cid, createDate) VALUE("新概念英语","英语考试口语",666,666,66,5,'2018-05-12 16:43:32');
INSERT INTO product(NAME, subTitle, originalPrice, promotePrice, stock, cid, createDate) VALUE("某江N2","英语考试口语",888,88,88,5, '2018-05-12 16:43:32');
INSERT INTO product(NAME, subTitle, originalPrice, promotePrice, stock, cid, createDate) VALUE("商务日语","英语考试口语",888,88,88,5, '2018-04-13 16:43:32');

INSERT INTO product(NAME, subTitle, originalPrice, promotePrice, stock, cid, createDate) VALUE("大数据","IT经典",888,88,88,8, '2018-04-13 16:43:32');

INSERT INTO product(NAME, subTitle, originalPrice, promotePrice, stock, cid, createDate) VALUE("某江口译","英语考试口语",666,666,66,5,'2018-04-13 16:43:32');
INSERT INTO product(NAME, subTitle, originalPrice, promotePrice, stock, cid, createDate) VALUE("商务英语","英语考试口语",666,666,66,5,'2018-04-13 16:43:32');
INSERT INTO product(NAME, subTitle, originalPrice, promotePrice, stock, cid, createDate) VALUE("新概念英语","英语考试口语",666,666,66,5,'2018-05-12 16:43:32');
INSERT INTO product(NAME, subTitle, originalPrice, promotePrice, stock, cid, createDate) VALUE("某江N2","英语考试口语",888,88,88,5, '2018-05-12 16:43:32');
INSERT INTO product(NAME, subTitle, originalPrice, promotePrice, stock, cid, createDate) VALUE("商务日语","英语考试口语",888,88,88,5, '2018-04-13 16:43:32');

INSERT INTO product(NAME, subTitle, originalPrice, promotePrice, stock, cid, createDate) VALUE("大数据","IT经典",888,88,88,8, '2018-04-13 16:43:32');

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

CREATE TABLE productimage (
  id INT(11) NOT NULL AUTO_INCREMENT,
  pid INT(11) DEFAULT NULL,
  TYPE VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_productimage_product FOREIGN KEY (pid) REFERENCES product (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;



