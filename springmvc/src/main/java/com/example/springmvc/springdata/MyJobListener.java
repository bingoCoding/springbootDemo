package com.example.springmvc.springdata;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * 监听job执行情况
 */
public class MyJobListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {

    }
}
