package com.durga.firstjobapp.job.Impliments;

import com.durga.firstjobapp.job.Job;
import com.durga.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // it is used to mark a class as a bussiness logic layer bean,making the code organized and letting Spring manage it automatically
public class JobServiceImpliments implements JobService {

    private List<Job> jobs = new ArrayList<>();

    private Long idManager = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(idManager++);
        jobs.add(job);
    }

    @Override
    public Job findJobById(Long id) {
        for(Job job : jobs){
            if(job.getId().equals(id)) return job;
        }
        return null;
    }

    @Override
    public Boolean deleteJobById(Long id) {
        for(Job job : jobs){
            if(job.getId().equals(id)) {
//                Job j = job;
                jobs.remove(job);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean updateJob(Long id, Job updatedJob) {
        for(Job job : jobs){
            if(job.getId().equals(id)){
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;
    }
}
