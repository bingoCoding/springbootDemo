package com.example.springbootintegration.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;

@Configuration
public class SpringIntegration {

    @Value("https://spring.io/blog.atom")
    Resource resource;

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata pollerMetadata(){
        return Pollers.fixedRate(500).get();
    }


}
