/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Answer
 * Author:   夕汐
 * Date:     2020/5/23 12:08
 * Description: 回答
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈回答〉
 *
 * @author 夕汐
 * @create 2020/5/23
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    private int answerId;
    private int answerQuestionId;
    private int answererId;
    private String answerContent;
    private int answerCollected;
    private int answerLiked;
    private Date answerTime;
}