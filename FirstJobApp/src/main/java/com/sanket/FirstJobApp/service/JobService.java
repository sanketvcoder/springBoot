package com.sanket.FirstJobApp.service;

import java.util.List;

import com.sanket.FirstJobApp.entity.Job;

public interface JobService {

    List<Job> findAll();

    Job createJob(Job job);

    Job searchJobById(Long id);
}
