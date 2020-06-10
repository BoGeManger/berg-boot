package com.berg.dao.sys.service.impl;

import com.berg.dao.sys.entity.ComponentTbl;
import com.berg.dao.sys.mapper.ComponentTblMapper;
import com.berg.dao.sys.service.ComponentTblService;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统组件表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-06-05
 */
@Service
public class ComponentTblServiceImpl extends ServiceImpl<ComponentTblMapper, ComponentTbl> implements ComponentTblService {

    @Override
    public ComponentTblMapper getMapper(){
      return this.getBaseMapper();
    }
}
