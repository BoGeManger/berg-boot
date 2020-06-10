package com.berg.dao.sys.service.impl;

import com.berg.dao.sys.entity.OrganizationTbl;
import com.berg.dao.sys.mapper.OrganizationTblMapper;
import com.berg.dao.sys.service.OrganizationTblService;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统组织表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-06-05
 */
@Service
public class OrganizationTblServiceImpl extends ServiceImpl<OrganizationTblMapper, OrganizationTbl> implements OrganizationTblService {

    @Override
    public OrganizationTblMapper getMapper(){
      return this.getBaseMapper();
    }
}
