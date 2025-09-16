package com.sanket.FirstJobApp.Job.service;

import java.util.List;

import com.sanket.FirstJobApp.Job.entity.Job;

public interface JobService {

    List<Job> findAll();

    Job createJob(Job job);

    Job searchJobById(Long id);

    void deletetJob(Long id);

    boolean updatejob(Long id, Job job);
}
