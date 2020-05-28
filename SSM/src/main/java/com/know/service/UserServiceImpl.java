package com.know.service;

import com.know.dao.UserMapper;
import com.know.pojo.User;
import com.know.utils.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class UserServiceImpl implements UserService{

    private UserMapper userMapper;


    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int signUp(User user) {
        user.setAnswerCollected(0);
        user.setAnswerLiked(0);
        user.setSignUpTime(new Date());
        try{
            int i = userMapper.signUp(user);
            if(i==1){
                return user.getUserId();
            }else{
                return -1;
            }
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

    public int modifyCollected(int userId, int answerCollected) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("answerCollected", answerCollected);
        return userMapper.modifyCollected(map);
    }
}
