/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FollowController
 * Author:   夕汐
 * Date:     2020/5/26 17:11
 * Description: 关注控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.controller;

import com.know.pojo.User;
import com.know.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈关注控制器〉
 *
 * @author 夕汐
 * @create 2020/5/26
 * @since 1.0.0
 */
@RestController
@RequestMapping("/follow")
public class FollowController {
    @Autowired
    @Qualifier("followServiceImpl")
    private FollowService followService;
    public void setFollowService(FollowService followService) {
        this.followService = followService;
    }

    // 关注/取消关注
    @RequestMapping("/follow")
    public String follow(int fanId, int userId, boolean type){
        return (type?
                followService.follow(fanId, userId):
                followService.unfollow(fanId, userId))
                == 1? "OK" : "ERR";
    }

    // 获取关注/粉丝列表
    // 获取关注列表
    @RequestMapping("/getList")
    public List<User> getFollowingList(int userId, int start, int count, int type){
        if(type == 0){
            return followService.getFollowingList(userId, start, count);
        }
        else if(type == 1){
            return followService.getFansList(userId, start, count);
        }
        else{
            return null;
        }
    }

    // 检查是否已关注
    @RequestMapping("/checkRelation")
    public boolean checkRelation(int userId, int targetUserId){
        return followService.checkRelation(userId, targetUserId) != null;
    }
}