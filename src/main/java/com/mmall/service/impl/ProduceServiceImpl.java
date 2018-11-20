package com.mmall.service.impl;

import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.dao.ProductMapper;
import com.mmall.pojo.Product;
import com.mmall.service.IProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiYingChun
 * @date 2018/11/20
 */
@Service("iProductService")
public class ProduceServiceImpl implements IProductService {

    private final ProductMapper productMapper;

    @Autowired
    public ProduceServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    /**
     * 添加或更新商品
     *
     * @param product product
     * @return 提示信息
     */
    @Override
    public ServerResponse saveOrUpdateProduct(Product product) {
        if (product != null) {
            if (StringUtils.isNotBlank(product.getSubImages())) {
                // 子图不为空，取第一个子图赋值给主图
                String[] subImageArray = product.getSubImages().split(",");
                if (subImageArray.length > 0) {
                    product.setMainImage(subImageArray[0]);
                }
            }

            // id 不为空，更新产品，否则新增
            if (product.getId() != null) {
                int rowCou = productMapper.updateByPrimaryKey(product);
                if (rowCou > 0) {
                    return ServerResponse.createBySuccess("更新产品成功");
                } else {
                    return ServerResponse.createBySuccess("更新产品失败");
                }
            } else {
                int rowCou = productMapper.insert(product);
                if (rowCou > 0) {
                    return ServerResponse.createBySuccess("新增产品成功");
                } else {
                    return ServerResponse.createBySuccess("新增产品失败");
                }
            }
        }

        return ServerResponse.createByErrorMsg("新增或更新产品参数错误");
    }

    /**
     * 更改产品销售状态
     *
     * @param productId id
     * @param status    st
     * @return 提示信息
     */
    @Override
    public ServerResponse<String> setSaleStatus(Integer productId, Integer status) {
        if (productId == null || status == null) {
            return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Product product = new Product();
        product.setId(productId);
        product.setStatus(status);
        int rowCou = productMapper.updateByPrimaryKeySelective(product);
        if (rowCou > 0) {
            return ServerResponse.createBySuccess("修改商品销售状态成功");
        }

        return ServerResponse.createByErrorMsg("修改商品销售状态失败");
    }
}
