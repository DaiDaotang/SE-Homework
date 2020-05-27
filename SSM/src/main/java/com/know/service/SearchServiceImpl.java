/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SearchServiceImpl
 * Author:   夕汐
 * Date:     2020/5/27 17:51
 * Description: 搜索模块
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.service;

import com.know.dao.QuestionMapper;
import com.know.dao.TopicMapper;
import com.know.dao.UserMapper;
import com.know.pojo.Question;
import com.know.pojo.Topic;

/**
 * 〈一句话功能简述〉<br> 
 * 〈搜索模块〉
 *
 * @author 夕汐
 * @create 2020/5/27
 * @since 1.0.0
 */
public class SearchServiceImpl {
    private UserMapper userMapper;
    private TopicMapper topicMapper;
    private QuestionMapper questionMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void setTopicMapper(TopicMapper topicMapper) {
        this.topicMapper = topicMapper;
    }

    public void setQuestionMapper(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }
}