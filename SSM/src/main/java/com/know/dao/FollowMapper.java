package com.know.dao;

import com.know.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FollowMapper {
    // 关注
    @Insert("insert into know.followuser(fanId, userId) values (#{fanId}, #{userId});")
    int follow(@Param("fanId") int fanId, @Param("userId") int userId);
    // 取消关注
    @Delete("delete from know.followuser where fanId = #{fanId} and userId = #{userId};")
    int unfollow(@Param("fanId") int fanId, @Param("userId") int userId);
    // 获取关注列表
    List<User> getFollowingList(int userId);
    // 获取粉丝列表
    List<User> getFansList(int userId);
    // 是否存在关系
    @Select("select fanId from know.followuser where fanId = #{fanId} and userId = #{userId};")
    Integer checkRelation(@Param("fanId") int fanId, @Param("userId") int userId);
}
