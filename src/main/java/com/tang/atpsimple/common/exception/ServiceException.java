package com.tang.atpsimple.common.exception;

import com.tang.atpsimple.common.enums.ResponseMsgEnum;

/**
 * 自定义错误
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 296478906900416366L;

    private Integer code;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
        this.code = null;
    }


    public ServiceException(int code) {
        this.code = code;
    }


    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(ResponseMsgEnum responseMsgEnum) {
        super(responseMsgEnum.getMessage());
        this.code = responseMsgEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
