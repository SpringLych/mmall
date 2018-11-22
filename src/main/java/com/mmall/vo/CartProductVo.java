package com.mmall.vo;

import java.math.BigDecimal;

/**
 * @author LiYingChun
 * @date 2018/11/22
 * 结合产品和购物车的抽象对象
 */
public class CartProductVo {
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer quantity;

    private String productName;
    private String productSubtitle;
    private String productMainImage;

    private BigDecimal productPrice;
    private Integer productStatus;
    private BigDecimal productTotalPrice;
    private Integer productStock;
    private Integer productChecked;

    /**
     * 限制数量的返回结果
     */
    private String limitQuantity;

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductSubtitle() {
        return productSubtitle;
    }

    public String getProductMainImage() {
        return productMainImage;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public BigDecimal getProductTotalPrice() {
        return productTotalPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public Integer getProductChecked() {
        return productChecked;
    }

    public String getLimitQuantity() {
        return limitQuantity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductSubtitle(String productSubtitle) {
        this.productSubtitle = productSubtitle;
    }

    public void setProductMainImage(String productMainImage) {
        this.productMainImage = productMainImage;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public void setProductTotalPrice(BigDecimal productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public void setProductChecked(Integer productChecked) {
        this.productChecked = productChecked;
    }

    public void setLimitQuantity(String limitQuantity) {
        this.limitQuantity = limitQuantity;
    }
}
