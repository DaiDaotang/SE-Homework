/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SearchController
 * Author:   夕汐
 * Date:     2020/5/27 17:52
 * Description: 搜索Controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.controller;

import com.know.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈搜索Controller〉
 *
 * @author 夕汐
 * @create 2020/5/27
 * @since 1.0.0
 */
@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    @Qualifier("searchServiceImpl")
    private SearchService searchServiceImpl;
    @Autowired
    ServletContext servletContext;

    @RequestMapping("/users")
    public Map<String, Object> queryUsers(String keyword, int extra, int start, int count){
        return searchServiceImpl.query(2, keyword, extra, start, count, 0, servletContext.getRealPath("") + "markdown");
    }

    @RequestMapping("/topics")
    public Map<String, Object> queryTopics(String keyword, int extra, int start, int count){
        return searchServiceImpl.query(1, keyword, extra, start, count, 0, servletContext.getRealPath("") + "markdown");
    }

    @RequestMapping("/questions")
    public Map<String, Object> queryQuestions(String keyword, int extra, int start, int count, int n){
        return searchServiceImpl.query(0, keyword, extra, start, count, n, servletContext.getRealPath("") + "markdown");
    }

    @RequestMapping("/search")
    public Map<String, Object> query(String keyword, int type, int extra, int start, int count, int n){
        return searchServiceImpl.query(type, keyword, extra, start, count, n, servletContext.getRealPath("") + "markdown");
    }
}