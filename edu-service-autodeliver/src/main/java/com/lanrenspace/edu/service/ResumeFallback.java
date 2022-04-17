package com.lanrenspace.edu.service;

import org.springframework.stereotype.Component;

/**
 * @Author lanrenspace@163.com
 * @Description: feign降级回退逻辑，实现FeignClient接口方法
 **/
@Component
public class ResumeFallback implements ResumeServiceFeignClient {

    @Override
    public Integer findDefaultResumeState(Long userId) {
        return -2;
    }
}
