/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LikeController
 * Author:   夕汐
 * Date:     2020/5/26 17:11
 * Description: 点赞控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.controller;

import com.know.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈点赞控制器〉
 *
 * @author 夕汐
 * @create 2020/5/26
 * @since 1.0.0
 */
@RestController
@RequestMapping("/like")
public class LikeController {
    @Autowired
    @Qualifier("likeServiceImpl")
    private LikeService likeService;
    public void setLikeService(LikeService likeService) {
        this.likeService = likeService;
    }

    @RequestMapping("/answer")
    public String likeAnswer(int userId, int answerId, boolean type){
        return likeService.likeAnswer(userId, answerId, type) == 1? "OK" : "ERR";
    }

    @RequestMapping("/comment")
    public String likeComment(int userId, int answerId, boolean type){
        return likeService.likeComment(userId, answerId, type) == 1? "OK" : "ERR";
    }
}