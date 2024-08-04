package com.jobapplication.JobApplication.job.Impl;

import com.jobapplication.JobApplication.job.IJob;
import com.jobapplication.JobApplication.job.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements IJob {

    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJobs(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for(Job job : jobs){
            if (job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }
}
