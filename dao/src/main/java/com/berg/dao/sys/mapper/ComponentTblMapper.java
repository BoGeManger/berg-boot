package com.berg.dao.sys.mapper;

import com.berg.dao.sys.entity.ComponentTbl;
import com.berg.dao.base.BaseMapper;

import java.util.List;

/**
 * <p>
 * 系统组件表 Mapper 接口
 * </p>
 *
 * @author 
 * @since 2020-06-05
 */
public interface ComponentTblMapper extends BaseMapper<ComponentTbl> {
    List<String> listUserPerms(String userName);
}
