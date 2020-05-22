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
}