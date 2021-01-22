-- 初始化超级管理员
INSERT INTO `bootdb`.`sys_user_tbl`( `username`, `password`, `realname`, `organization_id`, `organization_name`, `last_login_time`, `lock_time`, `lock_user`, `islock`, `create_time`, `create_user`, `modify_time`, `modify_user`, `del_time`, `del_user`, `isdel`) VALUES ( 'admin', 'e10adc3949ba59abbe56e057f20f883e', '系统管理员', 0, NULL, '2020-06-10 11:17:15', NULL, NULL, 0, '2020-06-10 11:16:57', 'system', '2020-06-10 11:17:03', 'system', NULL, NULL, 00000);

INSERT INTO `bootdb`.`sys_component_tbl`(`parent_id`, `name`, `perms`, `remark`, `type`, `no`, `create_time`, `create_user`, `modify_time`, `modify_user`, `del_time`, `del_user`, `isdel`) VALUES (0, '系统管理', 'system', '', 0, 0, '2020-12-29 07:29:56', 'admin', '2020-12-29 07:29:56', 'admin', NULL, NULL, 00000);
INSERT INTO `bootdb`.`sys_component_tbl`(`parent_id`, `name`, `perms`, `remark`, `type`, `no`, `create_time`, `create_user`, `modify_time`, `modify_user`, `del_time`, `del_user`, `isdel`) VALUES (1, '组件管理', 'system.com', '', 0, 0, '2020-12-29 08:33:16', 'admin', '2020-12-29 08:33:16', 'admin', NULL, NULL, 00000);

INSERT INTO `bootdb`.`sys_router_tbl`(`component_id`, `component`, `path`, `icon`, `redirect`, `hidden`, `hide_childrenIn_menu`, `keep_alive`, `hidden_header_content`, `target`) VALUES (1, 'RouteView', '/sys', 'setting', '/sys/com/list', 0, 0, 0, 0, NULL);
INSERT INTO `bootdb`.`sys_router_tbl`(`component_id`, `component`, `path`, `icon`, `redirect`, `hidden`, `hide_childrenIn_menu`, `keep_alive`, `hidden_header_content`, `target`) VALUES (2, 'ComponentList', '/sys/com/list', '', '', 0, 0, 0, 0, NULL);


