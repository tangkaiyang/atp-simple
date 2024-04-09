package com.tang.atpsimple.dao.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@ApiModel(value="GlobalConfig")
@Data
@Table(name = "global_config")
public class GlobalConfig {
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

    @Column(name = "env_id")
    @ApiModelProperty(value="",name="envId")
    private Integer envId;

    @ApiModelProperty(value="",name="key")
    private String key;

    /**
     * 0:string 1: json 2:yaml
     */
    @Column(name = "key_type")
    @ApiModelProperty(value="0:string 1: json 2:yaml",name="keyType")
    private Integer keyType;

    @ApiModelProperty(value="",name="enable")
    private Boolean enable;

    @ApiModelProperty(value="",name="value")
    private String value;
}