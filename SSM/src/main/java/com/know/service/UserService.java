package com.know.service;

import com.know.pojo.User;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserService {
    //注册
    int signUp(User user);
    //登录
    User logIn(String telephone);
    //检查电话号是否已被注册
    int checkTelephone(String telephone);
}
