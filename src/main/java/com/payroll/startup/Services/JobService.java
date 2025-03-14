package com.payroll.startup.Services;

import com.payroll.startup.Models.Job;
import com.payroll.startup.Models.Position;
import com.payroll.startup.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJob(Integer jobId) {
        return jobRepository.findById(jobId).orElseThrow(
                () -> new IllegalArgumentException("Job doesn't exist")
        );
    }

    public void addJob(Job job) {
        jobRepository.save(job);
    }

    public void deleteJob(Integer jobId) {
        boolean exists = jobRepository.existsById(jobId);
        if (!exists) throw new IllegalArgumentException("Job doesn't exist.");
        jobRepository.deleteById(jobId);
    }

    public void updateJob(Integer jobId, List<Position> positions) {
        Job job = jobRepository.findById(jobId).orElseThrow(
                () -> new IllegalArgumentException("Job doesn't exist")
        );

        if (positions != null) job.setPositions(positions);
        jobRepository.save(job);
    }
}