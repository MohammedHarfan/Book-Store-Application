CREATE DATABASE IF NOT EXISTS book_store_db;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`
(
    `id`             bigint(20)          NOT NULL AUTO_INCREMENT,
    `title`          varchar(45)         DEFAULT NULL,
    `description`    varchar(25)         DEFAULT NULL,
    `author`         varchar(45)         DEFAULT NULL,
    `price`          DATE              DEFAULT NULL,
    `create_time`    varchar(45)         DEFAULT NULL,
     PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase`
(
    `id`            bigint(20)          NOT NULL AUTO_INCREMENT,
    `user_id`       bigint(20)          DEFAULT NULL,
    `book_id`       bigint(20)          DEFAULT NULL,
    `price`         DOUBLE              DEFAULT NULL,
    `create_time`   DATE                DEFAULT NULL,
     PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

----DROP TABLE IF EXISTS `customer_structured`;
----CREATE TABLE `customer_structured`
----(
----    `id`                    bigint(20)          NOT NULL AUTO_INCREMENT,
----    `name`                  varchar(45)         DEFAULT NULL,
----    `fk_contact_phone_id`        bigint(20),
----     PRIMARY KEY (`id`),
----     CONSTRAINT `fk_contact_phone` FOREIGN KEY (`fk_contact_phone_id`) REFERENCES `contact_phone` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
----) ENGINE = InnoDB
----  DEFAULT CHARSET = utf8mb4;
