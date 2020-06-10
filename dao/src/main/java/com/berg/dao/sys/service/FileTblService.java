package com.berg.dao.sys.service;

import com.berg.dao.sys.entity.FileTbl;
import com.berg.dao.base.IService;
import com.berg.dao.sys.mapper.FileTblMapper;

/**
 * <p>
 * 系统文件表 服务类
 * </p>
 *
 * @author 
 * @since 2020-06-10
 */
public interface FileTblService extends IService<FileTbl> {
   FileTblMapper getMapper();
}
