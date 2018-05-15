DROP DATABASE IF EXISTS ec_project;
CREATE DATABASE ec_project;
USE ec_project;
CREATE TABLE users (
  id INT(11) NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(32) DEFAULT NULL UNIQUE,
  PASSWORD VARCHAR(32)DEFAULT NULL,
  mobile VARCHAR(32)DEFAULT NULL,
  email VARCHAR(32)DEFAULT NULL,
  STATUS ENUM('unknown','to be verified','normal', 'vip') DEFAULT 'to be verified',
  verification_code VARCHAR(32)DEFAULT NULL,
  PRIMARY KEY(id)
) ENGINE=INNODB AUTO_INCREMENT=1, DEFAULT CHARSET=utf8;

CREATE TABLE category (
  id INT(11) NOT NULL AUTO_INCREMENT,
  pcid INT(11) NOT NULL DEFAULT 0,
  NAME VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=INNODB  AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO category(id, NAME) VALUE(5, "外语学习"); 

CREATE TABLE product (
  id INT(11) NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(255) DEFAULT NULL,
  subTitle VARCHAR(255) DEFAULT NULL,
  originalPrice FLOAT DEFAULT NULL,
  promotePrice FLOAT DEFAULT NULL,
  stock INT(11) DEFAULT NULL,
  cid INT(11) DEFAULT NULL,
  createDate DATETIME DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_product_category FOREIGN KEY (cid) REFERENCES category (id)
) ENGINE=INNODB  DEFAULT CHARSET=utf8;

INSERT INTO product VALUE(1,"某江口译","英语考试口语",666,666,66,5,'2018-04-13 16:43:32');
INSERT INTO product VALUE(2,"商务英语","英语考试口语",666,666,66,5,'2018-04-13 16:43:32');
INSERT INTO product VALUE(3,"新概念英语","英语考试口语",666,666,66,5,'2018-05-12 16:43:32');
INSERT INTO product VALUE(4,"某江N2","英语考试口语",888,88,88,5, '2018-05-12 16:43:32');
INSERT INTO product VALUE(5,"商务日语","英语考试口语",888,88,88,5, '2018-04-13 16:43:32');

CREATE TABLE order_ (
  id INT(11) NOT NULL AUTO_INCREMENT,
  orderCode VARCHAR(255) DEFAULT NULL,
  mobile VARCHAR(255) DEFAULT NULL,
  email VARCHAR(255) DEFAULT NULL,
  createDate DATETIME DEFAULT NULL,
  uid INT(11) DEFAULT NULL,
  STATUS VARCHAR(255) DEFAULT NULL,
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



