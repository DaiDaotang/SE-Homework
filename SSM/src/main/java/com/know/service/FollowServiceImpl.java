/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FollowServiceImpl
 * Author:   夕汐
 * Date:     2020/5/26 17:09
 * Description: 关注业务实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.service;

import com.know.dao.FollowMapper;
import com.know.dao.UserMapper;
import com.know.pojo.User;
import com.know.utils.QueryUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈关注业务实现类〉
 *
 * @author 夕汐
 * @create 2020/5/26
 * @since 1.0.0
 */
public class FollowServiceImpl implements FollowService{
    private FollowMapper followMapper;
    public void setFollowMapper(FollowMapper followMapper) {
        this.followMapper = followMapper;
    }
    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int follow(int fanId, int userId) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("fanId", fanId);
        map.put("userId", userId);
        map.put("count", 1);
        return (followMapper.follow(fanId, userId) +
                userMapper.modifyFollowingCount(map) +
                userMapper.modifyFansCount(map))
                % 3 + 1;
    }

    public int unfollow(int fanId, int userId) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("fanId", fanId);
        map.put("userId", userId);
        map.put("count", -1);
        return (followMapper.unfollow(fanId, userId) +
                userMapper.modifyFollowingCount(map) +
                userMapper.modifyFansCount(map))
                % 3 + 1;
    }

    public List<User> getFollowingList(int userId, int start, int count) {
        return QueryUtil.cutList(followMapper.getFollowingList(userId), start, count);
    }

    public List<User> getFansList(int userId, int start, int count) {
        return QueryUtil.cutList(followMapper.getFansList(userId), start, count);
    }

    public Integer checkRelation(int fanId, int userId) {
        return followMapper.checkRelation(fanId, userId);
    }
}