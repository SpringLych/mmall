package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

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

    /**
     * 更新分类名称
     *
     * @param categoryId   id
     * @param categoryName name
     * @return 提示信息
     */
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    /**
     * 获取categoryId下的平级信息
     *
     * @param categoryId id
     * @return List形式的category信息
     */
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
}
