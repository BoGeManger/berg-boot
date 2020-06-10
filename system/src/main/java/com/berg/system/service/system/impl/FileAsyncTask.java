package com.berg.system.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.berg.dao.sys.entity.FileDownloadlogTbl;
import com.berg.dao.sys.entity.FileTbl;
import com.berg.dao.sys.service.FileDownloadlogTblService;
import com.berg.dao.sys.service.FileTblService;
import com.berg.vo.system.FilePathVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FileAsyncTask {

    @Autowired
    FileTblService fileTblService;
    @Autowired
    FileDownloadlogTblService fileDownloadlogTblService;

    /**
     * 上传文件
     * @param path
     * @param fullPath
     * @param name
     * @param code
     * @param type
     */
    @Async
    public void  uploadFile(String  path,String fullPath, String name, String code,Integer type, String user){
        LocalDateTime now = LocalDateTime.now();
        FileTbl fileTbl = new FileTbl();
        fileTbl.setName(name);
        fileTbl.setCode(code);
        fileTbl.setPath(path);
        fileTbl.setFullPath(fullPath);
        fileTbl.setType(type);
        fileTbl.setCreateTime(now);
        fileTbl.setCreateUser(user);
        fileTbl.setIsdel(0);
        fileTblService.save(fileTbl);
    }

    /**
     * 上传文件
     * @param name
     * @param code
     * @param type
     */
    @Async
    public void  uploadFile(FilePathVo filevo, String name, String code, Integer type, String user){
        LocalDateTime now = LocalDateTime.now();
        Boolean isAdd = true;
        LambdaQueryWrapper query = new LambdaQueryWrapper<FileTbl>().eq(FileTbl::getName,name);
        FileTbl fileTbl = fileTblService.getOne(query);
        if(fileTbl!=null){
            isAdd = false;
        }else{
            fileTbl = new FileTbl();
            fileTbl.setName(name);
            fileTbl.setCreateTime(now);
            fileTbl.setCreateUser(user);
        }
        fileTbl.setModifyTime(now);
        fileTbl.setModifyUser(user);
        fileTbl.setCode(code);
        fileTbl.setPath(filevo.getPath());
        fileTbl.setFullPath(filevo.getFullPath());
        fileTbl.setType(type);
        fileTbl.setIsdel(0);
        if(isAdd){
            fileTblService.save(fileTbl);
        }else {
            fileTblService.updateById(fileTbl);
        }
    }


    /**
     * 用户下载
     * @param path
     * @param user
     */
    @Async
    public void recordDownload(String path,String user){
        LocalDateTime now = LocalDateTime.now();
        FileDownloadlogTbl fileDownloadlogTbl = new FileDownloadlogTbl();
        fileDownloadlogTbl.setPath(path);
        fileDownloadlogTbl.setDownloadUser(user);
        fileDownloadlogTbl.setDownloadTimestamp(now);
        fileDownloadlogTblService.save(fileDownloadlogTbl);
    }
}
