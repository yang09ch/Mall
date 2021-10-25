package com.kgc.service;

import com.kgc.pojo.User;
import com.kgc.util.PageUtil;

public interface UserService {
    User getUserLogin(String userName,String pwd);
    /**
     * 注册用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 分页 条件查询用户
     * @param userName
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageUtil<User> getUserPage(String userName,Integer pageIndex,Integer pageSize);
}
