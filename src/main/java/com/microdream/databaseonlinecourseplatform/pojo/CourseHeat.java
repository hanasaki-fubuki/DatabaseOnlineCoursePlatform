package com.microdream.databaseonlinecourseplatform.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author Hanasaki_Fubuki
 */

@Component("courseHeatResponse")
@Getter
@Setter
@TableName("course_heat")
public class CourseHeat {

    private int id;

    private String chapterName;
    private String heatLabel;
    private int heatValue;
    private String heatStatus;

}
