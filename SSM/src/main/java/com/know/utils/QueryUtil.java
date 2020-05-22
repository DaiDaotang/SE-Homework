/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: QueryUtil
 * Author:   夕汐
 * Date:     2020/5/22 21:27
 * Description: 查询工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.utils;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈查询工具类〉
 *
 * @author 夕汐
 * @create 2020/5/22
 * @since 1.0.0
 */
public class QueryUtil {
    /**
     * 切割列表
     * @param list  要切割的列表
     * @param size  列表大小
     * @param start 开始项
     * @param count 数量
     * @param <T>   List中的对象类型
     * @return      切割后的list
     */
    public static <T> List<T> cutList(List<T> list, int size, int start, int count){
        // 若列表为空
        if(list == null){
            return null;
        }
        // 越界
        if(start > size){
            return null;
        }
        // 最后一个在size前
        if(start + count < size){
            list = list.subList(start, start + count);
        }
        // 最后一个越界
        else{
            list = list.subList(start, size);
        }
        return list;
    }
}