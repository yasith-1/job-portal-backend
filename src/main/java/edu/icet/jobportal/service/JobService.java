package edu.icet.jobportal.service;

import edu.icet.jobportal.dto.Job;
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

    private List<Job> jobArrayListList = new ArrayList<>();

    public Boolean addJob(Job job) {
        job.setSalaryDate(LocalDate.now());
        JobEntity jobEntity = modelMapper.map(job, JobEntity.class);
        jobRepository.save(jobEntity);

        if (jobRepository.existsById(job.getJobId())) {
            return true;
        }
        return false;
    }

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
        for (JobEntity entity : jobEntityList) {
            jobArrayListList.add(modelMapper.map(entity, Job.class));
        }
        return jobArrayListList;
    }

    public Boolean deleteJob(String id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Job searchJob(String id) {
        if (jobRepository.existsById(id)) {
            Optional<JobEntity> entity = jobRepository.findById(id);
            Job job = modelMapper.map(entity, Job.class);
            return job;
        }
        return null;
    }
}
