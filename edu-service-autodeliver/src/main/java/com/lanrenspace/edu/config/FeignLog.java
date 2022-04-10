package com.lanrenspace.edu.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@Configuration
public class FeignLog {


    /**
     * 配置feign的日志级别
     *
     * @return
     */
    @Bean
    Logger.Level feignLevel() {
        return Logger.Level.FULL;
    }
}
