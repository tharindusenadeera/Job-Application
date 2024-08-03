package com.jobapplication.JobApplication.job;

import java.util.List;

public interface IJob {
    List<Job> findAll();
    void createJobs(Job job);
}
