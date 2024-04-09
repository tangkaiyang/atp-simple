package com.tang.atpsimple.dao.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@ApiModel(value="User")
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="",name="id")
    private Integer id;

    @ApiModelProperty(value="",name="username")
    private String username;

    @ApiModelProperty(value="",name="name")
    private String name;

    @ApiModelProperty(value="",name="password")
    private String password;

    @ApiModelProperty(value="",name="email")
    private String email;

    /**
     * 0: 普通用户 1: 组长 2: 超级管理员
     */
    @ApiModelProperty(value="0: 普通用户 1: 组长 2: 超级管理员",name="role")
    private Integer role;

    @Column(name = "created_at")
    @ApiModelProperty(value="",name="createdAt")
    private Date createdAt;

    @Column(name = "updated_at")
    @ApiModelProperty(value="",name="updatedAt")
    private Date updatedAt;

    @Column(name = "deleted_at")
    @ApiModelProperty(value="",name="deletedAt")
    private Date deletedAt;

    @Column(name = "last_login_at")
    @ApiModelProperty(value="",name="lastLoginAt")
    private Date lastLoginAt;
}