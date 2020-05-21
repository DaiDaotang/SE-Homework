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
        User user = userService.checkTelephone(telephone);
        if(user!=null){
            return user.getUserId();
        }else {
            return -1;
        }
    }

    // 修改密码
    @RequestMapping("/modifyPassword")
    public String modifyPassword(User user){
        if(userService.modifyPassword(user)==0){
            return "Failed to modify password!";
        }else {
            return "OK";
        }
    }

    // 查询userId返回用户全部信息
    @RequestMapping("/checkByUserId")
    public User checkTelephone(int userId){
        return userService.checkByUserId(userId);
    }

    // 修改个人信息
    @RequestMapping("/modifyPersonalInfo")
    public String modifyPersonalInfo(User user){
        if(userService.modifyPersonalInfo(user)==0){
            return "Failed to modify!";
        }else {
            return "OK";
        }
    }
}
