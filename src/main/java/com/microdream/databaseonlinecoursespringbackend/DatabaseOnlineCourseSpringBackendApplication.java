package com.microdream.databaseonlinecoursespringbackend;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hanasaki_Fubuki
 */
@SpringBootApplication
@EnableEncryptableProperties
public class DatabaseOnlineCourseSpringBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseOnlineCourseSpringBackendApplication.class, args);
    }

}
