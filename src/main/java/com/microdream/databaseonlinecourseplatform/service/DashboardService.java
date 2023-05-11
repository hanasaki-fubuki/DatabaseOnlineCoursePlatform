package com.microdream.databaseonlinecourseplatform.service;

import com.microdream.databaseonlinecourseplatform.pojo.SystemLog;
import com.microdream.databaseonlinecourseplatform.pojo.response.CourseHeat;

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

}
