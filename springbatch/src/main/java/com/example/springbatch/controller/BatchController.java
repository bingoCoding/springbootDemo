package com.example.springbatch.controller;

import com.example.springbatch.service.ScheduledTaskService;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BatchController {

    @Resource
    private ScheduledTaskService scheduledTaskService;

    @RequestMapping("/batch")
    public String batch(String fileName){
        try {
            scheduledTaskService.executeBatch(fileName);
            return "ok";
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        }
        return "fail";
    }
}
