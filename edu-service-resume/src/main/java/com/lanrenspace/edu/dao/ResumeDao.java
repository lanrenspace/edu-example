package com.lanrenspace.edu.dao;

import com.lanrenspace.edu.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public interface ResumeDao extends JpaRepository<Resume, Long> {
}
