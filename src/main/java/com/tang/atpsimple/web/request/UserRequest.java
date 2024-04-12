package com.tang.atpsimple.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;


@ApiModel(value = "User")
@Data
public class UserRequest {

    @ApiModelProperty(value = "", name = "username")
    @NotBlank(message = "用户名称不能为空")
    @Size(max = 16, message = "用户名称过长")
    private String username;

    @ApiModelProperty(value = "", name = "name")
    private String name;

    @ApiModelProperty(value = "", name = "password")
    private String password;

    @ApiModelProperty(value = "", name = "email")
    private String email;

    /**
     * 0: 普通用户 1: 组长 2: 超级管理员
     */
    @ApiModelProperty(value = "0: 普通用户 1: 组长 2: 超级管理员", name = "role")
    @NotNull(message = "角色不能为空")
    @Max(value = 2, message = "角色有误")
    @Min(value = 0, message = "角色有误")
    private Integer role;

}
