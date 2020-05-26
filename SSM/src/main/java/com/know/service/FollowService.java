package com.know.service;

import com.know.pojo.User;

import java.util.List;

public interface FollowService {
    // 关注
    int follow(int fanId, int userId);
    // 取消关注
    int unfollow(int fanId, int userId);
    // 获取关注列表
    List<User> getFollowingList(int userId, int start, int count);
    // 获取粉丝列表
    List<User> getFansList(int userId, int start, int count);
    // 是否有关系
    Integer checkRelation(int fanId, int userId);
}
