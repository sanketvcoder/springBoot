package com.sanket.FirstJobApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.FirstJobApp.entity.Job;

@RestController
public class jobController {

    private List<Job> jobList = new ArrayList<>();

    @GetMapping("/jobs")
    public List<Job> getAllJobs() {
        // Logic to retrieve all jobs
        return jobList;
    }

    @PostMapping("/jobs")
    public String createJobs(@RequestBody Job entity) {
        jobList.add(entity);
        return "Job added successfully";
    }

}
