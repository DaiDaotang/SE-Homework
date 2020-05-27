package com.know.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

public interface AnswerMapper {
    // 修改收藏数
    int modifyAnswerCollected(Map<String, Object> map);
    // 修改点赞数
    @Update("update know.answer set answerLiked = answerLiked + #{count} where answerId = #{answerId}")
    int modifyAnswerLiked(@Param("answerId") int answerId, @Param("count") int count);
    // 查询答主Id by answerId
    int queryAnswererIdByAnswerId(int answerId);
}
