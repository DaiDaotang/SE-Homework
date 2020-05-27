package com.know.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface LikeMapper {
    // 点赞回答
    int likeAnswer(int userId, int answerId, Date likeTime);
    // 取消点赞回答
    int dislikeAnswer(int userId, int answerId);
    // 点赞评论
    int likeComment(int userId, int answerId, Date likeTime);
    // 取消点赞评论
    int dislikeComment(int userId, int answerId);
    // 查询是否点赞了这个回答
    @Select("select userId from know.likeanswer where userId = #{userId} and answerId = #{answerId}")
    Integer checkAnswer(@Param("userId") int userId, @Param("answerId") int answerId);
    // 查询是否点赞了这个评论
    @Select("select userId from know.likecomment where userId = #{userId} and commentId = #{commentId}")
    Integer checkComment(@Param("userId") int userId, @Param("commentId") int commentId);
}
