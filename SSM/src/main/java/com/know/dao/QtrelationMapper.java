package com.know.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface QtrelationMapper {

    //添加问题的话题
    @Insert("insert into know.qtrelation(questionId, topicId) values (#{questionId},#{topicId});")
    int insert(@Param("questionId")int questionId, @Param("topicId")int topicId);

}
