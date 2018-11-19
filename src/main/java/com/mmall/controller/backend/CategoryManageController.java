package com.mmall.controller.backend;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.ICategoryService;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author LiYingChun
 * @date 2018/11/19
 * 分类管理
 */
@Controller
@RequestMapping("/manage/category")
public class CategoryManageController {


    private final IUserService iUserService;
    private final ICategoryService iCategoryService;

    @Autowired
    public CategoryManageController(IUserService iUserService, ICategoryService iCategoryService) {
        this.iUserService = iUserService;
        this.iCategoryService = iCategoryService;
    }

    /**
     * 添加分类
     *
     * @param session      session
     * @param categoryName name
     * @param parentId     父节点， 默认为0
     * @return return
     */
    @RequestMapping(value = "add_category.do")
    @ResponseBody
    public ServerResponse addCategory(HttpSession session, String categoryName,
                                      @RequestParam(value = "parentId", defaultValue = "0") int parentId) {
        // 获取用户，检验是否是管理员
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(), "未登录，需要登录");
        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            return iCategoryService.addCategory(categoryName, parentId);
        } else {
            return ServerResponse.createByErrorMsg("不是管理员，无操作权限");
        }
    }
}
