package com.know.service;

import com.know.pojo.Favorites;

import java.util.List;
import java.util.Map;

public interface FavoritesService {
    // 新建收藏夹
    int insertFavorites(Favorites favorites);
    // 更改收藏夹：名称
    int updateFavoritesName(int favoritesId, String favoritesName);
    // 查找收藏夹 by Id  应该无用
    Favorites queryFavoritesById(int favoritesId);
    // 查找收藏夹列表 by userId
    List<Favorites> queryFavoritesListByUserId(int userId, int start, int count);
    // 收藏/取消内容
    int favour(int answerId, int answererId, int favoritesId, boolean type);
    // 清空收藏夹
    int emptyFavorites(int favoritesId);
    // 检测被哪个收藏夹收藏
    // TODO...
    // 查找收藏夹内容 by favoritesId
    // TODO...
    // 删除收藏夹
    int deleteFavorites(int[] favoritesIds);
}