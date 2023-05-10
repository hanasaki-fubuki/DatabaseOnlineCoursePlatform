package com.microdream.databaseonlinecourseplatform.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author Hanasaki_Fubuki
 */
@Component("problem")
@Getter
@Setter
@TableName("problem_info")
public class ProblemSolution {

    private int id;

    private int uid;
    private String subject;
    private int chapter;
    private String content;
    private String solution;


}
