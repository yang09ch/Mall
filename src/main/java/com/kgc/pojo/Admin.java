package com.kgc.pojo;

import lombok.Data;

import java.io.Serializable;
//管理员
@Data
public class Admin implements Serializable {
    private Integer adminId;//主键
            private String  adminName;//账号
    private String  adminNickname;//昵称
            private String adminPassword;//密码
    private String  adminProfilePictureSrc;//头像
}
