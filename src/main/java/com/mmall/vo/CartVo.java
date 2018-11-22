package com.mmall.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author LiYingChun
 * @date 2018/11/22
 */
public class CartVo {
    private List<CartProductVo> cartProductVoList;
    private BigDecimal cartTotalPrice;
    private Boolean allChecked;
    private String imageHost;

    public List<CartProductVo> getCartProductVoList() {
        return cartProductVoList;
    }

    public BigDecimal getCartTotalPrice() {
        return cartTotalPrice;
    }

    public Boolean getAllChecked() {
        return allChecked;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setCartProductVoList(List<CartProductVo> cartProductVoList) {
        this.cartProductVoList = cartProductVoList;
    }

    public void setCartTotalPrice(BigDecimal cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    public void setAllChecked(Boolean allChecked) {
        this.allChecked = allChecked;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }
}
