package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.vo.CartVo;

/**
 * @author LiYingChun
 * @date 2018/11/22
 */
public interface ICartService {

    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);

    ServerResponse<CartVo> list(Integer userId);

    /**
     * 根据Controller层的参数进行全选或全反选
     */
    ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer productId, Integer checked);

    ServerResponse<Integer> getCartProductCount(Integer userId);
}
