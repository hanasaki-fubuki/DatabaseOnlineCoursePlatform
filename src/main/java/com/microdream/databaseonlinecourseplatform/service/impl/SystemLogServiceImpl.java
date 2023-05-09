package com.microdream.databaseonlinecourseplatform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microdream.databaseonlinecourseplatform.pojo.SystemLog;
import com.microdream.databaseonlinecourseplatform.mapper.SystemLogMapper;
import com.microdream.databaseonlinecourseplatform.service.SystemLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Hanasaki_Fubuki
 */
@Service
@Resource
public class SystemLogServiceImpl extends ServiceImpl<SystemLogMapper, SystemLog> implements SystemLogService {

    SystemLog systemLog = new SystemLog();

    /**
     * 添加用户登录成功日志
     * @param uid 用户id
     */
    @Override
    public void userSignInSuccess(int uid) {
        systemLog.setUid(uid);
        if (uid == 0) {
            systemLog.setEventId(5);
        } else {
            systemLog.setEventId(0);
        }
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    /**
     * 添加用户登录失败日志
     * @param uid 用户id
     */
    @Override
    public void userSignInFailed(int uid) {
        systemLog.setUid(uid);
        if (uid == 0) {
            systemLog.setEventId(6);
        } else {
            systemLog.setEventId(1);
        }
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    /**
     * 添加用户修改密码成功日志
     * @param uid 用户id
     */
    @Override
    public void userPassChangedSuccess(int uid) {

    }

    /**
     * 添加用户修改密码失败日志
     * @param uid 用户id
     */
    @Override
    public void userPassChangedFailed(int uid) {

    }

    /**
     * 添加用户修改个人信息成功日志
     * @param uid 用户id
     */
    @Override
    public void userProfileChangedSuccess(int uid) {

    }

    /**
     * 添加高权限用户登录成功日志
     * @param uid 用户id
     */
    @Override
    public void privilegeSignInSuccess(int uid) {

    }

    /**
     * 添加高权限用户登录失败日志
     * @param uid 用户id
     */
    @Override
    public void privilegeSignInFailed(int uid) {

    }

    /**
     * 添加高权限用户修改密码成功日志
     * @param uid 用户id
     */
    @Override
    public void privilegePassChangedSuccess(int uid) {

    }

    /**
     * 添加高权限用户修改密码失败日志
     * @param uid 用户id
     */
    @Override
    public void privilegePassChangedFailed(int uid) {

    }

    /**
     * 添加高权限用户修改个人信息成功日志
     * @param uid 用户id
     */
    @Override
    public void privilegeProfileChangedSuccess(int uid) {

    }

    /**
     * 添加用户注册成功日志
     * @param uid 用户id
     */
    @Override
    public void userSignUpSuccess(int uid) {
        systemLog.setUid(uid);
        systemLog.setEventId(10);
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    /**
     * 添加用户注册失败日志
     * @param uid 已存在用户名的用户id
     */
    @Override
    public void usernameDuplicate(int uid) {
        systemLog.setUid(uid);
        systemLog.setEventId(11);
        systemLog.setLogTime(new Date());
        save(systemLog);
    }
}
