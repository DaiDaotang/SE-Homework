/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Favorites
 * Author:   夕汐
 * Date:     2020/5/22 11:56
 * Description: 收藏夹
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
 * 〈收藏夹〉
 *
 * @author 夕汐
 * @create 2020/5/22
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favorites {
    private int favoritesId;
    private int userId;
    private String favoritesName;
    private Date updateTime;
    private int contentNumber;
}