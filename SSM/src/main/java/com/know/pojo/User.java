package com.know.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String telephone;
    private String password;
    private String name;
    private String sex;
    private String birthday;
    private String signUpTime;
    private int answerCollected;
    private int answerLiked;
    private String head;
    private int fansCount;
    private int followingCount;
}
