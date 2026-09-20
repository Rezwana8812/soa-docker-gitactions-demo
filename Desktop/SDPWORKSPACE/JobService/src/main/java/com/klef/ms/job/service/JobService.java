package com.klef.ms.job.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klef.ms.job.entity.Job;
import com.klef.ms.job.repository.JobRepository;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    public Job updateJob(Long id, Job job) {

        Job existingJob = jobRepository.findById(id).orElse(null);

        if (existingJob != null) {
            existingJob.setTitle(job.getTitle());
            existingJob.setDescription(job.getDescription());
            existingJob.setCompany(job.getCompany());
            existingJob.setLocation(job.getLocation());
            existingJob.setSkills(job.getSkills());
            existingJob.setSalary(job.getSalary());

            return jobRepository.save(existingJob);
        }

        return null;
    }

    public String deleteJob(Long id) {

        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return "Job deleted successfully";
        }

        return "Job not found";
    }
}