package com.know.dao;

import com.know.pojo.User;

import java.util.Map;

public interface UserMapper {
    int signUp(User user);
    User checkByTelephone(String telephone);
    int modifyPassword(User user);
    User checkByUserId(int userId);
    int modifyPersonalInfo(User user);
    int modifyHead(User user);
    int modifyCollected(Map<String, Object> map);
}
