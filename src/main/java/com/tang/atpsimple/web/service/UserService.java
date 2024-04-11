package com.tang.atpsimple.web.service;

import com.tang.atpsimple.web.request.UserRequest;

public interface UserService {

    /**
     * 保存
     * @param userRequest
     * @return
     */
    int save(UserRequest userRequest);
}
