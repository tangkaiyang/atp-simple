package com.tang.atpsimple.dao.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@ApiModel(value="Project")
@Data
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="",name="id")
    private Integer id;

    @ApiModelProperty(value="",name="name")
    private String name;

    @ApiModelProperty(value="",name="owner")
    private Integer owner;

    @ApiModelProperty(value="",name="app")
    private String app;

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

    @Column(name = "is_private")
    @ApiModelProperty(value="",name="isPrivate")
    private Boolean isPrivate;

    @ApiModelProperty(value="",name="description")
    private String description;
}