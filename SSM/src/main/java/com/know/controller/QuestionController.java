package com.know.controller;

import com.know.pojo.Question;
import com.know.service.QuestionService;
import com.know.utils.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.io.File;

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
        util u = new util();
        String markdownPath = servletContext.getRealPath("") + "markdown";
        String content = u.upload(question.getQuestionContent(),markdownPath,question.getQuestionerId());
        question.setQuestionContent(content);
        return questionService.askQuestion(question);
    }

    //修改问题
    @RequestMapping("/updateQuestion")
    public String updateQuestion(Question question){
        util u = new util();
        String markdownPath = servletContext.getRealPath("") + "markdown";
        String oldName = question.getQuestionContent();
        String newName = u.upload(question.getQuestionContent(), markdownPath, question.getQuestionerId());
        question.setQuestionContent(newName);
        questionService.updateQuestion(question);
        File f = new File(markdownPath + File.separator + oldName);
        if(f.exists()) {
            boolean b = f.delete();
            if (!b) {
                return "Failed to delete old file!";
            }
            return "OK";
        }else {
            return "Old file has disappeared!";
        }
    }

    // 查找问题
    @RequestMapping("/queryQuestionByQuestionId")
    public Question queryQuestionByQuestionId(int questionId){
        return questionService.queryQuestionByQuestionId(questionId);
    }
}
