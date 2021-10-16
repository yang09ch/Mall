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
      //计算分页总页数
    Integer getCount();
        //分页查询根据名字查询，根据userGender查询
       List<User> SelectUser(@Param("userNickName") String userNickName,
                             @Param("userGender") Integer userGender,
                             @Param("pageIndex") Integer pageIndex,
                             @Param("pageSize") Integer pageSize);
           //根据userid查找
         User getByidUser(Integer userId);
           //新增用户表
           Integer add(User user);
            //注销用户表
           Integer delete(Integer userId);
}
