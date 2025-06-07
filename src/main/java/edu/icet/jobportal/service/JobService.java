package edu.icet.jobportal.service;

import edu.icet.jobportal.dto.Job;
import edu.icet.jobportal.dto.JobWithCompanyDTO;
import edu.icet.jobportal.entity.CompanyEntity;
import edu.icet.jobportal.entity.JobEntity;
import edu.icet.jobportal.repository.JobRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    ModelMapper modelMapper = new ModelMapper();

    public Boolean addJob(Job job) {
        job.setJobId(generateId());
        job.setSalaryDate(LocalDate.now());
        JobEntity jobEntity = modelMapper.map(job, JobEntity.class);
        jobRepository.save(jobEntity);

        if (jobRepository.existsById(job.getJobId())) {
            return true;
        }
        return false;
    }

//    public Boolean addJobPost(JobWithCompanyDTO jobpost) {
//        jobpost.setJobId(generateId());
//        JobEntity jobEntity = modelMapper.map(jobpost, JobEntity.class);
//        jobRepository.save(jobEntity);
//
//        if (jobRepository.existsById(jobpost.getJobId())) {
//            return true;
//        }
//        return false;
//    }

    public Boolean updateJob(Job job) {
        job.setSalaryDate(LocalDate.now());
        JobEntity jobEntity = modelMapper.map(job, JobEntity.class);
        jobRepository.save(jobEntity);

        if (jobRepository.existsById(job.getJobId())) {
            return true;
        }
        return false;
    }

    public List<Job> getAllJobList() {
        List<JobEntity> jobEntityList = jobRepository.findAll();
        List<Job> jobArrayListList = new ArrayList<>();
        for (JobEntity entity : jobEntityList) {
            jobArrayListList.add(modelMapper.map(entity, Job.class));
        }
        return jobArrayListList;
    }

    public List<JobWithCompanyDTO> getalljobscompanies() {
        List<Object[]> rows = jobRepository.fetchCustomJobData();
        List<JobWithCompanyDTO> jobs = new ArrayList<>();

        for (Object[] row : rows) {
            String jobId = (String) row[0];
            String title = (String) row[1];
            String description = (String) row[2];
            Double salary = row[3] instanceof Number ? ((Number) row[3]).doubleValue() : null;
            String companyName = (String) row[4];

            JobWithCompanyDTO dto = new JobWithCompanyDTO(jobId, title, description, salary, companyName);
            jobs.add(dto);
        }

        return jobs;
    }

    public Boolean deleteJob(String id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Job searchJob(String id) {
        Optional<JobEntity> optionalEntity = jobRepository.findById(id);
        if (optionalEntity.isPresent()) {
            return modelMapper.map(optionalEntity.get(), Job.class);
        }
        return null;
    }

    private String generateId() {
        List<JobEntity> alljobs = jobRepository.findAll();

        if (alljobs.isEmpty()) {
            return "J001";
        }
        int max = 0;

        for (JobEntity job : alljobs) {
            String id = job.getCompanyId();
            if (id != null && id.startsWith("J")) {
                try {
                    int num = Integer.parseInt(id.substring(1));
                    if (num > max) {
                        max = num;
                    }
                } catch (NumberFormatException e) {
                    // Skip malformed IDs
                }
            }
        }

        int newIdNumber = max + 1;
        return String.format("J%03d", newIdNumber); // e.g., C004
    }

}
