package com.know.dao;

import com.know.pojo.Comment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CommentMapper {
    //评论,返回评论Id
    int comment(Comment comment);
    //删除评论
    int deleteComment(int commentId);
    //根据时间排序返回回答下的评论
    List<Comment> queryCommentOrderByTime(int answerId);
    //根据点赞数返回回答下的评论
    List<Comment> queryCommentOrderByLiked(int answerId);
    // 修改点赞数
    @Update("update know.comment set commentLiked = commentLiked + #{count} where commentId = #{commentedId}")
    int modifyLiked(@Param("commentId") int commentId, @Param("count") int count);
}
