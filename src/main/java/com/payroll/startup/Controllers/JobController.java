package com.payroll.startup.Controllers;

import com.payroll.startup.Models.Job;
import com.payroll.startup.Models.Position;
import com.payroll.startup.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job/")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("all")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("{job_id}")
    public Job getJob(@PathVariable("job_id") Integer jobId) {
        return jobService.getJob(jobId);
    }

    @PostMapping
    public void addJob(@RequestBody Job job) {
        jobService.addJob(job);
    }

    @DeleteMapping("{job_id}")
    public void deleteJob(@PathVariable("job_id") Integer jobId) {
        jobService.deleteJob(jobId);
    }

    @PutMapping("{job_id}")
    public void updateJob(
            @PathVariable("job_id") Integer jobId,
            @RequestBody List<Position> positions
    ) {
        jobService.updateJob(jobId, positions);
    }
}
