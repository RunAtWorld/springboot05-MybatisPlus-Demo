CREATE DATABASE `mydb2`;

use mydb2;
CREATE TABLE `t_order` (
  `id`         BIGINT(20)   NOT NULL,
  `user_id`    BIGINT(20)   NULL,
  `order_id`   VARCHAR(64)  NULL,
  `order_name` VARCHAR(128) NULL,
  PRIMARY KEY (`id`)
)
  DEFAULT CHARACTER SET = utf8;

INSERT INTO `t_order` (`id`, `user_id`, `order_id`, `order_name`) VALUES ('1', '1', '1001', '外汇');
