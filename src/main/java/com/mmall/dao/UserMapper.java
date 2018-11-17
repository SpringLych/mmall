package com.mmall.dao;

import com.mmall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    /**
     * 选择性更新，哪个属性不为空就更新哪个
     *
     * @param record User
     * @return 更新成功的记录
     */
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUserName(String username);

    /**
     * MyBatis多个注解使用Param注解
     *
     * @param username u
     * @param password p
     * @return User
     */
    User selectLogin(@Param("username") String username, @Param("password") String password);

    int checkEmail(String email);

    String selectQuestionByUsername(String username);

    int checkAnswer(@Param("username") String username, @Param("question") String question, @Param("answer") String answer);

    int updatePasswordByUsername(@Param("username") String username, @Param("passwordNew") String passwordNew);

    /**
     * 根据用户id和旧密码得到匹配数量，为0说明该用户旧密码错误
     *
     * @param password p
     * @param userId   u
     * @return 匹配数量
     */
    int checkPassword(@Param("password") String password, @Param("userId") Integer userId);
}