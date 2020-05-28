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
import com.know.dao.SearchMapper;
import com.know.dao.TopicMapper;
import com.know.dao.UserMapper;
import com.know.pojo.Question;
import com.know.pojo.Topic;
import com.know.utils.QueryUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈搜索模块〉
 *
 * @author 夕汐
 * @create 2020/5/27
 * @since 1.0.0
 */
public class SearchServiceImpl implements SearchService{
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
    private SearchMapper searchMapper;
    public void setSearchMapper(SearchMapper searchMapper) {
        this.searchMapper = searchMapper;
    }

    public Map<String, Object> query(int type, String keyword, int extra, int start, int count, int n) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("keyword", keyword);
        map.put("extra", extra);
        switch (type){
            // 问题
            case 0:
                return QueryUtil.queryResult(
                        QueryUtil.changeQContent(searchMapper.queryQuestions(map), n),
                        start,
                        count);
            // 话题
            case 1:
                return QueryUtil.queryResult(searchMapper.queryTopics(map), start, count);
            // 用户
            case 2:
                return QueryUtil.queryResult(searchMapper.queryUsers(map), start, count);
            default:
                return null;
        }
    }
}