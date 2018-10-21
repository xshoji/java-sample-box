package com.github.xshoji.javasamplebox.springbatch.jobs;

import com.github.xshoji.javasamplebox.springbatch.tasklet.ListJobNamesTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shojinao on 2018/10/21.
 */
@Configuration
public class ListJobNamesJob extends JobBase {

    @Autowired
    private ListJobNamesTasklet tasklet;

    @Bean
    public Job createListJobNamesJob() {
        return jobBuilderFactory
                .get("ListJobNamesJob")
                .incrementer(new RunIdIncrementer())
                .start(createListJobNamesJobStep())
                .build();
    }

    @Bean
    public Step createListJobNamesJobStep() {
        return stepBuilderFactory.get(getClass() + "Step").tasklet(tasklet).build();
    }
}
