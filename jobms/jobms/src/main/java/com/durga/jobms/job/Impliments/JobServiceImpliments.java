package com.durga.jobms.job.Impliments;

import com.durga.jobms.job.Job;
import com.durga.jobms.job.JobRepository;
import com.durga.jobms.job.JobService;
import com.durga.jobms.job.clients.CompanyClient;
import com.durga.jobms.job.clients.ReviewClient;
import com.durga.jobms.job.dto.JobDTO;
import com.durga.jobms.job.external.Company;
import com.durga.jobms.job.external.Review;
import com.durga.jobms.job.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service // it is used to mark a class as a business logic layer bean,making the code organized and letting Spring manage it automatically
public class JobServiceImpliments implements JobService {

    //private List<Job> jobs = new ArrayList<>();

    private JobRepository jobRepository;
//    private Long idManager = 1L;

    @Autowired
    RestTemplate restTemplate;
    private CompanyClient companyClient;
    private ReviewClient reviewClient;

    public JobServiceImpliments(JobRepository jobRepository,CompanyClient companyClient,ReviewClient reviewClient){
        this.jobRepository = jobRepository;
        this.companyClient = companyClient;
        this.reviewClient = reviewClient;
    }

    @Override
    public List<JobDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
//        List<JobWithCompanyDTO> jobWithCompanyDTOs = new ArrayList<>();
//        for(Job job : jobs){
//            jobWithCompanyDTOs.add(convertToDto(job));
//        }
//        return jobWithCompanyDTOs;
        return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private JobDTO convertToDto(Job job){
//        RestTemplate restTemplate = new RestTemplate();
//        Company company = restTemplate.getForObject("http://companyms:8081/companies/"+job.getCompanyId(), Company.class);
        Company company = companyClient.getCompany(job.getCompanyId());
//        ResponseEntity<List<Review>> reviewResponse =  restTemplate.exchange("http://reviewms:8083/reviews?companyId="+job.getCompanyId(), HttpMethod.GET,null,new ParameterizedTypeReference<List<Review>>(){});
        List<Review> reviews = reviewClient.getReviews(job.getCompanyId());
//        List<Review> reviews = reviewResponse.getBody();
        JobDTO jobDTO = JobMapper.mapToJobWithCompany(job,company,reviews);
        return jobDTO;
    }

    @Override
    public void createJob(Job job) {
//        job.setId(idManager++);
        jobRepository.save(job);
    }

    @Override
    public JobDTO findJobById(Long id) {
        Job job =  jobRepository.findById(id).orElse(null);
        return convertToDto(job);
    }

    @Override
    public Boolean deleteJobById(Long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
