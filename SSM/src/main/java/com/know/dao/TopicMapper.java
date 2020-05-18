package com.know.dao;

import com.know.pojo.Topic;

import java.util.List;

public interface TopicMapper {
    // 新建话题
    int insertTopic(Topic topic);
    // int insertTopic(int userId, Topic topic);
    // 删除话题
    int deleteTopic(int topicId);
    // 查询话题 by id
    Topic queryTopicById(int topicId);
    // 查询话题 by name
    List<Topic> queryTopicByName(String topicName);
    // 精准查询话题 by name
    Topic queryTopicExactly(String topicName);
}
