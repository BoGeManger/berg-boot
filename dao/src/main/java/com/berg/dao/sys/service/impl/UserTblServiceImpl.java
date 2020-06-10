package com.berg.dao.sys.service.impl;

import com.berg.dao.sys.entity.UserTbl;
import com.berg.dao.sys.mapper.UserTblMapper;
import com.berg.dao.sys.service.UserTblService;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户信息表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-06-05
 */
@Service
public class UserTblServiceImpl extends ServiceImpl<UserTblMapper, UserTbl> implements UserTblService {

    @Override
    public UserTblMapper getMapper(){
      return this.getBaseMapper();
    }
}
