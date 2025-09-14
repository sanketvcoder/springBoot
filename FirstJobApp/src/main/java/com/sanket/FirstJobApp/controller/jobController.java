package com.sanket.FirstJobApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.FirstJobApp.entity.Job;
import com.sanket.FirstJobApp.service.Impl.JobServiceImpl;

@RestController
public class jobController {

    private final JobServiceImpl jobService;

    public jobController(JobServiceImpl jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> getAllJobs() {
        // Logic to retrieve all jobs
        return jobService.findAll();

    }

    @PostMapping("/jobs")
    public String createJobs(@RequestBody Job entity) {
        jobService.createJob(entity);
        return "Job added successfully";
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id) {
        //TODO: process POST request

        return jobService.searchJobById(id);
    }

}
