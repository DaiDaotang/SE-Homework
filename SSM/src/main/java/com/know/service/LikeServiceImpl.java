/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LikeServiceImpl
 * Author:   夕汐
 * Date:     2020/5/26 17:09
 * Description: 点赞业务实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.service;

import com.know.dao.AnswerMapper;
import com.know.dao.LikeMapper;
import com.know.dao.UserMapper;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈点赞业务实现类〉
 *
 * @author 夕汐
 * @create 2020/5/26
 * @since 1.0.0
 */
public class LikeServiceImpl implements LikeService{
    private LikeMapper likeMapper;
    public void setLikeMapper(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;
    }
    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    private AnswerMapper answerMapper;
    public void setAnswerMapper(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    public int likeAnswer(int userId, int answerId, boolean type) {
        int res = 0;
        if(type){
            res += likeMapper.likeAnswer(userId, answerId, new Date());
            res += userMapper.modifyLiked(userId, 1);
            res += answerMapper.modifyAnswerLiked(answerId, 1);
        }
        else{
            res += likeMapper.dislikeAnswer(userId, answerId);
            res += userMapper.modifyLiked(userId, -1);
            res += answerMapper.modifyAnswerLiked(answerId, -1);
        }
        return res % 3 + 1;
    }

    public int likeComment(int userId, int commentId, boolean type) {
        return type?
                likeMapper.likeComment(userId, commentId, new Date()) :
                likeMapper.dislikeComment(userId, commentId);
    }

    public boolean whetherLikedAnswer(int userId, int answerId) {
        return likeMapper.checkAnswer(userId, answerId) != null;
    }

    public boolean whetherLikedComment(int userId, int commentId) {
        return likeMapper.checkComment(userId, commentId) != null;
    }
}