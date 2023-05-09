package com.microdream.databaseonlinecourseplatform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.microdream.databaseonlinecourseplatform.pojo.User;

/**
 * @author Hanasaki_Fubuki
 */
public interface UserService extends IService<User> {

    /**
     * 通过用户名获取用户id
     * @param username 用户名
     * @return uid
     */
    int getUidByUsername(String username);

    /**
     * 通过用户名获取用户角色
     * @param username 用户名
     * @return 用户角色
     */
    int getRoleByUsername(String username);
    /**
     * 用户登录验证函数
     * @param user 要登录的用户实体
     * @return 登陆成功的用户实体
     */
    User signIn(User user);

    /**
     * 用户注册函数
     * @param user 用户实体
     * @return 注册成功的用户实体
     */
    int signUp(User user);

}
