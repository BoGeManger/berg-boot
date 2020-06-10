package com.berg.dao.sys.service.impl;

import com.berg.dao.sys.entity.FileDownloadlogTbl;
import com.berg.dao.sys.mapper.FileDownloadlogTblMapper;
import com.berg.dao.sys.service.FileDownloadlogTblService;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统文件下载记录表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-06-09
 */
@Service
public class FileDownloadlogTblServiceImpl extends ServiceImpl<FileDownloadlogTblMapper, FileDownloadlogTbl> implements FileDownloadlogTblService {

    @Override
    public FileDownloadlogTblMapper getMapper(){
      return this.getBaseMapper();
    }
}
