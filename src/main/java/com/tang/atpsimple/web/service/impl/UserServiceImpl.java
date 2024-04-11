package com.tang.atpsimple.web.service.impl;

import com.tang.atpsimple.common.utils.BeanUtils;
import com.tang.atpsimple.dao.mapper.UserMapper;
import com.tang.atpsimple.dao.po.User;
import com.tang.atpsimple.web.request.UserRequest;
import com.tang.atpsimple.web.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(UserRequest userRequest) {
        User user = BeanUtils.copy(userRequest, User.class);
        user.setCreatedAt(new Date());
        return userMapper.insert(user);
    }
}
