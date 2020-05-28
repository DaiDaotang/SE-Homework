package com.know.service;

import com.know.dao.AnswerMapper;
import com.know.pojo.Answer;
import com.know.utils.QueryUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AnswerServiceImpl implements AnswerService{
    private AnswerMapper answerMapper;
    public void setAnswerMapper(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    public int insertAnswer(int userId, String content, int questionId) {
        Answer answer = new Answer();
        answer.setAnswererId(userId);
        answer.setAnswerContent(content);
        answer.setAnswerQuestionId(questionId);
        answer.setAnswerTime(new Date());
        return answerMapper.insertAnswer(answer) == 1? answer.getAnswerId() : -1;
    }

    public int deleteAnswer(int answerId) {
        return answerMapper.deleteAnswer(answerId);
    }

    public int updateAnswer(int answerId, String content) {
        Answer answer = new Answer();
        answer.setAnswerId(answerId);
        answer.setAnswerContent(content);
        return answerMapper.updateAnswer(answer);
    }

    public Answer queryAnswerByAnswerId(int answerId) {
        return answerMapper.queryAnswerByAnswerId(answerId);
    }

    public Map<String, Object> queryAnswerListByQUId(int answererId, int answerQuestionId, int extra, int start, int count) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("answererId", answererId);
        map.put("answerQuestionId", answerQuestionId);
        map.put("extra", extra);
        return QueryUtil.queryResult(answerMapper.queryAnswerListByQUId(map), start, count);
    }
}