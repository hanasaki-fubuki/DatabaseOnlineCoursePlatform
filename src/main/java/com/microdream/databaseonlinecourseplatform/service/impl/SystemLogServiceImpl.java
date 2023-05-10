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

    @Override
    public void userSignInSuccess(int uid, int role) {
        systemLog.setUid(uid);
        if (role == 0 || role == 1) {
            systemLog.setEventId(5);
        } else {
            systemLog.setEventId(0);
        }
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    @Override
    public void userSignInFailed(int uid, int role) {
        systemLog.setUid(uid);
        if (role == 0 || role == 1) {
            systemLog.setEventId(6);
        } else {
            systemLog.setEventId(1);
        }
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    @Override
    public void userPassChangedSuccess(int uid, int role) {
        systemLog.setUid(uid);
        if (role == 0 || role == 1) {
            systemLog.setEventId(7);
        } else {
            systemLog.setEventId(2);
        }
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    @Override
    public void userPassChangedFailed(int uid, int role) {
        systemLog.setUid(uid);
        if (role == 0 || role == 1) {
            systemLog.setEventId(8);
        } else {
            systemLog.setEventId(3);
        }
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    @Override
    public void userSignUpSuccess(int uid) {
        systemLog.setUid(uid);
        systemLog.setEventId(10);
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    @Override
    public void usernameDuplicate(int uid) {
        systemLog.setUid(uid);
        systemLog.setEventId(11);
        systemLog.setLogTime(new Date());
        save(systemLog);
    }
}
