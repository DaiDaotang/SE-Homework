package com.know.dao;

import com.know.pojo.Comment;

public interface CommentMapper {
    //评论,返回评论Id
    int comment(Comment comment);
    //删除评论
    int deleteComment(int commentId);

}
