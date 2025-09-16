package com.sanket.FirstJobApp.Job.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sanket.FirstJobApp.Job.ExceptionHandler.JobIdNotFoundEError;
import com.sanket.FirstJobApp.Job.entity.Job;
import com.sanket.FirstJobApp.Job.repository.JobRepository;
import com.sanket.FirstJobApp.Job.service.JobService;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job createJob(Job job) {
        if (job.getTitle() == null || job.getDescription() == null) {
            throw new JobIdNotFoundEError("Job ID, Title, and Description must not be null");
        }
        return jobRepository.save(job);
    }

    @Override
    public Job searchJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new JobIdNotFoundEError("Job with ID " + id + " not found"));
    }

    @Override
    public void deletetJob(Long id) {
        if (id == null) {
            throw new JobIdNotFoundEError("Job ID must not be null");
        } else if (jobRepository.findAll().stream().noneMatch(job -> job.getId().equals(id))) {
            throw new JobIdNotFoundEError("Job with ID " + id + " not found");
        } else {
            jobRepository.deleteById(id);
        }
    }

    @Override
    public boolean updatejob(Long id, Job job) {
        return jobRepository.findById(id).map(existingJob -> {
            existingJob.setTitle(job.getTitle());
            existingJob.setDescription(job.getDescription());
            existingJob.setMinSalary(job.getMinSalary());
            existingJob.setMaxSalary(job.getMaxSalary());
            jobRepository.save(existingJob);
            return true;
        }).orElse(false);
    }
}
