package com.example.springmvc.sse;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class PushService {

    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getAsynMsg() {
        deferredResult = new DeferredResult<>();
        return deferredResult;
    }

    @Scheduled(fixedRate = 5000)
    public void refresh(){
        if (deferredResult!=null){
            deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
        }
    }
}
