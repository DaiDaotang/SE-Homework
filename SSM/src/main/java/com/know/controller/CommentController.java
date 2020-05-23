package com.know.controller;

import com.know.pojo.Comment;
import com.know.pojo.User;
import com.know.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
