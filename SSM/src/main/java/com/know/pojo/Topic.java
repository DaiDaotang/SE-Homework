/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Topic
 * Author:   夕汐
 * Date:     2020/5/18 17:04
 * Description: 话题
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈话题〉
 *
 * @author 夕汐
 * @create 2020/5/18
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    private int topicId;
    private String topicName;
}