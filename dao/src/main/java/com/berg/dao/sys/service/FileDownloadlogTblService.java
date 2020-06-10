package com.berg.dao.sys.service;

import com.berg.dao.sys.entity.FileDownloadlogTbl;
import com.berg.dao.base.IService;
import com.berg.dao.sys.mapper.FileDownloadlogTblMapper;

/**
 * <p>
 * 系统文件下载记录表 服务类
 * </p>
 *
 * @author 
 * @since 2020-06-09
 */
public interface FileDownloadlogTblService extends IService<FileDownloadlogTbl> {
   FileDownloadlogTblMapper getMapper();
}
