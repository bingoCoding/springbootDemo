package com.example.spring.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SchedulerService {

    @Scheduled(fixedRate=5000)
    public void scheduler(){
        System.err.println("fixedRate,time="+ (new SimpleDateFormat()).format(new Date()));
    }

    @Scheduled(cron = "0 37 16 ? * *")
    public void corn(){
        System.err.println("cron,time="+ (new SimpleDateFormat()).format(new Date()));
    }
}
