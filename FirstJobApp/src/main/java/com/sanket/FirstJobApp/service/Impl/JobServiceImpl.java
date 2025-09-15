package com.sanket.FirstJobApp.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sanket.FirstJobApp.ExceptionHandler.JobIdNotFoundEError;
import com.sanket.FirstJobApp.entity.Job;
import com.sanket.FirstJobApp.repository.Impl.JobRepositoryImpl;
import com.sanket.FirstJobApp.service.JobService;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepositoryImpl jobRepository;
    private Long idCounter = 1L;

    public JobServiceImpl(JobRepositoryImpl jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job createJob(Job job) {
        job.setId(idCounter++);
        if (job.getId() == null || job.getTitle() == null || job.getDescription() == null) {
            throw new JobIdNotFoundEError("Job ID, Title, and Description must not be null");
        }
        return jobRepository.createJobs(job);
    }

    @Override
    public Job searchJobById(Long id) {
        return jobRepository.findAll().stream()
                .filter(job -> job.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new JobIdNotFoundEError("Job with ID " + id + " not found"));
    }

    @Override
    public void deletetJob(Long id) {
        if (id == null) {
            throw new JobIdNotFoundEError("Job ID must not be null");
        }
        if (jobRepository.findAll().stream().noneMatch(job -> job.getId().equals(id))) {
            throw new JobIdNotFoundEError("Job with ID " + id + " not found");
        }
        jobRepository.deleteJob(id);
    }

}
