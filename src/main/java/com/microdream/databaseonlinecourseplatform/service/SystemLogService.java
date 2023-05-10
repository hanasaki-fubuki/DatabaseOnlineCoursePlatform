package com.microdream.databaseonlinecourseplatform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.microdream.databaseonlinecourseplatform.pojo.SystemLog;

/**
 * @author Hanasaki_Fubuki
 */
public interface SystemLogService extends IService<SystemLog> {

    /**
     * 添加用户登录成功日志
     * @param uid 用户id
     * @param role 用户角色
     */
    void userSignInSuccess(int uid, int role);

    /**
     * 添加用户登录失败日志
     * @param uid 用户id
     * @param role 用户角色
     */
    void userSignInFailed(int uid, int role);

    /**
     * 添加用户密码更改成功日志
     * @param uid 用户id
     * @param role 用户角色
     */
    void userPassChangedSuccess(int uid, int role);

    /**
     * 添加用户密码更改失败日志
     * @param uid 用户id
     * @param role 用户角色
     */
    void userPassChangedFailed(int uid, int role);

    /**
     * 添加用户注册成功日志
     * @param uid 用户id
     */
    void userSignUpSuccess(int uid);

    /**
     * 添加用户名重复日志
     * @param uid 已存在用户名的用户id
     */
    void usernameDuplicate(int uid);

}
