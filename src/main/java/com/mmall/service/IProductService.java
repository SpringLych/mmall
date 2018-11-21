package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

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

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    ServerResponse<PageInfo> searchProduct(String productName, Integer productId,
                                           int pageNum, int pageSize);

    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    /**
     * 根据category id 和关键字搜索
     */
    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId,
                                                         int pageNum, int pageSize, String orderBy);
}
