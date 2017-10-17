package com.example.springbatch.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * 监听job执行情况
 */
public class MyJobListener implements JobExecutionListener {

    private Long startTime;
    private Long endTime;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime=System.currentTimeMillis();
        System.out.println("批处理执行开始。。。");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime=System.currentTimeMillis();
        System.out.println("批处理结束，用时："+(startTime-endTime)+"ms");
    }
}
