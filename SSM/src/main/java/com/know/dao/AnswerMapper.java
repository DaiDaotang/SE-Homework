package com.know.dao;

import com.know.pojo.Answer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface AnswerMapper {
    // 新建回答
    int insertAnswer(Answer answer);
    // 修改回答
    int updateAnswer(Answer answer);
    // 删除回答
    int deleteAnswer(int answerId);
    // 获取回答 by answerId
    Answer queryAnswerByAnswerId(int answerId);
    // 获取回答列表 by questionid / userId
    List<Answer> queryAnswerListByQUId(Map<String, Integer> map);
    // 修改收藏数
    int modifyAnswerCollected(Map<String, Object> map);
    // 修改点赞数
    @Update("update know.answer set answerLiked = answerLiked + #{count} where answerId = #{answerId}")
    int modifyAnswerLiked(@Param("answerId") int answerId, @Param("count") int count);
    // 查询答主Id by answerId
    int queryAnswererIdByAnswerId(int answerId);
}
