package edu.icet.jobportal.controller;

import edu.icet.jobportal.dto.Company;
import edu.icet.jobportal.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService service;

    private void add(@RequestBody Company company){
        service.addCompany(company);
    }

    private void getAll(){

    }
}
