package com.berg.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "接口返回类")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    @ApiModelProperty(value = "错误码(00：请求成功,99：系统异常，10：参数异常，11：未授权，66：业务友好提示)")
    private String errorCode;

    /**
     * 错误消息
     */
    @ApiModelProperty(value = "错误消息")
    private String errorMessage;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据")
    private T returnObject;

    public Result(String errorCode, String errorMsg, T data) {
        this.errorCode = errorCode;
        this.errorMessage = errorMsg;
        this.returnObject = data;
    }

}
