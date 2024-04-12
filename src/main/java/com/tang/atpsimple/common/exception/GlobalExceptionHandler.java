package com.tang.atpsimple.common.exception;

import com.tang.atpsimple.common.constant.BaseConstant;
import com.tang.atpsimple.common.enums.ResponseMsgEnum;
import com.tang.atpsimple.common.response.ReturnResponse;
import org.apache.commons.lang3.StringUtils;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = {BindException.class})
    public ReturnResponse handleBindException(BindException exception) {
        String message = "";
        List<ObjectError> allErrors = exception.getAllErrors();
        if (!CollectionUtils.isEmpty(allErrors)) {
            message = allErrors.get(0).getDefaultMessage();
        }
        return ReturnResponse.fail(ResponseMsgEnum.CODE_400.getCode(), message);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ReturnResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        String message = "";
        //对象中的参数校验失败处理
        BindingResult bindingResult = exception.getBindingResult();
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            StringBuffer errorMessageBuffer = new StringBuffer();
            allErrors.forEach(e -> {
                FieldError fieldError = (FieldError) e;
                errorMessageBuffer.append(fieldError.getDefaultMessage()).append(BaseConstant.COMMA);
            });
            if (errorMessageBuffer.length() != 0) {
                errorMessageBuffer.deleteCharAt(errorMessageBuffer.length() - 1);
            }
            message = errorMessageBuffer.toString();
        }
        return ReturnResponse.fail(ResponseMsgEnum.CODE_400.getCode(), message);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ReturnResponse handleConstraintViolationException(
            ConstraintViolationException exception) {
        //方法中放单个参数校验异常
        String message = exception.getMessage();
        if (message.contains(BaseConstant.COLON)) {
            message = message.substring(message.lastIndexOf(":") + 1, message.length()).trim();
        }
        return ReturnResponse.fail(ResponseMsgEnum.CODE_400.getCode(), message);
    }

    @ExceptionHandler(value = {MaxUploadSizeExceededException.class})
    public ReturnResponse handleMaxUploadSizeExceededException(
            MaxUploadSizeExceededException exception) {
        //文件上传下载异常
        return new ReturnResponse(ResponseMsgEnum.CODE_511);
    }

    @ExceptionHandler(value = {Exception.class})
    public ReturnResponse handleException(Exception exception) {
        return new ReturnResponse(ResponseMsgEnum.CODE_999999);
    }

    /****
     * 自定义异常类处理
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {ServiceException.class})
    public ReturnResponse handleServiceException(ServiceException exception) {
        if (exception.getCode() == null) {
            return ReturnResponse.fail(ResponseMsgEnum.CODE_999999.getCode(), StringUtils.isBlank(exception.getMessage()) ? ResponseMsgEnum.CODE_900.getMessage() : exception.getMessage());
        } else if (exception.getCode() == ResponseMsgEnum.CODE_400.getCode()
                && StringUtils.isEmpty(exception.getMessage())) {
            return ReturnResponse.fail(ResponseMsgEnum.CODE_400.getCode(), StringUtils.isBlank(exception.getMessage()) ? ResponseMsgEnum.CODE_400.getMessage() : exception.getMessage());
        } else if (exception.getCode() == ResponseMsgEnum.CODE_900.getCode()
                && StringUtils.isEmpty(exception.getMessage())) {
            return ReturnResponse.fail(ResponseMsgEnum.CODE_900.getCode(), StringUtils.isBlank(exception.getMessage()) ? ResponseMsgEnum.CODE_900.getMessage() : exception.getMessage());
        }
        return ReturnResponse.fail(exception.getCode(), exception.getMessage());
    }


}
