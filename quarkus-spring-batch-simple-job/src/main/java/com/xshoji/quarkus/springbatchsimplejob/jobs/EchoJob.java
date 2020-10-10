package com.xshoji.quarkus.springbatchsimplejob.jobs;

import com.xshoji.quarkus.springbatchsimplejob.tasklet.EchoTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EchoJob extends JobBase {

  @Autowired
  private EchoTasklet tasklet;

  @Bean
  public Job createArgumentJob() {
    return jobBuilderFactory
            .get("EchoJob")
            .incrementer(new RunIdIncrementer())
            .start(createArgumentJobStep())
            .build();
  }

  @Bean
  public Step createArgumentJobStep() {
    return stepBuilderFactory.get(getClass() + "Step").tasklet(tasklet).build();
  }
}
