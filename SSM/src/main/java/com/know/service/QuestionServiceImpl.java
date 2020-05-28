package com.know.service;

import com.know.dao.QtrelationMapper;
import com.know.dao.QuestionMapper;
import com.know.pojo.Question;

import java.util.Date;
import java.util.List;

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

    public int updateQuestion(Question question){
        question.setQuestionTime(new Date());
        try{
            int i = questionMapper.updateQuestion(question);
            if(i==0){
                return -1;
            }
            qtrelationMapper.deleteTopic(question.getQuestionId());
            for(int topicId:question.getTopicId()){
                qtrelationMapper.insert(question.getQuestionId(),topicId);
            }
            return 1;
        }catch (Exception e){
            return -1;
        }
    }

    public Question queryQuestionByQuestionId(int questionId){
        List<Integer> list = qtrelationMapper.queryTopicListByquestionId(questionId);
        int[] topicId = list.stream().mapToInt(Integer::valueOf).toArray();
        Question question = questionMapper.queryQuestionByQuestionId(questionId);
        question.setTopicId(topicId);
        return question;
    }


    public List<Question> queryQuestionListByUserId(int userId){
        List<Question> list = questionMapper.queryQuestionListByUserId(userId);
        for (Question question:list) {
            List<Integer> topicIdList = qtrelationMapper.queryTopicListByquestionId(question.getQuestionId());
            int[] topicId = topicIdList.stream().mapToInt(Integer::valueOf).toArray();
            question.setTopicId(topicId);
        }
        return list;
    }
}
