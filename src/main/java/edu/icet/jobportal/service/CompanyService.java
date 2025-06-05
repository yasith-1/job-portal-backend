package edu.icet.jobportal.service;

import edu.icet.jobportal.dto.Company;
import edu.icet.jobportal.entity.CompanyEntity;
import edu.icet.jobportal.repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    ModelMapper modelMapper;

    private List<Company> companyArrayListList = new ArrayList<>();

    public void addCompany(Company company) {
        CompanyEntity companyEntity = modelMapper.map(company, CompanyEntity.class);
        companyRepository.save(companyEntity);
    }

    public List<Company> getAllCompanyList() {
        List<CompanyEntity> companyEntityList = companyRepository.findAll();
        for (CompanyEntity entity : companyEntityList) {
            companyArrayListList.add(modelMapper.map(entity, Company.class));
        }
        return companyArrayListList;
    }
}
