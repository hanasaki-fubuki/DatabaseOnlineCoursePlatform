package com.microdream.databaseonlinecoursespringbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.microdream.databaseonlinecoursespringbackend.pojo.SystemLog;

/**
 * @author Hanasaki_Fubuki
 */
public interface SystemLogService extends IService<SystemLog> {

    /**
     * 添加用户登录成功日志
     * @param uid 用户id
     */
    void userSignInSuccess(int uid);

    /**
     * 添加用户登录失败日志
     * @param uid 用户id
     */
    void userSignInFailed(int uid);

    /**
     * 添加用户密码更改成功日志
     * @param uid 用户id
     */
    void userPassChangedSuccess(int uid);

    /**
     * 添加用户密码更改失败日志
     * @param uid 用户id
     */
    void userPassChangedFailed(int uid);

    /**
     * 添加用户信息更改成功日志
     * @param uid 用户id
     */
    void userProfileChangedSuccess(int uid);

    /**
     * 添加高权限用户登录成功日志
     * @param uid 用户id
     */
    void privilegeSignInSuccess(int uid);

    /**
     * 添加高权限用户登录失败日志
     * @param uid 用户id
     */
    void privilegeSignInFailed(int uid);

    /**
     * 添加高权限用户密码更改成功日志
     * @param uid 用户id
     */
    void privilegePassChangedSuccess(int uid);

    /**
     * 添加高权限用户密码更改失败日志
     * @param uid 用户id
     */
    void privilegePassChangedFailed(int uid);

    /**
     * 添加高权限用户信息更改成功日志
     * @param uid 用户id
     */
    void privilegeProfileChangedSuccess(int uid);

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
