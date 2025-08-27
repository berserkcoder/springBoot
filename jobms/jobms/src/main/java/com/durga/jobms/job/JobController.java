package com.durga.jobms.job;

import com.durga.jobms.job.dto.JobDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // It is used to create RESTful web services. tells Spring to return the method result directly as HTTP response, usually JSON/XML
@RequestMapping("/jobs") // sets a overall /jobs for this particular class
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

//    @GetMapping("/jobs")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<JobDTO>> findAll(){
        return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}") // maps HTTP get request to a method
    public ResponseEntity<JobDTO> findJobById(@PathVariable Long id){
        JobDTO jobDTO =  jobService.findJobById(id);
        if(jobDTO == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(jobDTO,HttpStatus.OK);
    }

    @PostMapping("") // maps HTTP post request to a method
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}") // maps HTTP delete request to a method
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        Boolean deleted = jobService.deleteJobById(id);
//        Use ans = new Use(job,"Job has been deleted");
        if(deleted) {
//            ans.message = "Job doesnot exist";
            return new ResponseEntity<>("Job deleted successfully",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("job doesnt exist or unable to delete",HttpStatus.OK);
    }

    @PutMapping("/{id}") // maps HTTP put request to a method
    public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id,updatedJob);
        if(updated) return new ResponseEntity<>("Job updated Successfully",HttpStatus.OK);
        return new ResponseEntity<>("Job doesnt exist", HttpStatus.NOT_FOUND);
    }
}
