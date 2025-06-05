package edu.icet.jobportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "job")
public class JobEntity {
    @Id
    private String jobId;
    private LocalDate salaryDate;
    private Double salary;
    private String description;
    private String title;
    private String companyId;
}
