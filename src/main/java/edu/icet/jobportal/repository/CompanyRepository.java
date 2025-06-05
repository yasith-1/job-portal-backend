package edu.icet.jobportal.repository;

import edu.icet.jobportal.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, String> {
}
