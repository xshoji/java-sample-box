# spring-boot-prometheus

```
// Build
mvn package -Dmaven.test.skip=true

// Boot application
java -jar webapi/target/spring-boot-prometheus-webapi-0.0.1-SNAPSHOT.jar

// Comment
//// Add
curl -H "Content-Type: application/json" localhost:8080/comment/{user}/{message}
//// Get
curl -H "Content-Type: application/json" localhost:8080/comment/{user}
//// GetAll
curl -H "Content-Type: application/json" localhost:8080/comment/

// Prometheus
curl -s -H "Content-Type: text/plain" localhost:8080/prometheus |head -n 3
# HELP jvm_memory_used
# TYPE jvm_memory_used gauge
jvm_memory_used{id="Code Cache",} 1.0875712E7
```
