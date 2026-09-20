package com.klef.ms.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.ms.job.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}