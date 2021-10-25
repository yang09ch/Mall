package com.kgc.service.impl;

import com.kgc.mapper.UserMapper;
import com.kgc.pojo.User;
import com.kgc.service.UserService;
import com.kgc.util.PageUtil;
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

    @Override
    public PageUtil<User> getUserPage(String userName, Integer pageIndex, Integer pageSize) {
        PageUtil<User> pageUtil=new PageUtil<>();
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setPageSize(pageSize);
        pageUtil.setTotalCount(userMapper.getUserCount(userName));
        pageUtil.setList(userMapper.getUserLimit(userName, (pageIndex-1)*pageSize, pageSize));
        return pageUtil;
    }
}
