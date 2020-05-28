package com.know.service;

import com.know.dao.AnswerMapper;
import com.know.dao.QuestionMapper;
import com.know.dao.UserMapper;
import com.know.pojo.Answer;
import com.know.pojo.Question;
import com.know.utils.QueryUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AnswerServiceImpl implements AnswerService{
    private AnswerMapper answerMapper;
    public void setAnswerMapper(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }
    private QuestionMapper questionMapper;
    private UserMapper userMapper;
    public void setQuestionMapper(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int insertAnswer(int userId, String content, int questionId) {
        // TODO...
        Answer answer = new Answer();
        answer.setAnswererId(userId);
        answer.setAnswerContent(content);
        answer.setAnswerQuestionId(questionId);
        answer.setAnswerTime(new Date());
        return answerMapper.insertAnswer(answer) == 1? answer.getAnswerId() : -1;
    }

    public int deleteAnswer(int answerId) {
        // TODO...
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