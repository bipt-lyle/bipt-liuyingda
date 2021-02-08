CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `sex` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `hobby` varchar(100) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `others` varchar(500) DEFAULT NULL,
  `flag` varchar(255) NOT NULL DEFAULT '0' COMMENT '账号是否生效 1生效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
