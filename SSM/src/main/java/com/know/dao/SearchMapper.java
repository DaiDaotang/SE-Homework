package com.know.dao;

import com.know.pojo.Question;
import com.know.pojo.Topic;
import com.know.pojo.User;

import java.util.List;
import java.util.Map;

public interface SearchMapper {
    // 搜索用户
    List<User> queryUsers(Map<String, Object> map);

    // 搜索话题
    List<Topic> queryTopics(Map<String, Object> map);

    // 搜索问题
    List<Question> queryQuestions(Map<String, Object> map);
}
