package com.know.dao;

import com.know.pojo.Favorites;

import java.util.List;
import java.util.Map;

public interface FavoritesMapper {
    // 新建收藏夹
    int insertFavorites(Favorites favorites);
    // 删除收藏夹
    int deleteFavorites(int favoritesId);
    // 更改收藏夹
    int updateFavorites(Favorites favorites);
    // 查找收藏夹 by Id
    Favorites queryFavoritesById(int favoritesId);
    // 查找收藏夹列表 by userId
    List<Favorites> queryFavoritesList(int userId);
    // 收藏内容
    int like(Map<String, Object> map);
    // 取消收藏
    int dislike(Map<String, Object> map);
}
