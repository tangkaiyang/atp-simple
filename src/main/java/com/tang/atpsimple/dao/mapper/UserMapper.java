package com.tang.atpsimple.dao.mapper;

import com.tang.atpsimple.dao.po.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper {

    /**
     * @param user
     * @return
     */
    int insert(@Param("user") User user);

}