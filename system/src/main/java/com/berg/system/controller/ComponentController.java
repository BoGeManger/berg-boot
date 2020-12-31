package com.berg.system.controller;

import com.berg.common.controller.AbstractController;
import com.berg.common.constant.Result;
import com.berg.dao.page.PageInfo;
import com.berg.system.service.system.ComponentService;
import com.berg.vo.common.EntityIdVo;
import com.berg.vo.common.ListVo;
import com.berg.vo.system.ComponentEditVo;
import com.berg.vo.system.ComponentTreeVo;
import com.berg.vo.system.ComponentVo;
import com.berg.vo.system.in.GetComPageInVo;
import com.berg.vo.system.in.OperatorBatchComInVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/com")
@Api(tags = "组件管理")
public class ComponentController extends AbstractController {

    @Autowired
    ComponentService componentService;

    @ApiOperation("获取组件树形列表")
    @GetMapping(value = "getComTree")
    public Result<ListVo<ComponentTreeVo>> getComTree(){
        return getSuccessResult("请求成功",componentService.getComTree());
    }

    @ApiOperation("获取组件分页列表")
    @GetMapping(value = "getComPage")
    public Result<PageInfo<ComponentVo>> getComPage(@Validated GetComPageInVo input){
        return getSuccessResult("请求成功",componentService.getComPage(input));
    }

    @ApiOperation("获取组件")
    @GetMapping(value = "getCom")
    public Result<ComponentEditVo> getCom(@ApiParam(value = "表id",required = true) @RequestParam Integer id){
        return getSuccessResult("请求成功",componentService.getCom(id));
    }

    @ApiOperation("新增组件")
    @PostMapping(value = "addCom")
    public Result<Integer> addCom(@RequestBody @Validated ComponentEditVo input){
        return getSuccessResult("请求成功",componentService.addCom(input));
    }

    @ApiOperation("修改组件")
    @PutMapping(value = "updateCom")
    public Result<Integer> updateCom(@RequestBody @Validated ComponentEditVo input){
        return getSuccessResult("请求成功",componentService.updateCom(input));
    }

    @ApiOperation("删除组件")
    @PutMapping(value = "delCom")
    public Result<Boolean> delCom(@RequestBody @Validated EntityIdVo<Integer> input){
        componentService.delCom(input.getId());
        return getSuccessResult("请求成功",true);
    }

//    @ApiOperation("批量操作组件(新增,修改,删除)")
//    @PostMapping(value = "operatorBatchCom")
//    public Result<Boolean> operatorBatchCom(@RequestBody @Validated OperatorBatchComInVo input){
//        componentService.operatorBatchCom(input);
//        return getSuccessResult("请求成功",true);
//    }

}
