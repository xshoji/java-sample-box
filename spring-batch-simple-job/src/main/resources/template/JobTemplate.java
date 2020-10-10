package com.xshoji.springbatchsimplejob.jobs;

import com.xshoji.springbatchsimplejob.jobs.JobBase;
import com.xshoji.springbatchsimplejob.tasklet.TaskletTemplate;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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
