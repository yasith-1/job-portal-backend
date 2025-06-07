package edu.icet.jobportal.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobWithCompanyDTO {
    private String jobId;
    private String title;
    private String description;
    private Double salary;
    private String companyName;

}
