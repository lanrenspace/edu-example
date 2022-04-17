package com.lanrenspace.edu.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
// 设置当前类是Feign客户端,value设置服务提供者名称
@FeignClient(value = "lanrenspace.edu.service.resume", fallback = ResumeFallback.class,path = "/resume")
//@RequestMapping("/resume")
public interface ResumeServiceFeignClient {

    @GetMapping("/openState/{userId}")
    public Integer findDefaultResumeState(@PathVariable("userId") Long userId);
}
