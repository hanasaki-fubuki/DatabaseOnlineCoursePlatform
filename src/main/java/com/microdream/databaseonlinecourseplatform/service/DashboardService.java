package com.microdream.databaseonlinecourseplatform.service;

import com.microdream.databaseonlinecourseplatform.pojo.SystemLog;
import com.microdream.databaseonlinecourseplatform.pojo.CourseHeat;
import com.microdream.databaseonlinecourseplatform.pojo.response.DashboardCounter;

import java.util.List;

/**
 * @author Hanasaki_Fubuki
 */
public interface DashboardService {

    /**
     * 获取用户登录日志
     * @return 获取文件上传日志
     */
    List<SystemLog> getFileUploadLog();

    /**
     * 获取课程热度
     * @return 课程热度列表
     */
    List<CourseHeat> getCourseHeat();

    /**
     * 获取总点击量
     * @return 包含总点击量的DashboardCounter对象
     */
    DashboardCounter getTotalClickCount();

    /**
     * 获取总登录次数
     * @return 包含总登录次数的DashboardCounter对象
     */
    DashboardCounter getTotalLoginCount();

    /**
     * 获取总课程文件数
     * @return 包含总课程文件数的DashboardCounter对象
     */
    DashboardCounter getTotalFilesCount();

    /**
     * 获取总用户数
     * @return 包含总用户数的DashboardCounter对象
     */
    DashboardCounter getTotalUserCount();

}
