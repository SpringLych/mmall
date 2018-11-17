package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * @author LiYingChun
 * @date 2018/11/17
 */
public interface IUserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String str, String type);

    ServerResponse<String> selectQuestion(String username);

    /**
     * 检查答案与问题是否匹配
     *
     * @param username u
     * @param question q
     * @param answer   a
     * @return 问题答案是否正确
     */
    ServerResponse<String> forgetCheckAnswer(String username, String question, String answer);
}
