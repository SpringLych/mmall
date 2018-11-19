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

    /**
     * 检验用户名的有效性
     *
     * @param str  可以是用户名，email
     * @param type 为username，email
     * @return success：”校验成功“;fail:"已存在"
     */
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

    /**
     * 根据用户名更新密码
     *
     * @param username    u
     * @param passwordNew p
     * @param forgetToken f
     * @return 重置是否成功
     */
    ServerResponse<String> forgetRestPassword(String username, String passwordNew, String forgetToken);

    /**
     * 登录状态修改密码
     *
     * @param passwordOld p
     * @param passwordNew p
     * @param user        user
     * @return 修改密码是否成功的提示信息
     */
    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);

    /**
     * 更新个人信息
     *
     * @param user user
     * @return User 更新是否成功的提示信息
     */
    ServerResponse<User> updateInformation(User user);

    /**
     * 获取个人详细信息
     *
     * @param userId id
     * @return User
     */
    ServerResponse<User> getInformation(Integer userId);
}
