package com.microdream.databaseonlinecourseplatform.pojo.response;

import com.microdream.databaseonlinecourseplatform.pojo.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author Hanasaki_Fubuki
 */
@Component("changePasswordRequest")
@Getter
@Setter
public class ChangePasswordRequest {
    private User user;
    private String oriPassword;
    private String newPassword;
}
