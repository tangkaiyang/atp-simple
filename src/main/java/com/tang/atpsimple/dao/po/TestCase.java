package com.tang.atpsimple.dao.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@ApiModel(value="TestCase")
@Data
@Table(name = "test_case")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="",name="id")
    private Integer id;

    @ApiModelProperty(value="",name="name")
    private String name;

    /**
     * 请求类型1:http 2:grpc 3:dubbo
     */
    @Column(name = "request_type")
    @ApiModelProperty(value="请求类型1:http 2:grpc 3:dubbo",name="requestType")
    private Integer requestType;

    /**
     * 请求方式,非http可为空
     */
    @Column(name = "request_method")
    @ApiModelProperty(value="请求方式,非http可为空",name="requestMethod")
    private String requestMethod;

    /**
     * 所属项目
     */
    @Column(name = "project_id")
    @ApiModelProperty(value="所属项目",name="projectId")
    private Integer projectId;

    /**
     * 用例标签
     */
    @ApiModelProperty(value="用例标签",name="tag")
    private String tag;

    /**
     * 用例状态:1:待完成2:暂时关闭3:正常运作
     */
    @ApiModelProperty(value="用例状态:1:待完成2:暂时关闭3:正常运作",name="status")
    private Integer status;

    /**
     * 用例优先级:p0-p3
     */
    @ApiModelProperty(value="用例优先级:p0-p3",name="priority")
    private String priority;

    /**
     * 用例目录
     */
    @ApiModelProperty(value="用例目录",name="catalogue")
    private String catalogue;

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

    /**
     * 请求url
     */
    @ApiModelProperty(value="请求url",name="url")
    private String url;

    /**
     * 请求头,可为空
     */
    @Column(name = "request_header")
    @ApiModelProperty(value="请求头,可为空",name="requestHeader")
    private String requestHeader;

    /**
     * 请求body
     */
    @ApiModelProperty(value="请求body",name="body")
    private String body;
}