package com.tang.atpsimple.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;


@ApiModel(value = "Debug")
@Data
public class DebugRequest {
    @ApiModelProperty(value = "", name = "method")
    @NotBlank(message = "请求方式不能为空")
    private String method;

    @ApiModelProperty(value = "", name = "url")
    @NotBlank(message = "url不能为空")
    private String url;

    @ApiModelProperty(value = "", name = "headers")
    private String headers;

    @ApiModelProperty(value = "", name = "body")
    private String body;
}
