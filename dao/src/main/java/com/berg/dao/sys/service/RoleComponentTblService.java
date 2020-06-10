package com.berg.dao.sys.service;

import com.berg.dao.sys.entity.RoleComponentTbl;
import com.berg.dao.base.IService;
import com.berg.dao.sys.mapper.RoleComponentTblMapper;

/**
 * <p>
 * 系统角色组件表 服务类
 * </p>
 *
 * @author 
 * @since 2020-06-05
 */
public interface RoleComponentTblService extends IService<RoleComponentTbl> {
   RoleComponentTblMapper getMapper();
}
