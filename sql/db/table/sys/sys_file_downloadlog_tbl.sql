CREATE TABLE `sys_file_downloadlog_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统文件下载记录表id',
  `path` text NOT NULL COMMENT '文件路径',
  `download_user` varchar(64) NOT NULL COMMENT '创建人',
  `download_timestamp` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统文件下载记录表';