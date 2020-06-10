package com.berg.dao.sys.service.impl;

import com.berg.dao.sys.entity.RoleComponentTbl;
import com.berg.dao.sys.mapper.RoleComponentTblMapper;
import com.berg.dao.sys.service.RoleComponentTblService;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统角色组件表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-06-05
 */
@Service
public class RoleComponentTblServiceImpl extends ServiceImpl<RoleComponentTblMapper, RoleComponentTbl> implements RoleComponentTblService {

    @Override
    public RoleComponentTblMapper getMapper(){
      return this.getBaseMapper();
    }
}
