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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @param start 开始项
     * @param count 数量
     * @param <T>   List中的对象类型
     * @return      切割后的list
     */
    public static <T> List<T> cutList(List<T> list, int start, int count){
        // 若列表为空
        if(list == null){
            return null;
        }
        int size = list.size();
        // 越界
        if(start > size){
            return null;
        }
        // 最后一个在size前
        if(start + count < size){
            return list.subList(start, start + count);
        }
        // 最后一个越界
        else{
            return list.subList(start, size);
        }
    }

    /**
     * 将切割的列表，和原查询结果的总数量放入 Map
     * @param list      需要切割的列表
     * @param start     开始项
     * @param count     数量
     * @param <T>       列表泛型
     * @return          Map
     */
    public static <T> Map<String, Object> queryResult(List<T> list, int start, int count){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", cutList(list, start, count));
        map.put("total", list.size());
        return map;
    }
}