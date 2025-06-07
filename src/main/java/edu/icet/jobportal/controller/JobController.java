package edu.icet.jobportal.controller;

import edu.icet.jobportal.dto.Job;
import edu.icet.jobportal.dto.JobWithCompanyDTO;
import edu.icet.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService service;

    @PostMapping("/add")
    private Boolean add(@RequestBody Job job) {
        return service.addJob(job);
    }

    @PatchMapping("/update")
    private Boolean update(@RequestBody Job job) {
        return service.updateJob(job);
    }

    @GetMapping("/getalljobs")
    private List<Job> getAll() {
        return service.getAllJobList();
    }

    @GetMapping("/getalljobscompanies")
    private List<JobWithCompanyDTO> getalljobscompanies() {
        return service.getalljobscompanies();
    }

//    @PostMapping("/addjobpost")
//    private Boolean addJobPost(@RequestBody JobWithCompanyDTO jobpost) {
//        return service.addJobPost(jobpost);
//    }

    @DeleteMapping("/delete/{id}")
    private Boolean delete(@PathVariable String id) {
        return service.deleteJob(id);
    }

    @GetMapping("/search/{id}")
    private Job getJob(@PathVariable String id) {
        return service.searchJob(id);
    }
}
