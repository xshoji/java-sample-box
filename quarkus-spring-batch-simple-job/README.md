# quarkus spring-batch sample

## Usage

```
// Build
mvn package -Dmaven.test.skip=true

// Execute job
java -jar target/quarkus-spring-batch-simple-job-0.0.1-SNAPSHOT.jar --spring.batch.job.names=EchoJob --name=xshoji
```
