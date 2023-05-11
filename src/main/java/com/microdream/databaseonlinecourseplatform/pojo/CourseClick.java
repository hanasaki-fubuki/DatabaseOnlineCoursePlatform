package com.microdream.databaseonlinecourseplatform.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author Hanasaki_Fubuki
 */
@Component("courseClick")
@Getter
@Setter
@TableName("course_click")
public class CourseClick {

    int id;

    String chapterName;

}
