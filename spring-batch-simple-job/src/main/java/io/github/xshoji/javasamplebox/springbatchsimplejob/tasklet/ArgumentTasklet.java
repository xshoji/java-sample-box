package io.github.xshoji.javasamplebox.springbatchsimplejob.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by shojinao on 2018/10/21.
 */
@Component
public class ArgumentTasklet implements Tasklet {

    @Value("${name:#{null}}")
    private String name;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.println("");
        System.out.println("[ ArgumentTasklet ]");
        if (name == null) {
            System.out.println("ERROR: Name is null");
            System.out.println("");
            return RepeatStatus.FINISHED;
        }
        System.out.println("Name: " + name);

        System.out.println("");
        return RepeatStatus.FINISHED;
    }
}
