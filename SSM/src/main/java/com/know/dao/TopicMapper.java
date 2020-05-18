package com.know.dao;

public interface TopicMapper {
    // 新建话题
    int bringUpTopic(int userId, String topicName);
}
