package com.microdream.databaseonlinecourseplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.microdream.databaseonlinecourseplatform.mapper.CourseClickMapper;
import com.microdream.databaseonlinecourseplatform.mapper.CourseHeatMapper;
import com.microdream.databaseonlinecourseplatform.mapper.SystemLogMapper;
import com.microdream.databaseonlinecourseplatform.pojo.CourseClick;
import com.microdream.databaseonlinecourseplatform.pojo.SystemLog;
import com.microdream.databaseonlinecourseplatform.pojo.response.CourseHeat;
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


}
