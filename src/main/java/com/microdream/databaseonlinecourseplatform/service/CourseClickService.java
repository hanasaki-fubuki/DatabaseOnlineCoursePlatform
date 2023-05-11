package com.microdream.databaseonlinecourseplatform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.microdream.databaseonlinecourseplatform.pojo.CourseClick;

/**
 * @author Hanasaki_Fubuki
 */
public interface CourseClickService extends IService<CourseClick> {

    /**
     * 增加点击量
     * @param chapterName 章节名
     */
    void addClick(String chapterName);

}
