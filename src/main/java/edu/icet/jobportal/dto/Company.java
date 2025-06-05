package edu.icet.jobportal.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company {
    private String companyId;
    private String location;
    private String name;
    private String industry;
}
