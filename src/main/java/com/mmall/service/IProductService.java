package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;

/**
 * @author LiYingChun
 * @date 2018/11/20
 */
public interface IProductService {

    /**
     * 添加或更新商品
     *
     * @param product product
     * @return 提示信息
     */
    ServerResponse saveOrUpdateProduct(Product product);

    /**
     * 更改产品销售状态
     *
     * @param productId id
     * @param status    st
     * @return 提示信息
     */
    ServerResponse<String> setSaleStatus(Integer productId, Integer status);
}
