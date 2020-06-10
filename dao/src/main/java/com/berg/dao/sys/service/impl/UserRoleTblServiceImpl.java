package com.berg.dao.sys.service.impl;

import com.berg.dao.sys.entity.UserRoleTbl;
import com.berg.dao.sys.mapper.UserRoleTblMapper;
import com.berg.dao.sys.service.UserRoleTblService;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户角色表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-06-05
 */
@Service
public class UserRoleTblServiceImpl extends ServiceImpl<UserRoleTblMapper, UserRoleTbl> implements UserRoleTblService {

    @Override
    public UserRoleTblMapper getMapper(){
      return this.getBaseMapper();
    }
}
