package com.kgc.service.impl;

import com.kgc.mapper.UserMapper;
import com.kgc.pojo.User;
import com.kgc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public User getUserLogin(String userName, String pwd) {
        return userMapper.getUserLogin(userName,pwd);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
