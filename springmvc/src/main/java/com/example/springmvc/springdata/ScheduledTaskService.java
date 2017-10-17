package com.example.springmvc.springdata;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ScheduledTaskService {

    private String path="person.cvs";

    @Resource
    JobLauncher jobLauncher;

    @Resource
    Job importJob;

    public JobParameters jobParameters;

    public void execute() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        jobParameters = new JobParametersBuilder()
                .addLong("time",System.currentTimeMillis())
                .addString("input.file.name",path)
                .toJobParameters();
        jobLauncher.run(importJob,jobParameters);
    }
}
