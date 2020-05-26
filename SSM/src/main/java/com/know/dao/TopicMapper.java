package com.know.dao;

import com.know.pojo.Topic;

import java.util.List;
import java.util.Map;

public interface TopicMapper {
    // 新建话题
    int insertTopic(Topic topic);
    // 删除话题
    int deleteTopic(int topicId);
    // 查询话题 by id
    Topic queryTopicById(int topicId);
    // 精准查询话题 by name
    Topic queryTopicExactly(String topicName);
    // 模糊查询多个话题 by name
    List<Topic> queryTopicByName(Map<String, Object> map);
    // 模糊查询一个话题 by name
    Topic queryOneTopicByName(String topicName);
    // 查询一个话题下的问题
    List<Topic> queryQuestions(Map<String, Object> map);
}
