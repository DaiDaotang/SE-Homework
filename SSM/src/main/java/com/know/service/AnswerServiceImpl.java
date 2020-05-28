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
    public void setQuestionMapper(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    public int insertAnswer(int userId, String content, int questionId) {
        Answer answer = new Answer();
        answer.setAnswererId(userId);
        answer.setAnswerContent(content);
        answer.setAnswerQuestionId(questionId);
        answer.setAnswerTime(new Date());
        int res = answerMapper.insertAnswer(answer);
        if(res == 1){
            res = questionMapper.updateAnswerNumber(questionId, 1);
            return res == 1? answer.getAnswerId() : -1;
        }
        else{
            return -1;
        }
    }

    public int deleteAnswer(int answerId, int questionId) {

        return (answerMapper.deleteAnswer(answerId) + questionMapper.updateAnswerNumber(questionId, -1)) % 2 + 1;
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