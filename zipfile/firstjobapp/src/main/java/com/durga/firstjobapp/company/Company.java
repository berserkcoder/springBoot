package com.durga.firstjobapp.company;

import com.durga.firstjobapp.job.Job;
import com.durga.firstjobapp.reviews.Reviews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    private String company_name;
    private String company_description;
    private String company_location;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

//    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Reviews> review;

    public Company(){

    }



    public Company(Long companyId, String company_name, String company_description, String company_location) {
        this.companyId = companyId;
        this.company_name = company_name;
        this.company_description = company_description;
        this.company_location = company_location;
    }

    public List<Reviews> getReview() {
        return review;
    }

    public void setReview(List<Reviews> review) {
        this.review = review;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_location() {
        return company_location;
    }

    public void setCompany_location(String company_location) {
        this.company_location = company_location;
    }

    public String getCompany_description() {
        return company_description;
    }

    public void setCompany_description(String company_description) {
        this.company_description = company_description;
    }
}
