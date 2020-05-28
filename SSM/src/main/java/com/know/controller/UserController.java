package com.know.controller;

import com.know.pojo.User;
import com.know.service.UserService;
import com.know.utils.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ServletContext servletContext;
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
    public User checkByUserId(int userId){
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

    // 修改头像
    @RequestMapping("/modifyHead")
    public String modifyHead(MultipartFile head, int userId){
        //System.out.println(userId);
        System.out.println(head);
        if(head.isEmpty()){
            return "The head is empty!";
        }
        String webRootPath = servletContext.getRealPath("");
        String headPath = webRootPath + "head";
        System.out.println(webRootPath);
        util u = new util();
        String newFileName = u.upload(head,headPath,userId);
        String oldFileName = userService.checkByUserId(userId).getHead();
        User user = new User();
        user.setHead(newFileName);
        user.setUserId(userId);
        if(userService.modifyHead(user)==0){
            return "Failed to modify!";
        }else {
            if(oldFileName==null){
                return "OK";
            }else{
                File f = new File(headPath + File.separator + oldFileName);
                if(f.exists()){
                    boolean b = f.delete();
                    if(!b){
                        return "Failed to delete old head!";
                    }
                    return "OK";
                }else{
                    return "The old head has disappeared!";
                }
            }
        }
    }

    // 获取头像
    @RequestMapping("/getHead")
    public Map<String,Object> getHead(int userId){
        Map<String,Object> map = new HashMap<String, Object>();
        String filename = userService.checkByUserId(userId).getHead();
        if(filename==null){
            map.put("msg","No head!");
            return map;
        }
        String webRootPath = servletContext.getRealPath("");
        String headPath = webRootPath + "head";
        String path = headPath + File.separator + filename;
        map.put("head",path);
        map.put("msg","OK");
        return map;
    }
}
