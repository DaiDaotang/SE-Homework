/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FavoritesServiceImpl
 * Author:   夕汐
 * Date:     2020/5/22 15:42
 * Description: 收藏夹业务实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.service;

import com.know.dao.AnswerMapper;
import com.know.dao.FavoritesMapper;
import com.know.dao.UserMapper;
import com.know.pojo.Favorites;
import com.know.utils.QueryUtil;

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈收藏夹业务实现类〉
 *
 * @author 夕汐
 * @create 2020/5/22
 * @since 1.0.0
 */
public class FavoritesServiceImpl implements FavoritesService{
    // 收藏夹
    private FavoritesMapper favoritesMapper;
    public void setFavoritesMapper(FavoritesMapper favoritesMapper) {
        this.favoritesMapper = favoritesMapper;
    }
    // 回答
    private AnswerMapper answerMapper;
    public void setAnswerMapper(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }
    // 用户
    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int insertFavorites(Favorites favorites) {
        return favoritesMapper.insertFavorites(favorites);
    }

    public int deleteFavorites(int[] favoritesIds) {
        int res = 0;
        // 清空所有收藏夹
        for (int favoritesId : favoritesIds) {
            res += emptyFavorites(favoritesId);
        }
        // 删除收藏夹
        res += favoritesMapper.deleteFavorites(favoritesIds);
        return res % (2 * favoritesIds.length) + 1;
    }

    public int updateFavoritesName(int favoritesId, String favoritesName) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("favoritesId", favoritesId);
        map.put("favoritesName", favoritesName);
        return favoritesMapper.updateFavoritesName(map);
    }

    public Favorites queryFavoritesById(int favoritesId) {
        return favoritesMapper.queryFavoritesById(favoritesId);
    }

    public Map<String, Object> queryFavoritesListByUserId(int userId, int start, int count) {
        return QueryUtil.queryResult(favoritesMapper.queryFavoritesListByUserId(userId), start, count);
    }

    /**
     * 使用方法一，调用多个 mapper 改多个表
     * 应使用方法二，调用一个 mapper 改多个表，因为这里不需要从表中获取新的数据
     * @param answerId      回答ID
     * @param answererId    答主ID
     * @param favoritesId   收藏夹ID
     * @param type          true：收藏，false：取消收藏
     * @return              修改的表的数量
     */
    public int favour(int answerId, int answererId, int favoritesId, boolean type) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("favoritesId", favoritesId);
        map.put("answerId", answerId);
        map.put("userId", answererId);
        map.put("updateTime", new Date());
        map.put("contentNumber", type? 1 : -1);
        map.put("answerCollected", type? 1 : -1);

        int res = 0;
        // 修改 favoritescontent 表
        res += type? favoritesMapper.favour(map) : favoritesMapper.unfavour(map);
        // 修改 favorites 表
        res += favoritesMapper.updateFavoritesLike(map);
        // 修改 answer 表
        res += answerMapper.modifyAnswerCollected(map);
        // 修改 user 表
        res += userMapper.modifyCollected(map);
        // 判断是否成功的更改了四个表
        return res % 4 + 1;
    }

    /**
     * 使用方法一，调用多个 mapper 来修改多个表
     * @param favoritesId   收藏夹ID
     * @return              修改数
     */
    public int emptyFavorites(int favoritesId) {
        int res = 0;
        int tmp;
        // 1. 获取该收藏夹中的回答的ID列表
        List<Integer> answerIds = favoritesMapper.queryCollectedAnswerId(favoritesId);
        int size = answerIds.size();
        if(size == 0){
            return 1;
        }
        // 2. 删除 favoritescontent 中的项
        // 3. 更新 answer 中的对应的回答的收藏数
        // 4. 更新 user 中答主的收藏数
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("favoritesId", favoritesId);
        map.put("answerCollected", -1);
        for (int answerId : answerIds) {
            map.put("answerId", answerId);
            // 这一步很重要，不赋值给 tmp 而是直接 put 会报错
            // 虽然我不知道为什么，可能是因为被视为Object而不是Integer
            // Correct:::::::
            tmp = answerMapper.queryAnswererIdByAnswerId(answerId);
            map.put("userId", tmp);
            // Wrong:::::::
            // map.put("userId", answerMapper.queryAnswererIdByAnswerId(answerId));
            res += favoritesMapper.unfavour(map);
            res += answerMapper.modifyAnswerCollected(map);
            res += userMapper.modifyCollected(map);
        }
        // 5. 更新 favorites 中的收藏数与更改时间
        map.put("updateTime", new Date());
        map.put("contentNumber", -size);
        res += favoritesMapper.updateFavoritesLike(map);

        return res % (3 * size + 1) + 1;
    }

    public Map<String, Object> getHostFavoritesIds(int userId, int answerId) {
        List<Integer> idList = favoritesMapper.queryHostFavoritesIdList(userId, answerId);
        return QueryUtil.queryResult(idList, 0, idList.size());
    }

    public Map<String, Object> queryAnswers(int favoritesId, int start, int count) {
        return QueryUtil.queryResult(favoritesMapper.queryFavoritesContent(favoritesId), start, count);
    }
}