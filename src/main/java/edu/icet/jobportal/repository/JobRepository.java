package edu.icet.jobportal.repository;

import edu.icet.jobportal.dto.JobWithCompanyDTO;
import edu.icet.jobportal.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository<JobEntity, String> {
    @Query(value = "SELECT j.job_id, j.title, j.description, j.salary, c.name AS company_name " +
            "FROM job j INNER JOIN company c ON j.company_id = c.company_id",
            nativeQuery = true)
    List<Object[]> fetchCustomJobData();


}
