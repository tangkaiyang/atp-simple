package com.tang.atpsimple.web.controller;

import com.tang.atpsimple.common.exception.ServiceException;
import com.tang.atpsimple.common.response.ReturnResponse;
import com.tang.atpsimple.web.request.DebugRequest;
import com.tang.atpsimple.web.request.UserRequest;
import com.tang.atpsimple.web.service.DebugService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



/**
 *
 */
@Api(value = "DebugController", tags = "调试")
@RestController
@RequestMapping(value = "/web/debug/")
@Validated
public class DebugController {

    @Autowired
    DebugService debugService;


    @ApiOperation(value = "调试", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "http.do")
    @ResponseBody
    public ReturnResponse http(@Validated @RequestBody DebugRequest debugRequest) {
        try {
            String res = debugService.http(debugRequest);
            return ReturnResponse.success(res);
        } catch (ServiceException e) {
            return new ReturnResponse<>(e.getCode(), e.getMessage());
        }

    }
}
