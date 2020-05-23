package com.know.service;

import com.know.dao.CommentMapper;
import com.know.pojo.Comment;
import com.know.pojo.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CommentServiceImpl implements CommentService{

    private CommentMapper commentMapper;
    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public int comment(Comment comment){
        comment.setCommentedId(0);
        comment.setCommentLiked(0);
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String dateTime = df.format(date);
        comment.setCommentTime(dateTime);
        try{
            return commentMapper.comment(comment);
        }catch (Exception e){
            return -1;
        }
    }
}
