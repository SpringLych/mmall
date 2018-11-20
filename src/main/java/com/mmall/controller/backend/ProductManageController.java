package com.mmall.controller.backend;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.pojo.User;
import com.mmall.service.IProductService;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author LiYingChun
 * @date 2018/11/20
 */
@Controller
@RequestMapping("/manage/product")
public class ProductManageController {

    private final IUserService iUserService;
    private final IProductService iProductService;

    @Autowired
    public ProductManageController(IUserService iUserService, IProductService iProductService) {
        this.iUserService = iUserService;
        this.iProductService = iProductService;
    }

    /**
     * 保存商品功能
     */
    @RequestMapping("save.do")
    @ResponseBody
    public ServerResponse productSave(HttpSession session, Product product) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(), "未登录，需要登录");
        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            // 保存商品
            return iProductService.saveOrUpdateProduct(product);
        } else {
            return ServerResponse.createByErrorMsg("无操作权限");
        }
    }

    /**
     * 更改产品销售状态
     */
    @RequestMapping("set_sale_status.do")
    @ResponseBody
    public ServerResponse setSaleStatus(HttpSession session, Integer productId, Integer status) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(), "未登录，需要登录");
        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            // 保存商品
            return iProductService.setSaleStatus(productId, status);
        } else {
            return ServerResponse.createByErrorMsg("无操作权限");
        }
    }
}
