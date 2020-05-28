package com.know.controller;

import com.know.pojo.Question;
import com.know.service.QuestionService;
import com.know.utils.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private ServletContext servletContext;
    @Autowired
    @Qualifier("questionServiceImpl")
    private QuestionService questionService;

    // 提问
    @RequestMapping("/askQuestion")
    public int askQuestion(Question question){
        if(question.getQuestionContent()==null){
            return -1;
        }
        String webRootPath = servletContext.getRealPath("");
        String markdownPath = webRootPath + "markdown";
        System.out.println(webRootPath);
        util u = new util();
        String content = u.upload(question.getQuestionContent(),markdownPath,question.getQuestionerId());
        question.setQuestionContent(content);
        return questionService.askQuestion(question);
    }
}
