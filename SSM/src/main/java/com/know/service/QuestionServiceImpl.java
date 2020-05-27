package com.know.service;

import com.know.dao.QtrelationMapper;
import com.know.dao.QuestionMapper;
import com.know.pojo.Question;

import java.util.Date;

public class QuestionServiceImpl implements QuestionService{

    private QuestionMapper questionMapper;

    public void setQuestionMapper(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    private QtrelationMapper qtrelationMapper;

    public void setQtrelationMapper(QtrelationMapper qtrelationMapper) {
        this.qtrelationMapper = qtrelationMapper;
    }

    public int askQuestion(Question question){
        question.setQuestionTime(new Date());
        question.setAnswerNumber(0);
        question.setBrowseNumber(0);
        try{
            int i = questionMapper.askQuestion(question);
            if(i==1){
                int questionId = question.getQuestionId();
                if(question.getTopicId()==null){
                    return questionId;
                }
                for(int topicId:question.getTopicId()){
                    qtrelationMapper.insert(questionId,topicId);
                }
                return questionId;
            }
            return -1;
        }catch (Exception e){
            return -1;
        }
    }
}
