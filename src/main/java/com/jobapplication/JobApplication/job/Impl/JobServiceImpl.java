package com.jobapplication.JobApplication.job.Impl;

import com.jobapplication.JobApplication.job.IJob;
import com.jobapplication.JobApplication.job.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements IJob {

    private List<Job> jobs = new ArrayList<>();
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJobs(Job job) {
        jobs.add(job);
    }
}
