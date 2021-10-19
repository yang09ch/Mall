package com.kgc.mapper;

import com.kgc.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 用于user 登录
     * @param userName
     * @param userPassword
     * @return
     */
    User getUserLogin(@Param("userName") String userName,@Param("userPassword") String userPassword);

    /**
     * 注册用户
     * @param user
     * @return
     */
    int addUser(User user);
    /**
     * 分页条件查询 用户信息
     */
    int getUserCount(@Param("userName") String userName);
    List<User> getUserLimit(@Param("userName") String userName,@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);
}
