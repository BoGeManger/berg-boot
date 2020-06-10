package com.berg.vo.system;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class OrganizationEditVo {

    @Min(value = 0,message = "组织id不能小于0")
    @ApiModelProperty(value = "组织id")
    Integer id;
    @Min(value = 0,message = "父组织id不能小于0")
    @ApiModelProperty(value = "父组织id")
    Integer parentId;
    @NotBlank(message = "组织名称不能为空")
    @Size(max = 100, message = "组织名称长度不能超过100个字符")
    @ApiModelProperty(value = "组织名称")
    String name;
    @Size(max = 500, message = "组织描述长度不能超过500个字符")
    @ApiModelProperty(value = "组织描述")
    String remark;
}
