package com.xshoji.springbatchsimplejob.jobs;

import com.xshoji.springbatchsimplejob.tasklet.JobCreationTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JobCreationJob extends JobBase {

  @Autowired
  private JobCreationTasklet tasklet;

  @Bean
  public Job createJobCreationJob() {
    return jobBuilderFactory
            .get("JobCreationJob")
            .incrementer(new RunIdIncrementer())
            .start(createJobCreationJobStep())
            .build();
  }

  @Bean
  public Step createJobCreationJobStep() {
    return stepBuilderFactory.get(getClass() + "Step").tasklet(tasklet).build();
  }
}
