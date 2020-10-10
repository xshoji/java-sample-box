package com.xshoji.quarkus.springbatchsimplejob.jobs;

import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public abstract class JobBase {

  @Autowired
  protected JobBuilderFactory jobBuilderFactory;

  @Autowired
  protected StepBuilderFactory stepBuilderFactory;

}
