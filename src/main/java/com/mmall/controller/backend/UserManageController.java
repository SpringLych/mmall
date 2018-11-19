package com.mmall.controller.backend;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author LiYingChun
 * @date 2018/11/19
 */

@Controller
@RequestMapping("/manage/user")
public class UserManageController {

    private final IUserService iUserService;

    @Autowired
    public UserManageController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    /**
     * 管理员登录
     *
     * @param username u
     * @param password p
     * @param session s
     * @return User 信息
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session) {
        ServerResponse<User> response = iUserService.login(username, password);
        if (response.isSuccess()){
            User user = response.getData();
            if (user.getRole() == Const.Role.ROLE_ADMIN){
                // 登录的是管理员
                session.setAttribute(Const.CURRENT_USER, user);
                return response;
            }
            else {
                return ServerResponse.createByErrorMsg("登录的不是管理员");
            }

        }
        return response;
    }

}
