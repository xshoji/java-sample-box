# spring-batch

## Usage

```
// Execute all jobs
java -jar target/spring-batch-0.0.1-SNAPSHOT.jar

// Execute specify job
java -jar target/spring-batch-0.0.1-SNAPSHOT.jar --spring.batch.job.names=EchoJob

// Execute specify job with parameters
java -jar target/spring-batch-0.0.1-SNAPSHOT.jar --spring.batch.job.names=ArgumentJob --name=xshoji
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