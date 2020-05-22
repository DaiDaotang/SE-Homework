package com.know.service;

import com.know.pojo.Favorites;

import java.util.List;
import java.util.Map;

public interface FavoritesService {
    // 新建话题
    int insertFavorites(Favorites favorites);
    // 清空收藏夹
    int emptyFavorites(int favoritesId);
    // 删除收藏夹
    int deleteFavorites(int[] favoritesIds);
    // 更改收藏夹：名称
    int updateFavoritesName(int favoritesId, String favoritesName);
    // 查找收藏夹 by Id
    Favorites queryFavoritesById(int favoritesId);
    // 查找收藏夹列表 by userId
    List<Favorites> queryFavoritesList(int userId);
    // 查找收藏夹内容 by favoritesId

    // 收藏/取消内容
    int favour(int favoritesId, int answerId, boolean type);
}
