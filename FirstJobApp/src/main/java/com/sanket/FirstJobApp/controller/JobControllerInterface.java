package com.sanket.FirstJobApp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sanket.FirstJobApp.entity.Job;

public interface JobControllerInterface {

    ResponseEntity<List<Job>> getAllJobs();
    ResponseEntity<String> createJobs(Job entity);
    ResponseEntity<Job> getJobById(Long id);
    ResponseEntity<String> deleteJobById(Long id);
    ResponseEntity<String> updatejob(Long id, Job job);
}
