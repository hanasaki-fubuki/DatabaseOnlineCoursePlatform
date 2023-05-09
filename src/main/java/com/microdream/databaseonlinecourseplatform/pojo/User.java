package com.microdream.databaseonlinecourseplatform.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author Hanasaki_Fubuki
 */
@Component("user")
@Getter
@Setter
@TableName("user_info")
public class User {

    private int id;
    private String username;
    private String password;
    private int role;
    private String name;
    private int gender;
    private int age;
    private String email;
    private String phone;

}
