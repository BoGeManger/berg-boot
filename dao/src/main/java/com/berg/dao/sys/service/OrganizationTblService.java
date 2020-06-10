package com.berg.dao.sys.service;

import com.berg.dao.sys.entity.OrganizationTbl;
import com.berg.dao.base.IService;
import com.berg.dao.sys.mapper.OrganizationTblMapper;

/**
 * <p>
 * 系统组织表 服务类
 * </p>
 *
 * @author 
 * @since 2020-06-05
 */
public interface OrganizationTblService extends IService<OrganizationTbl> {
   OrganizationTblMapper getMapper();
}
