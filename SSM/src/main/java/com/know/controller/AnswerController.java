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

import com.know.service.AnswerServiceImpl;
import com.know.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 〈一句话功能简述〉<br> 
 * 〈回答控制器〉
 *
 * @author 夕汐
 * @create 2020/5/23
 * @since 1.0.0
 */
public class AnswerController {
    @Autowired
    @Qualifier("answerServiceImpl")
    private AnswerServiceImpl answerService;
}