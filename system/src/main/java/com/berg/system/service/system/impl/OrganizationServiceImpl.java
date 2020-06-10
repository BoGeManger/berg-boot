package com.berg.system.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.berg.dao.sys.entity.OrganizationTbl;
import com.berg.dao.sys.service.OrganizationTblService;
import com.berg.system.service.system.OrganizationService;
import com.berg.system.authentication.JWTUtil;
import com.berg.vo.common.ListVo;
import com.berg.vo.system.OperatorBatchOrganizationVo;
import com.berg.vo.system.OrganizationEditVo;
import com.berg.vo.system.OrganizationTreeVo;
import com.berg.vo.system.in.OperatorBatchOrganizationInVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    JWTUtil jWTUtil;
    @Autowired
    OrganizationTblService organizationTblService;

    /**
     * 获取组织树形列表
     */
    @Override
    public ListVo<OrganizationTreeVo> getOrganizationTree(){
        ListVo<OrganizationTreeVo> result = new ListVo<>();
        List<OrganizationTreeVo> list = new ArrayList<>();
        //查找根组织
        LambdaQueryWrapper queryWrapper = new LambdaQueryWrapper<OrganizationTbl>()
                .eq(OrganizationTbl::getIsdel,0)
                .eq(OrganizationTbl::getParentId,0);
        List<OrganizationTreeVo> organizationTblList = organizationTblService.list(queryWrapper);
        organizationTblList.forEach(item->{
            //添加子集
            item.setChilds(getOrganizationTreeChild(item.getId()));
            list.add(item);
        });
        result.setList(list);
        return result;
    }

    /**
     * 获取组织树形子集列表
     * @param id
     * @return
     */
    List<OrganizationTreeVo> getOrganizationTreeChild(Integer id){
        List<OrganizationTreeVo> result = new ArrayList<>();
        LambdaQueryWrapper queryWrapper = new LambdaQueryWrapper<OrganizationTbl>()
                .eq(OrganizationTbl::getIsdel,0)
                .eq(OrganizationTbl::getParentId,id);
        List<OrganizationTreeVo> organizationTblList = organizationTblService.list(queryWrapper);
        organizationTblList.forEach(item->{
            //递归获取子集
            item.setChilds(getOrganizationTreeChild(item.getId()));
            result.add(item);
        });
        return result;
    }

    /**
     * 获取组织
     * @param id
     * @return
     */
    @Override
    public OrganizationEditVo getOrganization(Integer id){
        OrganizationEditVo result = new OrganizationEditVo();
        OrganizationTbl organizationTbl = organizationTblService.getById(id);
        if(organizationTbl!=null){
            BeanUtils.copyProperties(organizationTbl, result);
        }
        return result;
    }


    /**
     * 批量操作组织(新增,修改,删除)
     * @param input
     */
    @Override
    public void operatorBatchOrganization(OperatorBatchOrganizationInVo input){
        String operator = jWTUtil.getUsername();
        //新增或修改组件
        input.getOrganizations().forEach(item -> {
            Integer id = addOrUpdateOrganization(item, operator);
            //设置子组件
            item.getChilds().forEach(child -> {
                setChildsOrganizations(operator, child, id);
            });
        });
        //删除组件
        input.getDelIds().forEach(id -> {
            delOrganization(id);
        });
    }

    /**
     * 设置子组织
     * @param operator
     * @param com
     * @param parentid
     */
    void setChildsOrganizations(String operator, OperatorBatchOrganizationVo com, Integer parentid) {
        com.setParentId(parentid);
        Integer id = addOrUpdateOrganization(com, operator);
        com.getChilds().forEach(child -> {
            setChildsOrganizations(operator, child, id);
        });
    }

    /**
     * 新增或修改组织
     * @param input
     * @param operator
     */
    Integer addOrUpdateOrganization(OrganizationEditVo input,String operator){
        LocalDateTime now = LocalDateTime.now();
        Boolean isAdd = input.getId()==0?true:false;
        OrganizationTbl organizationTbl = new OrganizationTbl();
        organizationTbl.setParentId(input.getParentId());
        organizationTbl.setName(input.getName());
        organizationTbl.setRemark(input.getRemark());
        organizationTbl.setModifyUser(operator);
        organizationTbl.setModifyTime(now);
        if(isAdd){
            organizationTbl.setCreateUser(operator);
            organizationTbl.setCreateTime(now);
            organizationTbl.setIsdel(0);
        }
        organizationTblService.saveOrUpdate(organizationTbl);
        return organizationTbl.getId();
    }

    /**
     * 删除组织
     * @param id
     */
    public void delOrganization(Integer id){
        LocalDateTime now = LocalDateTime.now();
        String operator = jWTUtil.getUsername();
        OrganizationTbl organizationTbl = new OrganizationTbl();
        organizationTbl.setDelTime(now);
        organizationTbl.setDelUser(operator);
        organizationTbl.setIsdel(0);
        organizationTblService.updateById(organizationTbl);
    }
}
