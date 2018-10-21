package com.github.xshoji.javasamplebox.springbatchsimplejob.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by shojinao on 2018/10/21.
 */
@Component
public class JobCreationTasklet implements Tasklet {

    @Value("${jobName:#{null}}")
    private String jobName;


    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.println("");
        System.out.println("[ JobCreationTasklet ]");
        if (jobName == null) {
            System.out.println("--jobName is required.");
            System.out.println("");
            return RepeatStatus.FINISHED;
        }

        // Get path (Template files and Destinatin files)
        InputStream originalFileJob = this.getClass().getClassLoader().getResourceAsStream("template/JobTemplate.java");
        InputStream originalFileTasklet = this.getClass().getClassLoader().getResourceAsStream("template/TaskletTemplate.java");
        Path destinationFileJob = Paths.get("src/main/java/com/github/xshoji/javasamplebox/springbatch/jobs/" + jobName + "Job.java");
        Path destinationFileTasklet = Paths.get("src/main/java/com/github/xshoji/javasamplebox/springbatch/tasklet/" + jobName + "Tasklet.java");

        // Copy files
        Files.copy(originalFileJob, destinationFileJob);
        Files.copy(originalFileTasklet, destinationFileTasklet);

        // Replace template strings (Job class)
        Charset charset = StandardCharsets.UTF_8;
        String content = new String(Files.readAllBytes(destinationFileJob), charset);
        content = content.replaceAll("JobTemplate", jobName + "Job");
        content = content.replaceAll("TaskletTemplate", jobName + "Tasklet");
        Files.write(destinationFileJob, content.getBytes(charset));

        // Replace template strings (Tasklet class)
        content = new String(Files.readAllBytes(destinationFileTasklet), charset);
        content = content.replaceAll("TaskletTemplate", jobName + "Tasklet");
        Files.write(destinationFileTasklet, content.getBytes(charset));

        System.out.println("");
        return RepeatStatus.FINISHED;
    }
}
