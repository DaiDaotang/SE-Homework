/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Question
 * Author:   夕汐
 * Date:     2020/5/26 14:54
 * Description: 问题
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
 * 〈问题〉
 *
 * @author 夕汐
 * @create 2020/5/26
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private int questionId;
    private int questionerId;
    private Date questionTime;
    private String questionTitle;
    private String questionContent;
    private int answerNumber;
    private int browseNumber;
}