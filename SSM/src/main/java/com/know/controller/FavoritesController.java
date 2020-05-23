/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FavoritesController
 * Author:   夕汐
 * Date:     2020/5/22 15:42
 * Description: 收藏夹 Controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.controller;

import com.know.pojo.Answer;
import com.know.pojo.Favorites;
import com.know.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈收藏夹 Controller〉
 *
 * @author 夕汐
 * @create 2020/5/22
 * @since 1.0.0
 */
@RestController
@RequestMapping("/favorites")
public class FavoritesController {

    @Autowired
    @Qualifier("favoritesServiceImpl")
    private FavoritesService favoritesService;

    // 新建收藏夹
    @RequestMapping("/newFavorites")
    public Map<String, Object> newFavorites(int userId, String favoritesName){
        Map<String, Object> map = new HashMap<String, Object>();
        Favorites favorites = new Favorites();
        favorites.setUserId(userId);
        favorites.setFavoritesName(favoritesName);
        favorites.setUpdateTime(new Date());
        favorites.setContentNumber(0);
        int res = favoritesService.insertFavorites(favorites);
        map.put("msg", res == 1? "OK" : "ERR");
        map.put("favoritesId", favorites.getFavoritesId());
        return map;
    }

    // 更改收藏夹：名称
    @RequestMapping("/updateFavoritesName")
    public String updateFavoritesName(int favoritesId, String favoritesName){
        int res = favoritesService.updateFavoritesName(favoritesId, favoritesName);
        return res == 1? "OK" : "ERR";
    }

    // 查找收藏夹 by Id
    @RequestMapping("/getFavoritesById")
    public Favorites getFavoritesById(int favoritesId){
        return favoritesService.queryFavoritesById(favoritesId);
    }

    // 查找收藏夹列表 by userId
    @RequestMapping("/getFavoritesByUserId")
    public List<Favorites> getFavoritesByUserId(int userId, int start, int count){
        return favoritesService.queryFavoritesListByUserId(userId, start, count);
    }

    // 收藏/取消收藏
    @RequestMapping("/toFavour")
    public String favourAnswer(int answerId, int answererId, int favoritesId, boolean type){
        return favoritesService.favour(answerId, answererId, favoritesId, type) == 1? "OK" : "ERR";
    }

    // 检测该回答被哪个收藏夹收藏
    // TODO...

    // 获取一个收藏夹内容 by favoritesId
    // TODO...
    @RequestMapping("/getFavoritesContents")
    public List<Answer> getFavoritesContents(int favoritesId, int start, int count){
        return null;
    }

    // 清空收藏夹
    @RequestMapping("/emptyFavorites")
    public String emptyFavorites(int favoritesId){
        return favoritesService.emptyFavorites(favoritesId) == 1? "OK" : "ERR";
    }

    // 删除收藏夹
    // TODO...
    @RequestMapping("/delete")
    public String deleteFavorites(int[] favoritesIds){
        // TODO...
        return "ERR";
    }
}