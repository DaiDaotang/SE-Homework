/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TopicController
 * Author:   夕汐
 * Date:     2020/5/18 22:27
 * Description: Topic Controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.controller;

import com.know.pojo.Topic;
import com.know.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Topic Controller〉
 *
 * @author 夕汐
 * @create 2020/5/18
 * @since 1.0.0
 */
@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    @Qualifier("topicServiceImpl")
    private TopicService topicService;

    // 新建话题
    @RequestMapping("/bringUpTopic")
    public Map<String, Object> bringUpTopic(int userId, String topicName){
        Map<String, Object> map = new HashMap<String, Object>();
        Topic topic = new Topic(-1, topicName);
        if(topicService.insertTopic(userId, topic) != 1){
            map.put("msg", "新建话题失败");
            map.put("topicId", -1);
        }
        else{
            map.put("msg", "OK");
            map.put("topicId", topic.getTopicId());
        }
        return map;
    }

    // 查询话题是否存在
    @RequestMapping("/checkTopic")
    public Map<String, Object> checkTopic(String topicName){
        Map<String, Object> map = new HashMap<String, Object>();
        Topic topic;
        // 若已存在
        if((topic = topicService.queryTopicExactly(topicName)) != null){
            map.put("msg", "Yes");
            map.put("topic", topic);
        }
        // 若未存在
        else{
            topic = topicService.queryOneTopicByName(topicName);
            map.put("msg", "No");
            map.put("topic", topic);
        }
        return map;
    }

    // 查询话题 by id
    @RequestMapping("/queryTopicById")
    public Topic queryTopicById(int topicId){
        return topicService.queryTopicById(topicId);
    }

    // 查询话题 by name
    @RequestMapping("/queryTopicByName")
    public Map<String, Object> queryTopicByName(String topicName, int start, int count){
        Map<String, Object> map = new HashMap<String, Object>();

        // 获取总的数据
        Topic topic = topicService.queryTopicExactly(topicName);
        map.put("topicId", topic == null? -1 : topic.getTopicId());
        map.put("topicName", topicName);
        // 获取数据，可能要改成从缓冲获取
        List<Topic> topics = topicService.queryTopicByName(map);
        map.clear();

        int s = topics.size();
        // 开始数据处理
        map.put("topic", topic);
        map.put("count", s);
        // start 超出大小
        if(start > s){
            map.put("msg", "Out of bound");
            map.put("topics", null);
        }
        else{
            // 裁剪 list
            if(start + count < s){
                topics = topics.subList(start, start + count);
            }
            else{
                topics = topics.subList(start, s);
            }
            map.put("msg", "OK");
            map.put("topics", topics);
        }
        return map;
    }
}