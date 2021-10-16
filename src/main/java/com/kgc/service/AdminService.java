package com.kgc.service;

import com.kgc.pojo.Admin;

public interface AdminService {
    Admin getAdminLogin(String name,String pwd);
}
