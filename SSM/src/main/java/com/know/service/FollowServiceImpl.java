/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FollowServiceImpl
 * Author:   夕汐
 * Date:     2020/5/26 17:09
 * Description: 关注业务实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.know.service;

import com.know.dao.FollowMapper;

/**
 * 〈一句话功能简述〉<br> 
 * 〈关注业务实现类〉
 *
 * @author 夕汐
 * @create 2020/5/26
 * @since 1.0.0
 */
public class FollowServiceImpl implements FollowService{
    private FollowMapper followMapper;
    public void setFollowMapper(FollowMapper followMapper) {
        this.followMapper = followMapper;
    }
}