package com.jobapplication.JobApplication.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJobs(Job job);
}
