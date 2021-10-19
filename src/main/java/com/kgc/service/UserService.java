package com.kgc.service;

import com.kgc.pojo.User;

public interface UserService {
    User getUserLogin(String userName,String pwd);
    /**
     * 注册用户
     * @param user
     * @return
     */
    int addUser(User user);
}
