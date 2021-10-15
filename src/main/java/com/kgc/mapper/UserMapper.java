package com.kgc.mapper;

import com.kgc.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    /**
     * 用于user 登录
     * @param userName
     * @param userPassword
     * @return
     */
    User getUserLogin(@Param("userName") String userName,@Param("userPassword") String userPassword);
}
