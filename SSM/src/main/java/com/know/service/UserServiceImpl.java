package com.know.service;

import com.know.dao.UserMapper;
import com.know.pojo.User;

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
        userMapper.signUp(user);
        User u = userMapper.checkByTelephone(user.getTelephone());
        return u.getUserId();
    }

    public User logIn(String telephone) {
        return userMapper.checkByTelephone(telephone);
    }

    public int checkTelephone(String telephone){
        User user = userMapper.checkByTelephone(telephone);
        if(user!=null){
            return user.getUserId();
        }else {
            return -1;
        }
    }
}
