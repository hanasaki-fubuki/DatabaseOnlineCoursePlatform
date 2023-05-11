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
            systemLog.setEvent("High Privilege Account Access Successfully Granted");
        } else {
            systemLog.setEvent("User Access Successfully Granted");
        }
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    @Override
    public void userSignInFailed(int uid, int role) {
        systemLog.setUid(uid);
        if (role == 0 || role == 1) {
            systemLog.setEvent("Unauthorized High Privilege Account Login Attempt");
        } else {
            systemLog.setEvent("Unauthorized User Login Attempt");
        }
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    @Override
    public void userPassChangedSuccess(int uid, int role) {
        systemLog.setUid(uid);
        if (role == 0 || role == 1) {
            systemLog.setEvent("High Privilege Account Password Successfully Changed");
        } else {
            systemLog.setEvent("User Password Successfully Changed");
        }
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    @Override
    public void userPassChangedFailed(int uid, int role) {
        systemLog.setUid(uid);
        if (role == 0 || role == 1) {
            systemLog.setEvent("Unauthorized High Privilege Account Password Change Attempt");
        } else {
            systemLog.setEvent("Unauthorized User Password Change Attempt");
        }
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    @Override
    public void userSignUpSuccess(int uid) {
        systemLog.setUid(uid);
        systemLog.setEvent("New Account Successfully Registered");
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    @Override
    public void usernameDuplicate(int uid) {
        systemLog.setUid(uid);
        systemLog.setEvent("Newly Registered Account Duplicated With Existing One");
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    @Override
    public void userElevationSuccess(int uid) {
        systemLog.setUid(uid);
        systemLog.setEvent("User Privilege Successfully Elevated");
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    @Override
    public void userDelevationSuccess(int uid) {
        systemLog.setUid(uid);
        systemLog.setEvent("User Privilege Successfully De-elevated");
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    @Override
    public void fileUploadSuccess(String fileName) {
        systemLog.setUid(-1);
        systemLog.setEvent("File \"" + fileName + "\" Successfully Uploaded");
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    @Override
    public void fileRemoveSuccess(int fileId) {
        systemLog.setUid(-1);
        systemLog.setEvent("File with ID \"" + fileId + "\" Successfully Removed");
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    @Override
    public void problemCreated(int userId) {
        systemLog.setUid(userId);
        systemLog.setEvent("A New Problem Successfully Created");
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    @Override
    public void problemSolved(int userId) {
        systemLog.setUid(userId);
        systemLog.setEvent("A Problem Successfully Solved");
        systemLog.setLogTime(new Date());
        save(systemLog);
    }

    @Override
    public void userRemoveSuccess(int uid) {
        systemLog.setUid(uid);
        systemLog.setEvent("User Successfully Removed");
        systemLog.setLogTime(new Date());
        save(systemLog);
    }
}
