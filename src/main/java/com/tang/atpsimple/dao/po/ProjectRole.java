package com.tang.atpsimple.dao.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@ApiModel(value="ProjectRole")
@Data
@Table(name = "project_role")
public class ProjectRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="",name="id")
    private Integer id;

    @Column(name = "user_id")
    @ApiModelProperty(value="",name="userId")
    private Integer userId;

    @Column(name = "project_id")
    @ApiModelProperty(value="",name="projectId")
    private Integer projectId;

    @Column(name = "project_role")
    @ApiModelProperty(value="",name="projectRole")
    private Integer projectRole;

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
}