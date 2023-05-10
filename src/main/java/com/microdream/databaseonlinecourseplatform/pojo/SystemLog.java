package com.microdream.databaseonlinecourseplatform.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Hanasaki_Fubuki
 */
@Component("SystemLog")
@Getter
@Setter
@TableName("system_log")
public class SystemLog {
    private int id;
    private int uid;
    private Date logTime;
    private String event;

}
