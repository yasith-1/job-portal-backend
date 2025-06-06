package edu.icet.jobportal.controller;

import edu.icet.jobportal.dto.Company;
import edu.icet.jobportal.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService service;

    @PostMapping("/add")
    private Boolean add(@RequestBody Company company) {
       return service.addCompany(company);
    }

    @PatchMapping("/update")
    private Boolean update(@RequestBody Company company) {
        return service.updateCompany(company);
    }

    @GetMapping("/getall")
    private List<Company> getAll() {
        return service.getAllCompanyList();
    }

    @DeleteMapping("/delete/{id}")
    private Boolean delete(@PathVariable String id) {
        return service.deleteCompany(id);
    }

    @GetMapping("/search/{id}")
    private Company getCompany(@PathVariable String id) {
        return service.searchCompay(id);
    }
}
