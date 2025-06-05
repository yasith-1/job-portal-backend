package edu.icet.jobportal.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Job {
    private String jobId;
    private LocalDate salaryDate;
    private Double salary;
    private String description;
    private String title;
    private String companyId;
}
