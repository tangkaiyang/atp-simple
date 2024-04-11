package com.tang.atpsimple.web.controller;

import com.tang.atpsimple.common.response.ReturnResponse;
import com.tang.atpsimple.web.request.UserRequest;
import com.tang.atpsimple.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 *
 */
@Api(value = "UserController", tags = "用户")
@RestController
@RequestMapping(value = "/web/user/")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户-添加", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "add.do")
    @ResponseBody
    public ReturnResponse add(@Validated @RequestBody UserRequest userRequest) {
        int res = userService.save(userRequest);
        return ReturnResponse.success(res);
    }
}
