package com.know.service;

import com.know.dao.AnswerMapper;

public class AnswerServiceImpl implements AnswerService{
    private AnswerMapper answerMapper;
    public void setAnswerMapper(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }
}