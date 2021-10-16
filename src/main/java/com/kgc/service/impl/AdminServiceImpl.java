package com.kgc.service.impl;

import com.kgc.mapper.AdminMapper;
import com.kgc.pojo.Admin;
import com.kgc.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminMapper adminMapper;
    @Override
    public Admin getAdminLogin(String name, String pwd) {
        return adminMapper.getAdminLogin(name,pwd);
    }
}
