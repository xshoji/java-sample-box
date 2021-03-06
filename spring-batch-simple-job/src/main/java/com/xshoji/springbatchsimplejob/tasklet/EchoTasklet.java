package com.xshoji.springbatchsimplejob.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;


@Component
public class EchoTasklet implements Tasklet {
  @Override
  public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
    System.out.println("");
    System.out.println("[ EchoTasklet ]");
    System.out.println("This is " + EchoTasklet.class);

    System.out.println("");
    return RepeatStatus.FINISHED;
  }
}
