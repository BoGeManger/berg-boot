package com.berg.system.controller;

import com.berg.base.BaseController;
import com.berg.dao.page.PageInfo;
import com.berg.message.Result;
import com.berg.system.service.system.FileService;
import com.berg.vo.common.DataVo;
import com.berg.vo.system.FilePathVo;
import com.berg.vo.system.FileVo;
import com.berg.vo.system.in.GetFilePageInVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/file")
@Api(tags = "文件管理")
public class FileController extends BaseController {

    @Autowired
    FileService fileService;

    @ApiOperation("获取文件列表")
    @GetMapping(value = "getFilePage")
    public Result<PageInfo<FileVo>> getFilePage(@Validated GetFilePageInVo input){
        return getSuccessResult("请求成功",fileService.getFilePage(input));
    }


    @ApiOperation("上传文件")
    @PostMapping(value = "uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<FilePathVo> uploadFile(@ApiParam(value = "文件",required = true) @RequestPart(value = "file") MultipartFile file,
                                         @ApiParam(value = "名称",required = true) @RequestParam(value = "name")String name,
                                         @ApiParam(value = "编码",required = false) @RequestParam(value = "code",required = false)String code,
                                         @ApiParam(value = "类型(0 模板文件 1 其他)",required = false) @RequestParam(value = "type",required = false,defaultValue = "1")Integer type){
        return getSuccessResult("请求成功",fileService.uploadFile(file,name,code,type));
    }

    @ApiOperation(value = "删除文件",notes = "data为文件名称")
    @DeleteMapping(value = "delFile")
    public Result delFile(@NotBlank @RequestBody DataVo<String> data){
        fileService.delFileByName(data.getData());
        return getSuccessResult("请求成功", null);
    }

    @ApiOperation(value = "记录下载记录",notes = "data为文件名称")
    @PostMapping(value = "recordDownload")
    public Result<Boolean> recordDownload(@NotBlank @RequestBody DataVo<String> data){
        fileService.recordDownload(data.getData());
        return getSuccessResult("请求成功",true );
    }
}
