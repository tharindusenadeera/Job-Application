package com.jobapplication.JobApplication.job.Impl;

import com.jobapplication.JobApplication.job.IJob;
import com.jobapplication.JobApplication.job.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @Override
    public boolean deleteJobById(Long id) {
//        for (Job job : jobs) {
//            if (job.getId().equals(id)){
//                jobs.remove(job);
//                return true;
//            }
//        }
        Iterator<Job> iterator = jobs.iterator(); // This method is more efficient and appropriate

        while (iterator.hasNext()){
            Job job  = iterator.next();
            if (job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
//        Iterator<Job> iterator = jobs.iterator(); More appropriate when there is a complex update
//
//        while (iterator.hasNext()){
//            Job job = iterator.next();
//            if (job.getId().equals(id)){
//
//            }
//        }
        for (Job job : jobs){
            if (job.getId().equals(id)){
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;
    }
}
