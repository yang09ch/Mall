package com.kgc.mapper;

import com.kgc.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//管理员
@Mapper
public interface AdminMapper {
    /**
     * 用于管理员 登录
     * @param adminName
     * @param adminPassword
     * @return
     */
    Admin getAdminLogin(@Param("adminName") String adminName,@Param("adminPassword") String adminPassword);
    /**
     * 新增管理员
     */
    int addAdmin(Admin admin);
}
