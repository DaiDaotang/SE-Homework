package com.know.dao;

import com.know.pojo.Comment;

import java.util.List;

public interface CommentMapper {
    //评论,返回评论Id
    int comment(Comment comment);
    //删除评论
    int deleteComment(int commentId);
    //根据时间排序返回回答下的评论
    List<Comment> queryCommentOrderByTime(int answerId);
    //根据点赞数返回回答下的评论
    List<Comment> queryCommentOrderByLiked(int answerId);

}
