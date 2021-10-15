package com.kgc.pojo;

import lombok.Data;
//用户
import java.io.Serializable;
@Data
public class User implements Serializable {
    private Integer userId;//主键
            private String  userName;//用户名
    private String  userNickName;///昵称
            private String  userPassword;//密码
    private String  userRealname;//真实姓名
            private int userGender;//性别
    private String  userBirthday;//生日
            private String  userAddress;//收货地址
    private String userHomePlace;//家庭住址
            private String  userProfilePictureSrc;//头像地址
}
