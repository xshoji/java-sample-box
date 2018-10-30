package io.github.xshoji.springbatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

/**
 * Created by shojinao on 2018/10/21.
 */
@Component
public class TaskletTemplate implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.println("");
        System.out.println("[ TaskletTemplate ]");
        System.out.println("This is " + TaskletTemplate.class);

        System.out.println("");
        return RepeatStatus.FINISHED;
    }
}
