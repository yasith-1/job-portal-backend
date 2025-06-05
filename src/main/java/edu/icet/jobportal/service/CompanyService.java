package edu.icet.jobportal.service;

import edu.icet.jobportal.dto.Company;
import edu.icet.jobportal.entity.CompanyEntity;
import edu.icet.jobportal.repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ComponentAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    ModelMapper modelMapper = new ModelMapper();

    private List<Company> companyArrayListList = new ArrayList<>();

    public Boolean addCompany(Company company) {
        CompanyEntity companyEntity = modelMapper.map(company, CompanyEntity.class);
        companyRepository.save(companyEntity);

        if (companyRepository.existsById(company.getCompanyId())) {
            return true;
        }
        return false;
    }

    public List<Company> getAllCompanyList() {
        List<CompanyEntity> companyEntityList = companyRepository.findAll();
        for (CompanyEntity entity : companyEntityList) {
            companyArrayListList.add(modelMapper.map(entity, Company.class));
        }
        return companyArrayListList;
    }

    public Boolean deleteCompany(String id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Company searchCompay(String id) {
        if (companyRepository.existsById(id)) {
            Optional<CompanyEntity> entity = companyRepository.findById(id);
            Company company = modelMapper.map(entity, Company.class);
            return company;
        }
        return null;
    }
}
