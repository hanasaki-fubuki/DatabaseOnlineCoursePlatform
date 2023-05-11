package com.microdream.databaseonlinecourseplatform.pojo.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author Hanasaki_Fubuki
 */

@Component("dashboardCounter")
@Getter
@Setter
public class DashboardCounter {

    private String title;

    private int value;

    private String suffix;

}
