package com.lanrenspace.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AutodeliverApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutodeliverApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
