package com.know.dao;

import com.know.pojo.User;

public interface UserMapper {
    int signUp(User user);
    User logIn(String telephone);
}
