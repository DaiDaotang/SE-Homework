/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AnswerController
 * Author:   夕汐
 * Date:     2020/5/23 12:09
 * Description: 回答业务实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.know.service;

import com.know.dao.AnswerMapper;
import com.know.dao.QuestionMapper;
import com.know.dao.UserMapper;
import com.know.pojo.Answer;
import com.know.pojo.Question;
import com.know.utils.QueryUtil;
import com.know.utils.util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈回答业务实现类〉
 *
 * @author 夕汐
 * @create 2020/5/23
 * @since 1.0.0
 */

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

    public int deleteAnswer(int answerId) {
        Answer answer = answerMapper.queryAnswerByAnswerId(answerId);

        return (answerMapper.deleteAnswer(answerId) +
                questionMapper.updateAnswerNumber(answer.getAnswerQuestionId(), -1))
                % 2 + 1;
    }

    public int updateAnswer(int answerId, String content) {
        Answer answer = new Answer();
        answer.setAnswerId(answerId);
        answer.setAnswerTime(new Date());
        answer.setAnswerContent(content);
        return answerMapper.updateAnswer(answer);
    }

    public Answer queryAnswerByAnswerId(int answerId) {
        Answer answer = answerMapper.queryAnswerByAnswerId(answerId);
        // answer.setAnswerContent("");
        return answer;
    }

    public Map<String, Object> queryAnswerListByQUId(int answererId, int answerQuestionId, int extra, int start, int count, int n) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("answererId", answererId);
        map.put("answerQuestionId", answerQuestionId);
        map.put("extra", extra);
        return QueryUtil.queryResult(
                QueryUtil.changeAContent(answerMapper.queryAnswerListByQUId(map), n),
                start,
                count);
    }
}