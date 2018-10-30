package io.github.xshoji.springbatch.jobs;

import io.github.xshoji.javasamplebox.springbatch.tasklet.TaskletTemplate;
import io.github.xshoji.springbatchsimplejob.jobs.JobBase;
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
public class JobTemplate extends JobBase {

    @Autowired
    private TaskletTemplate tasklet;

    @Bean
    public Job createJobTemplate() {
        return jobBuilderFactory
                .get("JobTemplate")
                .incrementer(new RunIdIncrementer())
                .start(createJobTemplateStep())
                .build();
    }

    @Bean
    public Step createJobTemplateStep() {
        return stepBuilderFactory.get(getClass() + "Step").tasklet(tasklet).build();
    }
}
