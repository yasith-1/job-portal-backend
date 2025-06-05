package edu.icet.jobportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "company")
public class CompanyEntity {
    @Id
    private String companyId;
    private String location;
    private String name;
    private String industry;
}
