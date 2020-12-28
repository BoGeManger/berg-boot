package com.berg.vo.system.in;

import com.berg.vo.common.PageInVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GetComPageInVo extends PageInVo {

    @ApiModelProperty(value = "组件名称")
    String name;
    @ApiModelProperty(value = "权限标识")
    String perms;
    @ApiModelProperty(value = "对应路由地址")
    String path;
    @ApiModelProperty(value = "组件描述")
    String remark;
    @ApiModelProperty(value = "组件类型(0=菜单,1=按钮)")
    Integer type;
}
