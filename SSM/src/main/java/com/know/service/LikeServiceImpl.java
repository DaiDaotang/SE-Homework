/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LikeServiceImpl
 * Author:   夕汐
 * Date:     2020/5/26 17:09
 * Description: 点赞业务实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.service;

import com.know.dao.LikeMapper;

/**
 * 〈一句话功能简述〉<br> 
 * 〈点赞业务实现类〉
 *
 * @author 夕汐
 * @create 2020/5/26
 * @since 1.0.0
 */
public class LikeServiceImpl implements LikeService{
    private LikeMapper likeMapper;
    public void setLikeMapper(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;
    }
}