package com.sanket.FirstJobApp.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sanket.FirstJobApp.entity.Job;
import com.sanket.FirstJobApp.repository.Impl.JobRepositoryImpl;

@Service
public class JobServiceImpl {

    private final JobRepositoryImpl jobRepository;

    public JobServiceImpl(JobRepositoryImpl jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Job createJob(Job job) {
        return jobRepository.createJobs(job);
    }

}
