package com.xshoji.springbatchsimplejob.jobs;

import com.xshoji.springbatchsimplejob.tasklet.ListJobNamesTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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
