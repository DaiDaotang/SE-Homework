package com.know.dao;

import com.know.pojo.User;

import java.util.Map;

public interface UserMapper {
    //注册
    int signUp(User user);
    //通过电话号查询用户
    User checkByTelephone(String telephone);
    //修改密码
    int modifyPassword(User user);
    //通过用户Id查询用户
    User checkByUserId(int userId);
    //修改用户信息
    int modifyPersonalInfo(User user);
    //修改头像
    int modifyHead(User user);
    // 修改回答收藏数
    int modifyCollected(Map<String, Object> map);
    // 修改关注数
    int modifyFollowingCount(Map<String, Integer> map);
    // 修改关注数
    int modifyFansCount(Map<String, Integer> map);
    // 修改获赞数
    int modifyLiked(Map<String, Integer> map);
}
