package com.github.xshoji.javasamplebox.springbatch.jobs;

import com.github.xshoji.javasamplebox.springbatch.tasklet.ArgumentTasklet;
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
public class ArgumentJob extends JobBase {

    @Autowired
    private ArgumentTasklet tasklet;

    @Bean
    public Job job2() {
        return jobBuilderFactory
                .get("ArgumentJob")
                .incrementer(new RunIdIncrementer())
                .start(step2())
                .build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get(getClass() + "Step").tasklet(tasklet).build();
    }
}
