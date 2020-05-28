package com.know.dao;

import com.know.pojo.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface QuestionMapper {
    //提问
    int askQuestion(Question question);
    //修改问题
    int updateQuestion(Question question);
    //查询问题
    Question queryQuestionByQuestionId(int questionId);
    //根据用户ID查询问题
    List<Question> queryQuestionListByUserId(int userId);
    // 修改问题回答数量
    @Update("update know.question set answerNumber = answerNumber + #{count} where questionId = #{questionId}")
    int updateAnswerNumber(@Param("questionId") int questionId, @Param("count") int count);
}
