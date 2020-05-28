package com.know.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface QtrelationMapper {

    //添加问题的话题
    @Insert("insert into know.qtrelation(questionId, topicId) values (#{questionId},#{topicId});")
    int insert(@Param("questionId")int questionId, @Param("topicId")int topicId);
    //删除问题的话题
    @Delete("delete from know.qtrelation where questionId = #{questionId};")
    int deleteTopic(@Param("questionId")int questionId);
    //查询问题的话题
    @Select("delete from know.qtrelation where questionId = #{questionId};")
    List<Integer> queryTopicListByquestionId(@Param("questionId")int questionId);

}
