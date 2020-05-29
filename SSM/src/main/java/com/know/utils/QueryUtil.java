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

import com.know.pojo.Answer;
import com.know.pojo.Question;

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
        // 若 start 越界
        if(start > size){
            return null;
        }
        // 若 start + count 未越界
        if(start + count < size){
            return list.subList(start, start + count);
        }
        // 若 start + count 越界
        else{
            return list.subList(start, size);
        }
    }

    /**
     * 将切割后的列表，和原查询结果的总数量放入 Map 中
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

    /**
     * 将问题列表中的问题的内容改为其对应的文件的内容的前 n 字
     * @param questions     问题列表
     * @param n             需要显示的字数
     * @param root          根目录
     * @return              修改后的问题列表
     */
    public static List<Question> changeQContent(List<Question> questions, int n, String root){
        String tmp;
        for (Question question : questions) {
            tmp = new util().download(root, question.getQuestionContent());
            question.setQuestionContent((tmp).substring(0, Math.min(n, tmp.length())));
        }
        return questions;
    }

    public static List<Answer> changeAContent(List<Answer> answers, int n, String root){
        String tmp;
        for (Answer answer : answers) {
            tmp = new util().download(root, answer.getAnswerContent());
            answer.setAnswerContent((tmp).substring(0, Math.min(n, tmp.length())));
        }
        return answers;
    }
}