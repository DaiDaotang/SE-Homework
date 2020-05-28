package com.know.service;

import com.know.pojo.Answer;

import java.util.List;
import java.util.Map;

public interface AnswerService {
    // 新建回答
    int insertAnswer(int userId, String content, int questionId);
    // 删除回答
    int deleteAnswer(int answerId, int questionId);
    // 修改回答
    int updateAnswer(int answerId, String content);
     // 获取回答 by answerId
    Answer queryAnswerByAnswerId(int answerId);
    // 获取回答列表 by questionid / userId
    public Map<String, Object> queryAnswerListByQUId(int answererId, int answerQuestionId, int extra, int start, int count);
}
