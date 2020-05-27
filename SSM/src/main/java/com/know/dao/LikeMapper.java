package com.know.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface LikeMapper {
    // 点赞回答
    @Insert("insert into know.likeanswer (userId, answerId, likeTime) values (#{userId}, #{answerId}, #{likeTime});")
    int likeAnswer(@Param("userId") int userId, @Param("answerId") int answerId, @Param("likeTime") Date likeTime);
    // 取消点赞回答
    @Delete("delete from know.likeanswer where userId = #{userId} and answerId = #{answerId}")
    int dislikeAnswer(@Param("userId") int userId, @Param("answerId") int answerId);
    // 点赞评论
    @Insert("insert into know.likecomment (userId, commentId, likeTime) values (#{userId}, #{commentId}, #{likeTime});")
    int likeComment(@Param("userId") int userId, @Param("commentId") int commentId, @Param("likeTime") Date likeTime);
    // 取消点赞评论
    @Delete("delete from know.likecomment where userId = #{userId} and commentId = #{commentId}")
    int dislikeComment(@Param("userId") int userId, @Param("commentId") int commentId);
    // 查询是否点赞了这个回答
    @Select("select userId from know.likeanswer where userId = #{userId} and answerId = #{answerId}")
    Integer checkAnswer(@Param("userId") int userId, @Param("answerId") int answerId);
    // 查询是否点赞了这个评论
    @Select("select userId from know.likecomment where userId = #{userId} and commentId = #{commentId}")
    Integer checkComment(@Param("userId") int userId, @Param("commentId") int commentId);
}
