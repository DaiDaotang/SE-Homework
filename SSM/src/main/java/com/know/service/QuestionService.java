package com.know.service;

import com.know.pojo.Question;

public interface QuestionService {
    //提问
    int askQuestion(Question question);
    //修改问题
    int updateQuestion(Question question);
    //查询问题
    Question queryQuestionByQuestionId(int questionId);
}
