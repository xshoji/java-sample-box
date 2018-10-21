# spring-batch

## Usage

```
// Build
mvn package -Dmaven.test.skip=true

// Execute all jobs
java -jar target/spring-batch-0.0.1-SNAPSHOT.jar

// Execute specify job
java -jar target/spring-batch-0.0.1-SNAPSHOT.jar --spring.batch.job.names=EchoJob

// Execute specify job with parameters
java -jar target/spring-batch-0.0.1-SNAPSHOT.jar --spring.batch.job.names=ArgumentJob --name=xshoji
```

## List up job names

```
java -jar target/spring-batch-0.0.1-SNAPSHOT.jar --spring.batch.job.names=ListJobNamesJob
```

## Create new job

```
// Create job template classes
java -jar target/spring-batch-0.0.1-SNAPSHOT.jar --spring.batch.job.names=JobCreationJob --jobName=Something

// Build with generated job
mvn clean package -Dmaven.test.skip=true

// Execute created job
java -jar target/spring-batch-0.0.1-SNAPSHOT.jar --spring.batch.job.names=SomethingJob
```


> java - Spring boot + spring batch without DataSource - Stack Overflow  
> https://stackoverflow.com/questions/39913918/spring-boot-spring-batch-without-datasource

> Spring Batch 3.0うごかす - kagamihogeの日記  
> http://kagamihoge.hatenablog.com/entry/2015/02/14/144238

> making/spring-boot-batch-multi-jobs  
> https://github.com/making/spring-boot-batch-multi-jobs

> Spring Boot - Passing Command Line Arguments Example - Memorynotfound  
> https://memorynotfound.com/spring-boot-passing-command-line-arguments-example/

> java - Can I set null as the default value for a @Value in Spring? - Stack Overflow  
> https://stackoverflow.com/questions/11991194/can-i-set-null-as-the-default-value-for-a-value-in-spring

> How to really read text file from classpath in Java - Stack Overflow  
> https://stackoverflow.com/questions/1464291/how-to-really-read-text-file-from-classpath-in-java

> Get the target directory path in Maven (Java) - Stack Overflow  
> https://stackoverflow.com/questions/38558720/get-the-target-directory-path-in-maven-java

> java - Find and replace words/lines in a file - Stack Overflow  
> https://stackoverflow.com/questions/3935791/find-and-replace-words-lines-in-a-file

> java - How to get the path of a running JAR file? - Stack Overflow  
> https://stackoverflow.com/questions/320542/how-to-get-the-path-of-a-running-jar-file

> Java access files in jar causes java.nio.file.FileSystemNotFoundException - Stack Overflow  
> https://stackoverflow.com/questions/22605666/java-access-files-in-jar-causes-java-nio-file-filesystemnotfoundexception