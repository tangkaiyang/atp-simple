package com.tang.atpsimple.common.response;

import com.tang.atpsimple.common.enums.ResponseMsgEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * 描述：统一返回
 *
 */
@ApiModel(value = "返回类")
@ToString
@Data
public class ReturnResponse<T> {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "返回码，数值范围 [200, 999999]")
    private Integer code;
    @ApiModelProperty(value = "提示信息，字符串长度范围：[0, 1024]")
    private String message;
    @ApiModelProperty(value = "数据对象")
    private T data;

    public ReturnResponse() {
        super();
    }

    public ReturnResponse(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ReturnResponse(int code, String message, T data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ReturnResponse(int code, T data) {
        super();
        this.code = code;
        this.data = data;
    }

    public ReturnResponse(T data) {
        super();
        this.code = ResponseMsgEnum.CODE_200.getCode();
        this.message = ResponseMsgEnum.CODE_200.getMessage();
        this.data = data;
    }

    public ReturnResponse(ResponseMsgEnum responseMsgEnum, T data) {
        super();
        if (responseMsgEnum != null) {
            this.code = responseMsgEnum.getCode();
            this.message = responseMsgEnum.getMessage();
        }
        this.data = data;
    }

    public ReturnResponse(ResponseMsgEnum responseMsgEnum) {
        super();
        if (responseMsgEnum != null) {
            this.code = responseMsgEnum.getCode();
            this.message = responseMsgEnum.getMessage();
        }
    }

    public static ReturnResponse success() {
        return new ReturnResponse(ResponseMsgEnum.CODE_200);
    }

    public static ReturnResponse success(Object data) {
        return new ReturnResponse(ResponseMsgEnum.CODE_200, data);
    }

    public static ReturnResponse fail(int code, String message) {
        return new ReturnResponse(code, message);
    }

    public static ReturnResponse fail(ResponseMsgEnum msgEnum) {
        return new ReturnResponse(msgEnum.getCode(), msgEnum.getMessage());
    }
}