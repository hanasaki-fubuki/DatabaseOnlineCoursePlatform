package com.microdream.databaseonlinecourseplatform.controller;

import com.microdream.databaseonlinecourseplatform.pojo.SystemLog;
import com.microdream.databaseonlinecourseplatform.pojo.response.CourseHeat;
import com.microdream.databaseonlinecourseplatform.service.DashboardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

}
