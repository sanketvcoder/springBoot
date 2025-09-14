package com.sanket.FirstJobApp.repository;

import java.util.List;

import com.sanket.FirstJobApp.entity.Job;

public interface JobRepository {

    List<Job> findAll();

    Job createJobs(Job job);

}
