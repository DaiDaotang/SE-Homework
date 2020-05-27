package com.know.service;

public interface LikeService {
    // 点赞/取消点赞回答
    public int likeAnswer(int userId, int answerId, boolean type);
    // 点赞/取消点赞评论
    public int likeComment(int userId, int commentId, boolean type);
    // 查询是否点赞了这个回答
    public boolean whetherLikedAnswer(int userId, int answerId);
    // 查询是否点赞了这个评论
    public boolean whetherLikedComment(int userId, int commentId);
}
