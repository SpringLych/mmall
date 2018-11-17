package com.mmall.controller.portal;

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
 * @date 2018/11/17
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 用户登录
     *
     * @param username u
     * @param password p
     * @param session  s
     * @return O
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session) {
        // service - mybatis -dao
        ServerResponse<User> response = iUserService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    /**
     * 登出功能
     *
     * @param session session
     * @return res
     */
    @RequestMapping(value = "logout.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    /**
     * 注册
     * @param user user
     * @return res
     */
    @RequestMapping(value = "register.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> register(User user){
        return iUserService.register(user);
    }

    /**
     * 校验
     * @param str 值
     * @param type 类型
     * @return res
     */
    @RequestMapping(value = "check_valid.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> checkValid(String str, String type){
        return iUserService.checkValid(str, type);
    }
}
