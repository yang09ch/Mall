package com.kgc.service;

import com.kgc.pojo.User;

public interface UserService {
    User getUserLogin(String userName,String pwd);
}
