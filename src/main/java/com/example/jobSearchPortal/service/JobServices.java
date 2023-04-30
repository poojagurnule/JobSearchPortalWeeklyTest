package com.example.jobSearchPortal.service;

import com.example.jobSearchPortal.model.Job;
import com.example.jobSearchPortal.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServices {
    @Autowired
    JobRepo jobRepo;

    public List<Job> getAllJobs() {

        return (List<Job>) jobRepo.findAll();
    }

    public Optional<Job> getJobById(Long id) {
        return jobRepo.findById(id);
    }

    public Job saveJob(Job job) {
        return jobRepo.save(job);
    }

    public List<Job> searchJobs(String title, String description, String companyName, String employerName) {
        return jobRepo.searchJobs(title, description, companyName, employerName);

    }

    public String updateIfExist(Job job) {
        if(jobRepo.existsById(job.getId())){
            jobRepo.save(job);
            return "Updated successfully";
        }
        return "No such job with this JobId to update";
    }


    public String deleteJobById(Long id) {
        if(jobRepo.existsById(id)){
            jobRepo.deleteById(id);
            return "Deleted Successfully";
        }return "NO jobs to delete with this Job id";
    }
}
