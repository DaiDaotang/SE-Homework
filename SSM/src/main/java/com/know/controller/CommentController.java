package com.know.controller;

import com.know.pojo.Comment;
import com.know.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    @Qualifier("commentServiceImpl")
    private CommentService commentService;

    // 评论
    @RequestMapping("/comment")
    public int comment(Comment comment){
        //System.out.println(comment);
        return commentService.comment(comment);
    }

    // 删除评论
    @RequestMapping("/deleteComment")
    public String deleteComment(int commentId){
        if(commentService.deleteComment(commentId)==0){
            return "No comment!";
        }else {
            return "OK";
        }
    }

    // 回复评论
    @RequestMapping("/responseComment")
    public int responseComment(Comment comment){
        //System.out.println(comment);
        return commentService.comment(comment);
    }

    //按照时间返回评论
    @RequestMapping("/getCommentsOrderByTime")
    public List<Comment> getCommentsOrderByTime(int answerId, int start, int count){
        return commentService.queryCommentOrderByTime(answerId,start,count);
    }

    //按照点赞数返回评论
    @RequestMapping("/getCommentsOrderByLiked")
    public List<Comment> getCommentsOrderByLiked(int answerId, int start, int count){
        return commentService.queryCommentOrderByLiked(answerId,start,count);
    }
}
