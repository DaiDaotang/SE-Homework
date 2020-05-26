/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FollowController
 * Author:   夕汐
 * Date:     2020/5/26 17:11
 * Description: 关注控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.controller;

import com.know.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈关注控制器〉
 *
 * @author 夕汐
 * @create 2020/5/26
 * @since 1.0.0
 */
@RestController
@RequestMapping("/follow")
public class FollowController {
    @Autowired
    @Qualifier("followServiceImpl")
    private FollowService followService;
    public void setFollowService(FollowService followService) {
        this.followService = followService;
    }
}