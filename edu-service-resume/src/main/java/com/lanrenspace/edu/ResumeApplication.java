package com.lanrenspace.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@SpringBootApplication
@EntityScan("com.lanrenspace.edu.entity")
public class ResumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumeApplication.class, args);
    }
}
