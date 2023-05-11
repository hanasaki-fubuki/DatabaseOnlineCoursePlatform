package com.microdream.databaseonlinecourseplatform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microdream.databaseonlinecourseplatform.mapper.CourseClickMapper;
import com.microdream.databaseonlinecourseplatform.pojo.CourseClick;
import com.microdream.databaseonlinecourseplatform.service.CourseClickService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Hanasaki_Fubuki
 */
@Service
@Resource
public class CourseClickServiceImpl extends ServiceImpl<CourseClickMapper, CourseClick> implements CourseClickService {

    @Resource
    CourseClick courseClick = new CourseClick();
    @Override
    public void addClick(String chapterName) {
        courseClick.setChapterName(chapterName);
        save(courseClick);
    }
}
