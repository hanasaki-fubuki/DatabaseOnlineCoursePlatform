package com.microdream.databaseonlinecourseplatform.controller;

import com.microdream.databaseonlinecourseplatform.pojo.SystemLog;
import com.microdream.databaseonlinecourseplatform.pojo.CourseHeat;
import com.microdream.databaseonlinecourseplatform.pojo.response.DashboardCounter;
import com.microdream.databaseonlinecourseplatform.service.DashboardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hanasaki_Fubuki
 */
@RestController
@Slf4j
public class DashboardController {

    @Resource
    DashboardService dashboardService;

    @CrossOrigin
    @RequestMapping(value = "/file-upload-log", method = RequestMethod.POST)
    public List<SystemLog> getFileUploadLog() {
        return dashboardService.getFileUploadLog();
    }

    @CrossOrigin
    @RequestMapping(value = "/course-heat", method = RequestMethod.POST)
    public List<CourseHeat> getCourseHeat() {
        return dashboardService.getCourseHeat();
    }

    @CrossOrigin
    @RequestMapping(value = "/dashboard-counter", method = RequestMethod.POST)
    public List<DashboardCounter> getDashBoardCounter() {
        List<DashboardCounter> dashboardCounterList = new ArrayList<>();
        DashboardCounter totalClickCount = dashboardService.getTotalClickCount();
        DashboardCounter totalLoginsCount = dashboardService.getTotalLoginCount();
        DashboardCounter totalCourseCount = dashboardService.getTotalFilesCount();
        DashboardCounter totalUserCount = dashboardService.getTotalUserCount();
        dashboardCounterList.add(totalClickCount);
        dashboardCounterList.add(totalLoginsCount);
        dashboardCounterList.add(totalCourseCount);
        dashboardCounterList.add(totalUserCount);
        return dashboardCounterList;
    }

}
