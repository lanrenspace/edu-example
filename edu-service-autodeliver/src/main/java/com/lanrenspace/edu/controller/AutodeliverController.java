package com.lanrenspace.edu.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@RestController
@RequestMapping("/autodeliver")
public class AutodeliverController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/checkState/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        // 调用lanrenspace.edu.service.resume
        Integer openState = restTemplate.getForObject("http://localhost:8080/resume/openState/" + userId, Integer.class);
        return openState;
    }


    /**
     * 使用Eureka注册中心后的调整
     *
     * @param userId
     * @return
     */
    @GetMapping("/checkState1/{userId}")
    public Integer findResumeOpenState1(@PathVariable Long userId) {
        // 调用lanrenspace.edu.service.resume
        // 获取实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances("lanrenspace.edu.service.resume");
        // 选择一个实例拿到实例信息
        ServiceInstance serviceInstance = instances.get(0);
        // 拼接请求
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/resume/openState/" + userId;
        System.out.println(url);
        Integer openState = restTemplate.getForObject(url, Integer.class);
        return openState;
    }


    /**
     * 使用Ribbon负载均衡
     *
     * @param userId
     * @return
     */
    @GetMapping("/checkState2/{userId}")
    public Integer findResumeOpenState2(@PathVariable Long userId) {
        // 调用lanrenspace.edu.service.resume
        // 拼接请求
        String url = "http://lanrenspace.edu.service.resume/resume/openState/" + userId;
        System.out.println(url);
        Integer openState = restTemplate.getForObject(url, Integer.class);
        return openState;
    }


    /**
     * 使用Hystrix熔断器
     * 配置属性信息：HystrixCommandProperties
     *
     * @param userId
     * @return
     */
    @HystrixCommand(
            // 熔断的属性配置
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "200")
            },
            // 添加仓壁模式，线程池标识,需要唯一
            threadPoolKey = "findResumeOpenState3",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2"),
                    @HystrixProperty(name = "maxQueueSize", value = "20")
            }
    )
    @GetMapping("/checkState3/{userId}")
    public Integer findResumeOpenState3(@PathVariable Long userId) {
        // 调用lanrenspace.edu.service.resume
        // 拼接请求
        String url = "http://lanrenspace.edu.service.resume/resume/openState/" + userId;
        System.out.println(url);
        Integer openState = restTemplate.getForObject(url, Integer.class);
        return openState;
    }


    /**
     * 使用Hystrix熔断器
     * 服务降级
     * 配置属性信息：HystrixCommandProperties
     *
     * @param userId
     * @return
     */
    @HystrixCommand(
            // 熔断的属性配置
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "200")
            }, fallbackMethod = "fallBack",
            // 添加仓壁模式，线程池标识,需要唯一
            threadPoolKey = "findResumeOpenState4",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "1"),
                    @HystrixProperty(name = "maxQueueSize", value = "20")
            }
    )
    @GetMapping("/checkState4/{userId}")
    public Integer findResumeOpenState4(@PathVariable Long userId) {
        // 调用lanrenspace.edu.service.resume
        // 拼接请求
        String url = "http://lanrenspace.edu.service.resume/resume/openState/" + userId;
        System.out.println(url);
        Integer openState = restTemplate.getForObject(url, Integer.class);
        return openState;
    }

    // 定义降级回退方法，返回预设默认值
    // 该方法形参和返回值与原始方法保持一致
    public Integer fallBack(Long userId) {
        return -1;
    }



    /**
     * 使用Hystrix熔断器
     * 服务降级
     * 配置属性信息：HystrixCommandProperties
     * hystrix高级配置,定制工作细节
     * @param userId
     * @return
     */
    @HystrixCommand(
            // 熔断的属性配置
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "200")

                    ,
                    // 统计时间窗口定义
                    @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds",value = "8000"),
                    // 统计时间窗口内的最小请求数
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "2"),
                    // 统计时间窗口内的错误数量百分比阈值
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
                    // 自我修复时的活动窗口长度
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000")
            }, fallbackMethod = "fallBack",
            // 添加仓壁模式，线程池标识,需要唯一
            threadPoolKey = "findResumeOpenState4",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "1"),
                    @HystrixProperty(name = "maxQueueSize", value = "20")
            }
    )
    @GetMapping("/checkState5/{userId}")
    public Integer findResumeOpenState5(@PathVariable Long userId) {
        // 调用lanrenspace.edu.service.resume
        // 拼接请求
        String url = "http://lanrenspace.edu.service.resume/resume/openState/" + userId;
        System.out.println(url);
        Integer openState = restTemplate.getForObject(url, Integer.class);
        return openState;
    }
}
