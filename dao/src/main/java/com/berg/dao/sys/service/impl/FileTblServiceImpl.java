package com.berg.dao.sys.service.impl;

import com.berg.dao.sys.entity.FileTbl;
import com.berg.dao.sys.mapper.FileTblMapper;
import com.berg.dao.sys.service.FileTblService;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统文件表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-06-10
 */
@Service
public class FileTblServiceImpl extends ServiceImpl<FileTblMapper, FileTbl> implements FileTblService {

    @Override
    public FileTblMapper getMapper(){
      return this.getBaseMapper();
    }
}
