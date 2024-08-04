package com.jobapplication.JobApplication.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs") // Class level request mapping
public class JobController {

    private IJob iJob;

    public JobController(IJob iJob) {
        this.iJob = iJob;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(iJob.findAll()); // Can be done like this also
    }

    @PostMapping
    public ResponseEntity<String> createJobs(@RequestBody Job job) {
        iJob.createJobs(job);
        return new ResponseEntity<>("Job Added Successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = iJob.getJobById(id);
        if (job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean deleted = iJob.deleteJobById(id);

        if (deleted)
            return new ResponseEntity<>("Successfully Deleted !", HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
   // @RequestMapping(value = "/jobs/", method = RequestMethod.PUT) method level request mapping
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job){
        boolean updated = iJob.updateJobById(id, job);

        if (updated)
            return new ResponseEntity<>("Successfully updated !", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
