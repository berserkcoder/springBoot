package com.durga.firstjobapp.job;

import  java.util.*;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job findJobById(Long id);
    Boolean deleteJobById(Long id);
    Boolean updateJob(Long id,Job job);
}
