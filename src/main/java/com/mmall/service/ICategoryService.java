package com.mmall.service;

import com.mmall.common.ServerResponse;

/**
 * @author LiYingChun
 * @date 2018/11/19
 */
public interface ICategoryService {

    /**
     * 添加商品分类
     *
     * @param categoryName name
     * @param parentId     父节点
     * @return 提示消息
     */
    ServerResponse addCategory(String categoryName, Integer parentId);
}
