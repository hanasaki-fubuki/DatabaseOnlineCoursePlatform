package com.microdream.databaseonlinecourseplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.microdream.databaseonlinecourseplatform.mapper.*;
import com.microdream.databaseonlinecourseplatform.pojo.CourseClick;
import com.microdream.databaseonlinecourseplatform.pojo.FilePojo;
import com.microdream.databaseonlinecourseplatform.pojo.SystemLog;
import com.microdream.databaseonlinecourseplatform.pojo.User;
import com.microdream.databaseonlinecourseplatform.pojo.response.CourseHeat;
import com.microdream.databaseonlinecourseplatform.pojo.response.DashboardCounter;
import com.microdream.databaseonlinecourseplatform.service.DashboardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hanasaki_Fubuki
 */
@Service
@Resource
public class DashBoardServiceImpl implements DashboardService {

    @Resource
    SystemLogMapper systemLogMapper;

    @Resource
    CourseClickMapper courseClickMapper;

    @Resource
    CourseHeatMapper courseHeatMapper;

    @Resource
    FilePojoMapper filePojoMapper;

    @Resource
    UserMapper userMapper;

    @Override
    public List<SystemLog> getFileUploadLog() {
        QueryWrapper<SystemLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("event", "File \"" + "%" + "\" Successfully Uploaded");
        return systemLogMapper.selectList(queryWrapper);
    }

    @Override
    public List<CourseHeat> getCourseHeat() {
        Long click;
        for (int i = 1; i <= 30; i++) {
            QueryWrapper<CourseHeat> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", i);
            CourseHeat courseHeat = courseHeatMapper.selectOne(queryWrapper);
            QueryWrapper<CourseClick> queryWrapperClick = new QueryWrapper<>();
            queryWrapperClick.eq("chapter_name", courseHeat.getChapterName());
            click = courseClickMapper.selectCount(queryWrapperClick);
            int intClick = click.intValue();
            courseHeat.setHeatLabel("点击量：" + click);
            if (intClick >= 80) {
                if (intClick >= 100) {
                    courseHeat.setHeatValue(100);
                } else {
                    courseHeat.setHeatValue(intClick);
                }
                courseHeat.setHeatStatus("exception");
            } else {
                courseHeat.setHeatValue(intClick);
                courseHeat.setHeatStatus("normal");
            }
            courseHeatMapper.updateById(courseHeat);
        }
        QueryWrapper<CourseHeat> qw = new QueryWrapper<>();
        qw.orderByDesc("heat_value");
        return courseHeatMapper.selectList(qw);
    }

    @Override
    public DashboardCounter getTotalClickCount() {
        DashboardCounter dashboardCounter = new DashboardCounter();
        QueryWrapper<CourseClick> queryWrapper = new QueryWrapper<>();
        Long count = courseClickMapper.selectCount(queryWrapper);
        dashboardCounter.setValue(count.intValue());
        dashboardCounter.setTitle("课程总点击量");
        dashboardCounter.setSuffix("次点击");
        return dashboardCounter;
    }

    @Override
    public DashboardCounter getTotalLoginCount() {
        DashboardCounter dashboardCounter = new DashboardCounter();
        QueryWrapper<SystemLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("event", "User Access Successfully Granted").or().eq("event", "High Privilege Account Access Successfully Granted");
        Long count = systemLogMapper.selectCount(queryWrapper);
        dashboardCounter.setValue(count.intValue());
        dashboardCounter.setTitle("用户登录总次数");
        dashboardCounter.setSuffix("次登录");
        return dashboardCounter;
    }

    @Override
    public DashboardCounter getTotalFilesCount() {
        DashboardCounter dashboardCounter = new DashboardCounter();
        QueryWrapper<FilePojo> queryWrapper = new QueryWrapper<>();
        Long count = filePojoMapper.selectCount(queryWrapper);
        dashboardCounter.setValue(count.intValue());
        dashboardCounter.setTitle("当前服务器课程文件数");
        dashboardCounter.setSuffix("条文件记录");
        return dashboardCounter;
    }

    @Override
    public DashboardCounter getTotalUserCount() {
        DashboardCounter dashboardCounter = new DashboardCounter();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Long count = userMapper.selectCount(queryWrapper);
        dashboardCounter.setValue(count.intValue());
        dashboardCounter.setTitle("当前服务器总用户数");
        dashboardCounter.setSuffix("位用户");
        return dashboardCounter;
    }


}
