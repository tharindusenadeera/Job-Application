package com.jobapplication.JobApplication.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(iJob.findAll()); // Can be done like this also
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJobs(@RequestBody Job job) {
        iJob.createJobs(job);
        return new ResponseEntity<>("Job Added Successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = iJob.getJobById(id);
        if (job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean deleted = iJob.deleteJobById(id);

        if (deleted) {
            return new ResponseEntity<>("Successfully Deleted !", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
