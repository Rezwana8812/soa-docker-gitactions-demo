package com.klef.ms.job.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klef.ms.job.entity.Job;
import com.klef.ms.job.service.JobService;

@RestController
@RequestMapping("/job")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/add")
    public Job addJob(@RequestBody Job job) {
        return jobService.addJob(job);
    }

    @GetMapping("/displayall")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/display/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    @PutMapping("/update/{id}")
    public Job updateJob(@PathVariable Long id, @RequestBody Job job) {
        return jobService.updateJob(id, job);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteJob(@PathVariable Long id) {
        return jobService.deleteJob(id);
    }
}