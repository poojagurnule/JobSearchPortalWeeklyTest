package com.example.jobSearchPortal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String location;
    @NotNull
    private Double salary;
    @NotBlank
    private String companyName;
    @NotBlank
    private String employerName;
    @Enumerated(EnumType.STRING)
    private JobType jobType ;

    private LocalDate appliedDate;
}
