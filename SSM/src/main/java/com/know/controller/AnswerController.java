/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AnswerController
 * Author:   夕汐
 * Date:     2020/5/23 12:09
 * Description: 回答控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.controller;

import com.know.pojo.Answer;
import com.know.service.AnswerServiceImpl;
import com.know.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈回答控制器〉
 *
 * @author 夕汐
 * @create 2020/5/23
 * @since 1.0.0
 */
@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    @Qualifier("answerServiceImpl")
    private AnswerServiceImpl answerService;

    @RequestMapping("/new")
    public Map<String, Object> insertNewAnswer(int userId, int questionId, String answerContent){
        int res = answerService.insertAnswer(userId, answerContent, questionId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", res > 0? "OK" : "ERR");
        map.put("answerId", res);
        return map;
    }

    @RequestMapping("/modify")
    public Map<String, Object> modifyAnswer(int answerId, String answerContent){
        int res = answerService.updateAnswer(answerId, answerContent);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", res == 1? "OK" : "ERR");
        map.put("answerId", res);
        return map;
    }

    @RequestMapping("/delete")
    public String deleteAnswer(int answerId){
        return answerService.deleteAnswer(answerId) == 1? "OK" : "ERR";
    }

    @RequestMapping("/getAnswerByAnswerId")
    public Answer getAnswerByAnswerId(int answerId){
        return answerService.queryAnswerByAnswerId(answerId);
    }

    @RequestMapping("/getAnswersListByUserId")
    public Map<String, Object> getAnswersListByUserId(int userId, int extra, int start, int count){
        return answerService.queryAnswerListByQUId(userId, -1, extra, start, count);
    }

    @RequestMapping("/getAnswersListByQuestionId")
    public Map<String, Object> getAnswersListByQuestionId(int questionId, int extra, int start, int count){
        return answerService.queryAnswerListByQUId(-1, questionId, extra, start, count);
    }
}