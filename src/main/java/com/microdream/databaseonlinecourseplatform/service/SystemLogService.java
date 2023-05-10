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

    /**
     * 添加用户提权成功日志
     * @param uid 用户id
     */
    void userElevationSuccess(int uid);

    /**
     * 添加用户降权成功日志
     * @param uid 用户id
     */
    void userDelevationSuccess(int uid);

    /**
     * 添加文件上传成功成功日志
     * @param fileName 文件名
     */
    void fileUploadSuccess(String fileName);

    /**
     * 添加文件删除成功日志
     * @param fileId 文件ID
     */
    void fileRemoveSuccess(int fileId);

    /**
     * 添加新问题添加日志
     * @param userId 用户ID
     */
    void problemCreated(int userId);

    /**
     * 添加问题解决日志
     * @param userId 用户ID
     */
    void problemSolved(int userId);

}
