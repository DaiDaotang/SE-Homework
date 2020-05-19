package com.know.service;

import com.know.pojo.Topic;

import java.util.List;
import java.util.Map;

public interface TopicService {
    // 新建话题
    int insertTopic(int userId, Topic topic);
    // 删除话题
    int deleteTopic(int topicId);
    // 查询话题 by id
    Topic queryTopicById(int topicId);
    // 模糊查询话题 by name
    List<Topic> queryTopicByName(Map<String, Object> map);
    // 精准查询话题 by name
    Topic queryTopicExactly(String topicName);
    // 模糊查询一个话题 by name
    Topic queryOneTopicByName(String topicName);
}
