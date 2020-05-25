package com.know.service;

import com.know.pojo.Comment;

import java.util.List;

public interface CommentService {

    //评论
    int comment(Comment comment);
    //删除评论
    int deleteComment(int commentId);
    //按照时间排序评论
    List<Comment> queryCommentOrderByTime(int answerId, int start, int count);
    //按照点赞数排序评论
    List<Comment> queryCommentOrderByLiked(int answerId, int start, int count);
}
