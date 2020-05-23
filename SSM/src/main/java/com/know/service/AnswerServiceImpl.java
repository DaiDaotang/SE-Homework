/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AnswerServiceImpl
 * Author:   夕汐
 * Date:     2020/5/23 12:08
 * Description: 回答业务实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.service;

import com.know.dao.AnswerMapper;

/**
 * 〈一句话功能简述〉<br> 
 * 〈回答业务实现类〉
 *
 * @author 夕汐
 * @create 2020/5/23
 * @since 1.0.0
 */
public class AnswerServiceImpl implements AnswerService{
    private AnswerMapper answerMapper;
    public void setAnswerMapper(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }
}