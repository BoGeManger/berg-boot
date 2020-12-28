package com.berg.system.service.system;

import com.berg.dao.page.PageInfo;
import com.berg.vo.common.ListVo;
import com.berg.vo.system.ComponentEditVo;
import com.berg.vo.system.ComponentTreeVo;
import com.berg.vo.system.ComponentVo;
import com.berg.vo.system.in.GetComPageInVo;
import com.berg.vo.system.in.OperatorBatchComInVo;

import java.util.List;

public interface ComponentService {

    ListVo<ComponentTreeVo> getComTree();

    PageInfo<ComponentVo> getComPage(GetComPageInVo input);

    ComponentEditVo getCom(Integer id);

    Integer addCom(ComponentEditVo input);

    Integer updateCom(ComponentEditVo input);

    void operatorBatchCom(OperatorBatchComInVo input);

}
