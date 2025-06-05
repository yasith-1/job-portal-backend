package edu.icet.jobportal.repository;

import edu.icet.jobportal.entity.CompanyEntity;
import edu.icet.jobportal.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntity, String> {
}
