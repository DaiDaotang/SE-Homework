package com.know.controller;

import com.know.pojo.User;
import com.know.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    // Controller 调 Service
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    // 注册
    @RequestMapping("/signUp")
    public int signUp(User user){
        //System.out.println(user);
        return userService.signUp(user);
    }

    // 登录
    @RequestMapping("/logIn")
    public int logIn(User user){
        //System.out.println(user);
        User u = userService.logIn(user.getTelephone());
        if(u.getPassword().equals(user.getPassword())){
            return u.getUserId();
        }else{
            return -1;
        }
    }

    // 检查电话号码是否被注册过
    @RequestMapping("/checkTelephone")
    public int checkTelephone(String telephone){
        return userService.checkTelephone(telephone);
    }
}
