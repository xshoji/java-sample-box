# spring-boot-multi-module

```
// Build
mvn package -Dmaven.test.skip=true

// Boot application
java -jar webapi/target/spring-boot-multi-module-webapi-0.0.1-SNAPSHOT.jar

// Add
curl -H "Content-Type: application/json" localhost:8080/comment/{user}/{message}

// Get
curl -H "Content-Type: application/json" localhost:8080/comment/{user}
```
