package com.jobapplication.JobApplication.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private IJob iJob;

    public JobController(IJob iJob) {
        this.iJob = iJob;
    }

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return iJob.findAll();
    }

    @PostMapping("/jobs")
    public String createJobs(@RequestBody Job job) {
        iJob.createJobs(job);
        return "Job Added Successfully!";
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id) {
        Job job = iJob.getJobById(id);
        if (job != null)
            return job;

        return new Job(1L, "Software Engineer III", "Developing softwares", "GBP 40000", "GBP 45000", "Cambridgeshire");
    }

}
