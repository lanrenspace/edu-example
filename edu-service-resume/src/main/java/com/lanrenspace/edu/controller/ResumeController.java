package com.lanrenspace.edu.controller;

import com.lanrenspace.edu.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping("/openState/{userId}")
    public Integer findDefaultResumeState(@PathVariable Long userId) {
        return resumeService.findDefaultResumeByUserId(userId).getIsOpenResume();
    }
}
