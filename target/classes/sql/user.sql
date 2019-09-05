CREATE DATABASE `mydb1`;

-- noinspection SqlDialectInspection
use mydb1;
CREATE TABLE `t_user` (
  `id`       BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(64)  NOT NULL,
  `password` VARCHAR(128) NOT NULL,
  `email`    VARCHAR(128) NULL,
  PRIMARY KEY (`id`)
)
  DEFAULT CHARACTER SET = utf8;


INSERT INTO `t_user` (`id`, `user_name`, `password`, `email`) VALUES ('1', '披荆斩棘', '123456', 'yujunhao_8831@yahoo.com');


