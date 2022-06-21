CREATE DATABASE IF NOT EXISTS book_store_db;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`
(
    `id`             bigint(20)          NOT NULL AUTO_INCREMENT,
    `title`          varchar(45)         DEFAULT NULL,
    `description`    varchar(25)         DEFAULT NULL,
    `author`         varchar(45)         DEFAULT NULL,
    `price`          DOUBLE              DEFAULT NULL,
    `create_time`    DATE                DEFAULT NULL,
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
     PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`                 bigint(20)          NOT NULL AUTO_INCREMENT,
    `username`           varchar(45)         DEFAULT NULL,
    `password`           varchar(20)         DEFAULT NULL,
    `name`               varchar(20)         DEFAULT NULL,
    `create_time`        DATE                DEFAULT NULL,
    `role`               varchar(20)         DEFAULT NULL,
     PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
