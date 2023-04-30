package com.example.jobSearchPortal.controller;

import com.example.jobSearchPortal.model.Job;
import com.example.jobSearchPortal.service.JobServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")

public class JobController {
    @Autowired
    JobServices jobService;

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = (List<Job>) jobService.getAllJobs();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable("id") Long id) {
        Optional<Job> job = jobService.getJobById(id);
        return job.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addJobs")
    public ResponseEntity<Job> createJob(@Valid @RequestBody Job job) {
        Job savedJob = jobService.saveJob(job);
        return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public String updateIfExist(@Valid @RequestBody Job job) {
        return jobService.updateIfExist(job);
    }
    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable("id") Long id) {
      return jobService.deleteJobById(id);

    }

    @GetMapping("/search")
    public ResponseEntity<List<Job>> searchJobs(@RequestParam(required = false) String title,
                                                @RequestParam(required = false) String description,
                                                @RequestParam(required = false) String companyName,
                                                @RequestParam(required = false) String employerName) {
        List<Job> jobs = jobService.searchJobs(title, description, companyName, employerName);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
}






