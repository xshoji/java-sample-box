package com.github.xshoji.javasamplebox.springbatch.jobs;

import com.github.xshoji.javasamplebox.springbatch.tasklet.EchoTasklet;
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
public class EchoJob extends JobBase {

    @Autowired
    private EchoTasklet tasklet;

    @Bean
    public Job job1() {
        return jobBuilderFactory
                .get("EchoJob")
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get(getClass() + "Step").tasklet(tasklet).build();
    }
}
