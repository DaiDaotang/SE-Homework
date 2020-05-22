package com.know.service;

import com.know.dao.UserMapper;
import com.know.pojo.User;
import com.know.utils.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class UserServiceImpl implements UserService{

    private UserMapper userMapper;


    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int signUp(User user) {
        user.setAnswerCollected(0);
        user.setAnswerLiked(0);
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String dateTime = df.format(date);
        user.setSignUpTime(dateTime);
        try{
            userMapper.signUp(user);
            User u = userMapper.checkByTelephone(user.getTelephone());
            return u.getUserId();
        }catch (Exception e){
            return -1;
        }
    }

    public User logIn(String telephone) {
        return userMapper.checkByTelephone(telephone);
    }

    public User checkTelephone(String telephone){
        return userMapper.checkByTelephone(telephone);
    }

    public int modifyPassword(User user){
        return userMapper.modifyPassword(user);
    }

    public User checkByUserId(int userId){
        return userMapper.checkByUserId(userId);
    }

    public int modifyPersonalInfo(User user){
        return userMapper.modifyPersonalInfo(user);
    }

    public int modifyHead(User user){
        return userMapper.modifyHead(user);
    }
}
