# spring-boot-actuator-2.0

```
// Build
$ mvn clean package -Dmaven.test.skip=true

// Boot application
$ java -jar webapi/target/spring-boot-actuator-webapi-0.0.1-SNAPSHOT.jar

// Comment
// Add
$ curl -H "Content-Type: application/json" localhost:8080/comment/xshoji/hello; echo
$ curl -H "Content-Type: application/json" localhost:8080/comment/xshoji/bye; echo
$ curl -H "Content-Type: application/json" localhost:8080/comment/xshoji/welcome; echo
// Get
$ curl -H "Content-Type: application/json" localhost:8080/comment/xshoji |jq
// GetAll
$ curl -H "Content-Type: application/json" localhost:8080/comment/ |jq

// Actuator
$ curl -s -H "Content-Type: application/json" localhost:8080/actuator/health |jq
{
  "status": "UP",
  "components": {
    "diskSpace": {
      "status": "UP",
      "details": {
        "total": 499963174912,
        "free": 228162805760,
        "threshold": 10485760,
        "exists": true
      }
    },
    "ping": {
      "status": "UP"
    }
  }
}
```
