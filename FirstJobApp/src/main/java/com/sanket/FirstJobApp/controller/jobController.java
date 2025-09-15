package com.sanket.FirstJobApp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<List<Job>> getAllJobs() {
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);

    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJobs(@RequestBody Job entity) {
        jobService.createJob(entity);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        return new ResponseEntity<>(jobService.searchJobById(id), HttpStatus.OK);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        jobService.deletetJob(id);
        return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updatejob(@PathVariable Long id, @RequestBody Job job) {
        boolean upadate = jobService.updatejob(id, job);
        if (!upadate) {
            return new ResponseEntity<>("Job with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
    }

}
