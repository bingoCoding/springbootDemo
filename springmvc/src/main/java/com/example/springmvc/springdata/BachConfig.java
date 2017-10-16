package com.example.springmvc.springdata;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * spring batch是用来处理大量操作的一个框架，主要用来读取大量数据，然后进行一定的处理后，输出成指定的形式
 * 主要组成部分
 * JobRepository 用来注册job的库
 * Joblauncher 用来启动job的接口
 * Job 实际要执行的任务，一个或多个step
 * Step 步骤包括ItemReader  ItemProsessor  ItemWriter
 * ItemReader  读数据接口
 * ItemProsessor  处理数据接口
 * ItemWriter  输出数据接口
 *
 */
@Configuration
@EnableBatchProcessing
public class BachConfig {
    @Bean
    public JobRepository jobRepository(DataSource dataSource, PlatformTransactionManager transactionManager) throws Exception {
        JobRepositoryFactoryBean factoryBean=new JobRepositoryFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTransactionManager(transactionManager);
        factoryBean.setDatabaseType("mysql");
        return factoryBean.getObject();
    }

    @Bean
    public SimpleJobLauncher Joblauncher(DataSource dataSource,PlatformTransactionManager transactionManager) throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository(dataSource,transactionManager));
        return jobLauncher;
    }

    @Bean
    public Job importJob(JobBuilderFactory jobs, Step s){
        return jobs.get("importJob")
                .incrementer(new RunIdIncrementer())
                .flow(s)
                .end()
                .listener(myJobListener())//添加job监听
                .build();
    }

    @Bean
    private JobExecutionListener myJobListener() {
        return new MyJobListener();
    }

    @Bean
    public Step step(StepBuilderFactory stepBuilderFactory,
                     ItemReader reader, ItemProcessor processor, ItemWriter writer){
        return stepBuilderFactory.get("step")
                .chunk(65000)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();

    }

    @Bean
    public ItemReader reader(){
        return null;
    }

    @Bean
    public ItemProcessor processor(){
        return null;
    }

    @Bean
    public ItemWriter writer(DataSource dataSource){
        return null;
    }
}

