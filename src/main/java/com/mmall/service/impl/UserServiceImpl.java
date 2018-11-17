package com.mmall.service.impl;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.dao.UserMapper;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import com.mmall.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiYingChun
 * @date 2018/11/17
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkUserName(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("用户名不存在");
        }

        //todo 密码登录MD5
        String Md5Password = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.selectLogin(username, Md5Password);
        if (user == null) {
            return ServerResponse.createByErrorMsg("密码错误");
        }

        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功", user);
    }

    @Override
    public ServerResponse<String> register(User user){
        ServerResponse validResponse = this.checkValid(user.getUsername(), Const.USERNAME);
        if (!validResponse.isSuccess()){
            return validResponse;
        }
        validResponse = this.checkValid(user.getEmail(), Const.EMAIL);
        if (!validResponse.isSuccess()){
            return validResponse;
        }

        user.setRole(Const.Role.ROLE_CUSTOMER);
        // MD5加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));

        int resultCount = userMapper.insert(user);
        if (resultCount == 0){
            return ServerResponse.createByErrorMsg("注册失败");
        }
        return ServerResponse.createBySuccess("注册成功");
    }

    @Override
    public ServerResponse<String> checkValid(String str, String type) {
        if (StringUtils.isNotBlank(type)){
            // 开始校验
            // 校检用户名
            if (Const.USERNAME.equals(type)){
                int resultCount = userMapper.checkUserName(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMsg("用户名已存在");
                }
            }
            // 校检邮箱
            if (Const.EMAIL.equals(type)){
                int resultCount = userMapper.checkEmail(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMsg("邮箱已存在");
                }
            }

        }else {
            return ServerResponse.createByErrorMsg("参数错误");
        }
        return ServerResponse.createBySuccess("校验成功");
    }


}
