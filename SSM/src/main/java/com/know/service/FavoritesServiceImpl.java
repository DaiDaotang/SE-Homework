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

import com.know.dao.FavoritesMapper;
import com.know.pojo.Favorites;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈收藏夹业务实现类〉
 *
 * @author 夕汐
 * @create 2020/5/22
 * @since 1.0.0
 */
public class FavoritesServiceImpl implements FavoritesService{
    private FavoritesMapper favoritesMapper;
    public void setFavoritesMapper(FavoritesMapper favoritesMapper) {
        this.favoritesMapper = favoritesMapper;
    }

    public int insertFavorites(Favorites favorites) {
        return favoritesMapper.insertFavorites(favorites);
    }

    public int emptyFavorites(int favoritesId) {
        return favoritesMapper.emptyFavorites(favoritesId);
    }

    public int deleteFavorites(int[] favoritesIds) {
        return favoritesMapper.deleteFavorites(favoritesIds);
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

    public List<Favorites> queryFavoritesList(int userId) {
        return favoritesMapper.queryFavoritesList(userId);
    }

    public int favour(int favoritesId, int answerId, boolean type) {
        Map<String, Object> map0 = new HashMap<String, Object>();
        map0.put("favoritesId", favoritesId);
        map0.put("answerId", answerId);
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("updateTime", new Date());
        map1.put("contentNumber", type? 1 : -1);
        if(type){
            favoritesMapper.favour(map0);
        }
        else{
            favoritesMapper.unfavour(map1);
        }
        favoritesMapper.updateFavoritesLike(map1);
        return 0;
    }
}