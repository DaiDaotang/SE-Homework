package com.know.service;

import com.know.pojo.Topic;

import java.util.List;

public interface TopicService {
    // 新建话题
    int insertTopic(int userId, Topic topic);
    // 删除话题
    int deleteTopic(int topicId);
    // 查询话题 by id
    Topic queryTopicById(int topicId);
    // 查询话题 by name
    List<Topic> queryTopicByName(String name);
}
