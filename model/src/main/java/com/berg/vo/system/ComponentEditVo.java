package com.berg.vo.system;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ComponentEditVo {

    @Min(value = 0,message = "组件id不能小于0")
    @ApiModelProperty(value = "组件id")
    Integer id;
    @Min(value = 0,message = "父组件id不能小于0")
    @ApiModelProperty(value = "父组件id")
    Integer parentId;
    @Size(max = 100, message = "组件名称长度不能超过100个字符")
    @NotBlank(message = "组件名称不能为空")
    @ApiModelProperty(value = "组件名称")
    String name;
    @Size(max = 100, message = "权限标识长度不能超过100个字符")
    @ApiModelProperty(value = "权限标识")
    String perms;
    @Size(max = 100, message = "对应路由地址长度不能超过255个字符")
    @ApiModelProperty(value = "对应路由地址")
    String path;
    @Size(max = 50, message = "图标长度不能超过50个字符")
    @ApiModelProperty(value = "图标")
    String icon;
    @Size(max = 500, message = "组件描述不能超过500个字符")
    @ApiModelProperty(value = "组件描述")
    String remark;
    @Min(value = 0,message = "组件类型不能小于0")
    @ApiModelProperty(value = "组件类型(0=菜单,1=按钮)")
    Integer type;
    @Min(value = 0,message = "排序不能小于0")
    @ApiModelProperty(value = "排序")
    Integer no;
}
