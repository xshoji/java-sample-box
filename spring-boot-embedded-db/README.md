# spring-boot-embedded-db

## Boot mode

```
$ mvn package

// h2
$ java -jar webapi/target/spring-boot-multi-module-webapi-0.0.1-SNAPSHOT.jar

// h2 - mem mode
$ java -jar -Dspring.profiles.active=h2mem webapi/target/spring-boot-multi-module-webapi-0.0.1-SNAPSHOT.jar

// HSQLDB
$ java -jar -Dspring.profiles.active=hsqldb webapi/target/spring-boot-multi-module-webapi-0.0.1-SNAPSHOT.jar

// Apache Derby
$ java -jar -Dspring.profiles.active=hsqldb webapi/target/spring-boot-multi-module-webapi-0.0.1-SNAPSHOT.jar
```

### Endpoint

```
// Add
$ curl -H "Content-Type: application/json" localhost:8080/comment/{message}?loopCout=10

// Get
$ curl -H "Content-Type: application/json" localhost:8080/comment/?limit=10
```
