package com.know.service;

import com.know.dao.CommentMapper;

public class CommentServiceImpl implements CommentService{

    private CommentMapper commentMapper;

    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }
}
