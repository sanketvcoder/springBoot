package com.sanket.FirstJobApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.FirstJobApp.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}
