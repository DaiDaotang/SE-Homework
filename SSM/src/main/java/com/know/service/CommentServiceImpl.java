package com.know.service;

import com.know.dao.CommentMapper;
import com.know.pojo.Comment;
import com.know.utils.QueryUtil;

import java.util.Date;
import java.util.List;

public class CommentServiceImpl implements CommentService{

    private CommentMapper commentMapper;
    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public int comment(Comment comment){
        comment.setCommentTime(new Date());
        try{
            int i = commentMapper.comment(comment);
            if(i==1){
                return comment.getCommentId();
            }
            return -1;
        }catch (Exception e){
            return -1;
        }
    }

    public int deleteComment(int commentId){
        return commentMapper.deleteComment(commentId);
    }

    public List<Comment> queryCommentOrderByTime(int answerId, int start, int count){
        return QueryUtil.cutList(commentMapper.queryCommentOrderByTime(answerId),start,count);
    }

    public List<Comment> queryCommentOrderByLiked(int answerId, int start, int count){
        return QueryUtil.cutList(commentMapper.queryCommentOrderByLiked(answerId),start,count);
    }
}
