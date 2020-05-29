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
import com.know.pojo.Question;
import com.know.pojo.Topic;
import com.know.utils.QueryUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public int insertTopic(Topic topic) {
        return topicMapper.insertTopic(topic);
    }

    public int deleteTopic(int topicId) {
        return 0;
    }

    public Topic queryTopicById(int topicId) {
        return topicMapper.queryTopicById(topicId);
    }

    public Map<String, Object> queryTopicByName(String topicName, int topicId, int start, int count) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("topicName", topicName);
        map.put("topicId", topicId);

        return QueryUtil.queryResult(topicMapper.queryTopicByName(map), start, count);
    }

    public Topic queryTopicExactly(String topicName) {
        return topicMapper.queryTopicExactly(topicName);
    }

    public Topic queryOneTopicByName(String topicName) {
        return topicMapper.queryOneTopicByName(topicName);
    }

    public Map<String, Object> queryQuestion(int topicId, int extra, int start, int count, int n, String root) {
        Map<String, Integer> tmp = new HashMap<String, Integer>();
        tmp.put("topicId", topicId);
        tmp.put("extra", extra);
        return QueryUtil.queryResult(
                QueryUtil.changeQContent(topicMapper.queryQuestions(tmp), n, root),
                start, count);
    }
}