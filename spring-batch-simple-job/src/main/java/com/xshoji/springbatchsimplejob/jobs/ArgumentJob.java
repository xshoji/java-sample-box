package com.xshoji.springbatchsimplejob.jobs;

import com.xshoji.springbatchsimplejob.tasklet.ArgumentTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ArgumentJob extends JobBase {

  @Autowired
  private ArgumentTasklet tasklet;

  @Bean
  public Job createArgumentJob() {
    return jobBuilderFactory
            .get("ArgumentJob")
            .incrementer(new RunIdIncrementer())
            .start(createArgumentJobStep())
            .build();
  }

  @Bean
  public Step createArgumentJobStep() {
    return stepBuilderFactory.get(getClass() + "Step").tasklet(tasklet).build();
  }
}
