package com.sanket.FirstJobApp.Job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.FirstJobApp.Job.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}
