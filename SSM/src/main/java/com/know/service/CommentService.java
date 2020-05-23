package com.know.service;

import com.know.pojo.Comment;

public interface CommentService {

    //评论
    int comment(Comment comment);
    //删除评论
    int deleteComment(int commentId);
}
