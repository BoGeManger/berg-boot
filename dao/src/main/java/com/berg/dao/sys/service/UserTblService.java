package com.berg.dao.sys.service;

import com.berg.dao.sys.entity.UserTbl;
import com.berg.dao.base.IService;
import com.berg.dao.sys.mapper.UserTblMapper;

/**
 * <p>
 * 系统用户信息表 服务类
 * </p>
 *
 * @author 
 * @since 2020-06-05
 */
public interface UserTblService extends IService<UserTbl> {
   UserTblMapper getMapper();
}
