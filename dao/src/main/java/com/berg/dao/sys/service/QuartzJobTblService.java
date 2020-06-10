package com.berg.dao.sys.service;

import com.berg.dao.sys.entity.QuartzJobTbl;
import com.berg.dao.base.IService;
import com.berg.dao.sys.mapper.QuartzJobTblMapper;

/**
 * <p>
 * 系统定时任务表 服务类
 * </p>
 *
 * @author 
 * @since 2020-06-09
 */
public interface QuartzJobTblService extends IService<QuartzJobTbl> {
   QuartzJobTblMapper getMapper();
}
