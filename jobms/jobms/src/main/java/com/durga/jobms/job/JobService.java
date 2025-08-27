package com.durga.jobms.job;

import com.durga.jobms.job.dto.JobDTO;

import java.util.List;

public interface JobService {
    List<JobDTO> findAll();
    void createJob(Job job);
    JobDTO findJobById(Long id);
    Boolean deleteJobById(Long id);
    Boolean updateJob(Long id,Job job);
}
