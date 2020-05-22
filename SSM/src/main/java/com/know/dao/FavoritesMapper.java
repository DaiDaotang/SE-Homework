package com.know.dao;

import java.util.Map;

public interface FavoritesMapper {
    // 新建收藏夹
    int insertFavorites(Map<String, Object> map);
    // 删除收藏夹
    int deleteFavorites(int favoritesId);
    // 更改收藏夹

    // 查找收藏夹 by Id

    //
}
