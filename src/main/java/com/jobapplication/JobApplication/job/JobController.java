package com.jobapplication.JobApplication.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public String createJobs(@RequestBody Job job){
        iJob.createJobs(job);
        return "Job Added Successfully!";
    }
}
