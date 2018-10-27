# spring-boot-actuator-2.0

```
// Build
$ mvn clean package

// Boot application
$ java -jar webapi/target/spring-boot-actuator-webapi-0.0.1-SNAPSHOT.jar

// Comment
//// Add
$ curl -H "Content-Type: application/json" localhost:8080/comment/{user}/{message}
//// Get
$ curl -H "Content-Type: application/json" localhost:8080/comment/{user}
//// GetAll
$ curl -H "Content-Type: application/json" localhost:8080/comment/

// Actuator
$ curl -s -H "Content-Type: application/json" localhost:8080/actuator/health |jq
{
  "status": "UP",
  "details": {
    "diskSpace": {
      "status": "UP",
      "details": {
        "total": 250790436864,
        "free": 166289805312,
        "threshold": 10485760
      }
    }
  }
}
```
