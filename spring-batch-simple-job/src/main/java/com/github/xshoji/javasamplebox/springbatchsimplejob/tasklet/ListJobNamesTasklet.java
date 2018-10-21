package com.github.xshoji.javasamplebox.springbatchsimplejob.tasklet;

import com.github.xshoji.javasamplebox.springbatchsimplejob.SpringBatchApplication;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.*;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

/**
 * Created by shojinao on 2018/10/21.
 */
@Component
public class ListJobNamesTasklet implements Tasklet {

    @Value("${printDetails:#{false}}")
    private boolean printDetails;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.println("");
        System.out.println("[ ListJobNamesTasklet ]");

        if (printDetails) {
            System.out.println("SpringBatchApplication.class >> " + SpringBatchApplication.class);
            System.out.println("getProtectionDomain >> " + SpringBatchApplication.class.getProtectionDomain());
            System.out.println("getCodeSource >> " + SpringBatchApplication.class.getProtectionDomain().getCodeSource());
            System.out.println("getLocation >> " + SpringBatchApplication.class.getProtectionDomain().getCodeSource().getLocation());
            System.out.println("toURI >> " + SpringBatchApplication.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        }

        String[] uriArray = SpringBatchApplication.class.getProtectionDomain().getCodeSource().getLocation().toURI().toString().split("!");
        String jarPath = uriArray[0].replaceAll("jar:file:", "");
        System.out.println("Current jar file path: " + jarPath);

        System.out.println("");
        System.out.println("Job name list");
        JarFile jarFile = new JarFile(jarPath);
        Collections.list(jarFile.entries()).stream()
                .filter(f -> f.toString().matches("BOOT-INF/classes/.*Job.class"))
                .map(f -> f.toString().replaceAll("BOOT-INF/classes/com/github/xshoji/javasamplebox/springbatchsimplejob/jobs/", " - "))
                .map(f -> f.toString().replaceAll(".class", ""))
                .collect(Collectors.toList())
                .forEach(s -> System.out.println(s));

        System.out.println("");
        return RepeatStatus.FINISHED;
    }

    public Path getApplicationPath(Class<?> cls) throws URISyntaxException {
        ProtectionDomain pd = cls.getProtectionDomain();
        CodeSource cs = pd.getCodeSource();
        URL location = cs.getLocation();
        URI uri = location.toURI();
        Path path = Paths.get(uri);
        return path;
    }
}
