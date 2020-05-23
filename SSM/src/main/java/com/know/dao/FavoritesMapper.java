package com.know.dao;

import com.know.pojo.Answer;
import com.know.pojo.Favorites;

import java.util.List;
import java.util.Map;

public interface FavoritesMapper {
    // 新建收藏夹
    int insertFavorites(Favorites favorites);
    // 清空收藏夹
    int emptyFavorites(int favoritesId);
    // 删除收藏夹
    int deleteFavorites(int[] favoritesIds);
    // 更新 favorites：名称
    int updateFavoritesName(Map<String, Object> map);
    // 更新 favorites：收藏/取消收藏时
    int updateFavoritesLike(Map<String, Object> map);
    // 更新 favoritescontent：收藏内容
    int favour(Map<String, Object> map);
    // 更新 favoritescontent：取消收藏
    int unfavour(Map<String, Object> map);
    // 查找收藏夹 by Id
    Favorites queryFavoritesById(int favoritesId);
    // 查找收藏夹列表 by userId
    List<Favorites> queryFavoritesList(int userId);
    // 查找一个收藏夹的内容 by favoritesId
    List<Answer> queryFavoritesContent(int favoritesId);
    // 查找一个收藏夹收藏的回答的ID
    List<Integer> queryCollectedAnswerId(int favoritesId);
}
