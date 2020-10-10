# spring-boot-grpc

```
// build
mvn clean package -Dmaven.test.skip=true

// run
java -jar webapi/target/spring-boot-grpc-webapi-0.0.1-SNAPSHOT.jar

// add
grpcurl -plaintext -d '{"message": {"name":"xshoji", "message":"hello", "age":30}}' 0.0.0.0:6565 com.xshoji.springbootgrpc.service.usermessage.UserMessageService/Add

// get
grpcurl -plaintext -d '{"name":"xshoji"}' 0.0.0.0:6565 com.xshoji.springbootgrpc.service.usermessage.UserMessageService/Get
```

> gRPC - Spring Boot Example - CodeNotFound.com  
> https://www.codenotfound.com/grpc-spring-boot-example.html

> grpc-ecosystem/awesome-grpc： A curated list of useful resources for gRPC  
> https://github.com/grpc-ecosystem/awesome-grpc

> yidongnan/grpc-spring-boot-starter： Spring Boot starter module for gRPC framework.  
> https://github.com/yidongnan/grpc-spring-boot-starter

> fullstorydev/grpcurl： Like cURL, but for gRPC： Command-line tool for interacting with gRPC servers  
> https://github.com/fullstorydev/grpcurl


