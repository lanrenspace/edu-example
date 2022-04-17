package com.lanrenspace.edu.service;

import com.lanrenspace.edu.entity.Resume;

public interface ResumeService {

    Resume findDefaultResumeByUserId(Long userId);
}
