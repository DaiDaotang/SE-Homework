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
import com.know.utils.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.util.Date;
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
    @Autowired
    private ServletContext servletContext;

    // 新建话题
    @RequestMapping("/bringUpTopic")
    public Map<String, Object> bringUpTopic(int userId, String topicName){
        Map<String, Object> map = new HashMap<String, Object>();
        // 若已有
        if(topicService.queryTopicExactly(topicName) != null){
            map.put("msg", "ERR");
            map.put("topicId", -1);
        }
        else{
            Topic topic = new Topic(-1, topicName, userId, new Date());
            if(topicService.insertTopic(topic) != 1){
                map.put("msg", "ERR");
                map.put("topicId", -1);
            }
            else{
                map.put("msg", "OK");
                map.put("topicId", topic.getTopicId());
            }
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
        // 获取数据
        Topic topic = topicService.queryTopicExactly(topicName);
        Map<String, Object> map = topicService.queryTopicByName(topicName, topic == null? -1 : topic.getTopicId(), start, count);

        // 添加额外数据
        map.put("topic", topic);
        return map;
    }

    // 查询话题下的问题
    @RequestMapping("/queryQuestions")
    public Map<String, Object> queryQuestion(int topicId, int extra, int start, int count, int n){
        return topicService.queryQuestion(topicId, extra, start, count, n, servletContext.getRealPath("") + "markdown");
    }
}