package com.example.spring.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

    @Async
    public void executeTask(int i){
        System.err.println("执行异步任务: "+i);
    }

    @Async
    public void executeTaskPlus(int i){
        System.err.println("执行异步任务+1: "+(i+1));
    }

}
