package com.know.controller;

import com.know.pojo.Question;
import com.know.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    @Qualifier("questionServiceImpl")
    private QuestionService questionService;

    // 提问
    @RequestMapping("/askQuestion")
    public int askQuestion(Question question){
        return questionService.askQuestion(question);
    }
}
