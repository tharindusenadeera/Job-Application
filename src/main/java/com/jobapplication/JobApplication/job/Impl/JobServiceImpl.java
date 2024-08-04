package com.jobapplication.JobApplication.job.Impl;

import com.jobapplication.JobApplication.job.IJob;
import com.jobapplication.JobApplication.job.Job;
import com.jobapplication.JobApplication.job.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JobServiceImpl implements IJob {

    private final JobRepository jobRepository;

//    private List<Job> jobs = new ArrayList<>();
//    private Long nextId = 1L;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJobs(Job job) {
//        job.setId(nextId++);
//        jobs.add(job);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
//        for(Job job : jobs){
//            if (job.getId().equals(id)){
//                return job;
//            }
//        }
//        return null;
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
//        for (Job job : jobs) {
//            if (job.getId().equals(id)){
//                jobs.remove(job);
//                return true;
//            }
//        }
//        Iterator<Job> iterator = jobs.iterator(); // This method is more efficient and appropriate
//
//        while (iterator.hasNext()){
//            Job job  = iterator.next();
//            if (job.getId().equals(id)){
//                iterator.remove();
//                return true;
//            }
//        }
//
//        return false;

        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
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
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            log.info("jobOptional: {}", updatedJob.getMinSalary());
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            log.info("jobOptional - after: {}", job.getMinSalary());
            jobRepository.save(job);
            return true;
        }
//        for (Job job : jobs){
//            if (job.getId().equals(id)){
//                job.setTitle(updatedJob.getTitle());
//                job.setDescription(updatedJob.getDescription());
//                job.setMinSalary(updatedJob.getMinSalary());
//                job.setMaxSalary(updatedJob.getMaxSalary());
//                job.setLocation(updatedJob.getLocation());
//                return true;
//            }
//        }
        return false;
    }
}
