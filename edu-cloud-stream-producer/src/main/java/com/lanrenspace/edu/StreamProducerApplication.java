package com.lanrenspace.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class StreamProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamProducerApplication.class,args);
    }
}
