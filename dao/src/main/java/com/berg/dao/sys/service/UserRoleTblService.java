package com.berg.dao.sys.service;

import com.berg.dao.sys.entity.UserRoleTbl;
import com.berg.dao.base.IService;
import com.berg.dao.sys.mapper.UserRoleTblMapper;

/**
 * <p>
 * 系统用户角色表 服务类
 * </p>
 *
 * @author 
 * @since 2020-06-05
 */
public interface UserRoleTblService extends IService<UserRoleTbl> {
   UserRoleTblMapper getMapper();
}
