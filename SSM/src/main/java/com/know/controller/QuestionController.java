package com.know.controller;

import com.know.pojo.Question;
import com.know.service.QuestionService;
import com.know.utils.QueryUtil;
import com.know.utils.util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String oldName = questionService.queryQuestionByQuestionId(question.getQuestionId()).getQuestionContent();
        String newName = u.upload(question.getQuestionContent(), markdownPath, question.getQuestionerId());
        question.setQuestionContent(newName);
        if(questionService.updateQuestion(question)==-1){
            return "Failed to update the question!";
        }
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
    public Question queryQuestionByQuestionId(int questionId) {
        String root = servletContext.getRealPath("") + "markdown";
        Question question =  questionService.queryQuestionByQuestionId(questionId);
        String fileName = question.getQuestionContent();
        util util = new util();
        String content = util.download(root, fileName);
        System.out.println(content);
        question.setQuestionContent(content);
        return question;
    }

    // 根据用户id返回问题
    @RequestMapping("/queryQuestionListByUserId")
    public Map<String, Object> queryQuestionListByUserId(@Param("userId") int userId, @Param("start")int start, @Param("count")int count){
        Map<String,Object> map = new HashMap<String, Object>();
        util util = new util();
        String root = servletContext.getRealPath("") + "markdown";
        List<Question> list = QueryUtil.cutList(questionService.queryQuestionListByUserId(userId),start,count);
        for (Question question:list) {
            String fileName = question.getQuestionContent();
            question.setQuestionContent(util.download(root, fileName));
        }
        int length = list.size();
        map.put("total",length);
        map.put("list", list);
        return map;
    }
}
