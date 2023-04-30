package com.example.jobSearchPortal.repo;

import com.example.jobSearchPortal.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends CrudRepository<Job,Long> {

    @Query("SELECT j FROM Job j WHERE " +
            "(:title IS NULL OR j.title LIKE %:title%) AND " +
            "(:description IS NULL OR j.description LIKE %:description%) AND " +
            "(:companyName IS NULL OR j.companyName LIKE %:companyName%) AND " +
            "(:employerName IS NULL OR j.employerName LIKE %:employerName%)")

    List<Job> searchJobs(String title, String description, String companyName, String employerName);
}