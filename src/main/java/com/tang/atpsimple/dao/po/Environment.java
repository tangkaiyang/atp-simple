package com.tang.atpsimple.dao.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@ApiModel(value="Environment")
@Data
@Table(name = "environment")
public class Environment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="",name="id")
    private Integer id;

    @Column(name = "created_at")
    @ApiModelProperty(value="",name="createdAt")
    private Date createdAt;

    @Column(name = "updated_at")
    @ApiModelProperty(value="",name="updatedAt")
    private Date updatedAt;

    @Column(name = "deleted_at")
    @ApiModelProperty(value="",name="deletedAt")
    private Date deletedAt;

    @Column(name = "create_user")
    @ApiModelProperty(value="",name="createUser")
    private Integer createUser;

    @Column(name = "update_user")
    @ApiModelProperty(value="",name="updateUser")
    private Integer updateUser;

    @ApiModelProperty(value="",name="name")
    private String name;

    @ApiModelProperty(value="",name="remarks")
    private String remarks;
}