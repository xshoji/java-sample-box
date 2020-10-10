# spring-boot-embedded-db

## Boot mode

```
// build
mvn package -Dmaven.test.skip=true

// h2
java -jar webapi/target/spring-boot-embedded-db-webapi-0.0.1-SNAPSHOT.jar

// h2 - mem mode
java -jar -Dspring.profiles.active=h2mem webapi/target/spring-boot-embedded-db-webapi-0.0.1-SNAPSHOT.jar

// HSQLDB
java -jar -Dspring.profiles.active=hsqldb webapi/target/spring-boot-embedded-db-webapi-0.0.1-SNAPSHOT.jar

// Apache Derby
java -jar -Dspring.profiles.active=hsqldb webapi/target/spring-boot-embedded-db-webapi-0.0.1-SNAPSHOT.jar
```

### Endpoint

```
// Add
curl -H "Content-Type: application/json" localhost:8080/comment/{message}?loopCount=10 |jq

// Get
curl -H "Content-Type: application/json" localhost:8080/comment/?limit=10 |jq
```
