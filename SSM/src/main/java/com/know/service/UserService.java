package com.know.service;

import com.know.pojo.User;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserService {
    //注册
    int signUp(User user);
    //登录
    User logIn(String telephone);
    //通过电话号码查询用户
    User checkTelephone(String telephone);
    //修改密码
    int modifyPassword(User user);
    //通过用户Id查询用户
    User checkByUserId(int userId);
    //修改个人信息
    int modifyPersonalInfo(User user);
}
