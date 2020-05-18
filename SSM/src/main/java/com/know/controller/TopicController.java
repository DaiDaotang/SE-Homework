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

    @RequestMapping("/bringUpTopic")
    public Map<String, Object> bringUpTopic(int userId, String topicName){
        Topic topic = new Topic(-1, topicName);
        Map<String, Object> map = new HashMap<String, Object>();
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
}