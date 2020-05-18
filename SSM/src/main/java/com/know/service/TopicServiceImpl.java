/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TopicServiceImpl
 * Author:   夕汐
 * Date:     2020/5/18 17:49
 * Description: Topic Service Impl
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.service;

import com.know.dao.TopicMapper;
import com.know.pojo.Topic;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Topic Service Impl〉
 *
 * @author 夕汐
 * @create 2020/5/18
 * @since 1.0.0
 */
public class TopicServiceImpl implements TopicService{

    private TopicMapper topicMapper;

    public void setTopicMapper(TopicMapper topicMapper) {
        this.topicMapper = topicMapper;
    }

    public int insertTopic(int userId, Topic topic) {
        return topicMapper.insertTopic(topic);
    }

    public int deleteTopic(int topicId) {
        return 0;
    }

    public Topic queryTopicById(int topicId) {
        return null;
    }

    public List<Topic> queryTopicByName(String topicName) {
        return null;
    }

    public Topic queryTopicExactly(String topicName) {
        return topicMapper.queryTopicExactly(topicName);
    }
}