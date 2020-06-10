package com.berg.dao.sys.service.impl;

import com.berg.dao.sys.entity.RoleTbl;
import com.berg.dao.sys.mapper.RoleTblMapper;
import com.berg.dao.sys.service.RoleTblService;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统角色表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-06-05
 */
@Service
public class RoleTblServiceImpl extends ServiceImpl<RoleTblMapper, RoleTbl> implements RoleTblService {

    @Override
    public RoleTblMapper getMapper(){
      return this.getBaseMapper();
    }
}
