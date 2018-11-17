package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * @author LiYingChun
 * @date 2018/11/17
 */
public interface IUserService {

    ServerResponse<User> login(String username, String password);
}
