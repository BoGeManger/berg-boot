package com.berg.vo.system;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RouterVo {

    @ApiModelProperty(value = "前端绑定组件")
    String component;
    @ApiModelProperty(value = "对应路由地址")
    String path;
    @ApiModelProperty(value = "图标")
    String icon;
    @ApiModelProperty(value = "重定向地址, 访问这个路由时,自定进行重定向")
    String redirect;
    @ApiModelProperty(value = "控制路由和子路由是否显示在 sidebar(0 否 1 是)")
    Integer hidden = 0;
    @ApiModelProperty(value = "强制菜单显示为Item而不是SubItem(配合 meta.hidden)(0 否 1 是)")
    Integer hideChildreninMenu = 0;
    @ApiModelProperty(value = "缓存该路由 (开启 multi-tab 是默认值为 true)(0 否 1 是)")
    Integer keepAlive = 0;
    @ApiModelProperty(value = "特殊 隐藏 PageHeader 组件中的页面带的 面包屑和页面标题栏(0 否 1 是)")
    Integer hiddenHeaderContent = 0;
    @ApiModelProperty(value = "菜单链接跳转目标（参考 html a 标记）")
    String target;
}
