package com.know.service;

import com.know.pojo.User;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserService {
    int signUp(User user);
}
