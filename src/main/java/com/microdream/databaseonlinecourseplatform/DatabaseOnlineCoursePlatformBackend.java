package com.microdream.databaseonlinecourseplatform;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hanasaki_Fubuki
 */
@SpringBootApplication
@EnableEncryptableProperties
public class DatabaseOnlineCoursePlatformBackend {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseOnlineCoursePlatformBackend.class, args);
    }

}
