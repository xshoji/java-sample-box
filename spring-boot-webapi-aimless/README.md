# spring-boot-webapi-aimless

```
# Build and run
mvn clean package -Dmaven.test.skip=true; java -jar spring-boot-webapi-aimless-app/target/spring-boot-webapi-aimless-app-0.0.1-SNAPSHOT.jar



# Add message
$ curl -vvv -L -X POST "localhost:8080/comments/jonathan/hello"; echo
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> POST /comments/jonathan/hello HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.79.1
> Accept: */*
>
* Mark bundle as not supporting multiuse
< HTTP/1.1 201 Created
< Date: Wed, 11 Jan 2023 16:50:53 GMT
< Content-Type: application/json
< Transfer-Encoding: chunked
<
* Connection #0 to host localhost left intact
{"userName":"jonathan","message":"hello","createdOn":1673455853939}



# Get message of user
$ curl -vvv -L -X GET "localhost:8080/comments/jonathan/"; echo
Note: Unnecessary use of -X or --request, GET is already inferred.
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /comments/jonathan/ HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.79.1
> Accept: */*
>
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 OK
< Date: Wed, 11 Jan 2023 16:51:34 GMT
< Content-Type: application/json
< Transfer-Encoding: chunked
<
* Connection #0 to host localhost left intact
[{"userName":"jonathan","message":"hello","createdOn":1673455846852},{"userName":"jonathan","message":"hello","createdOn":1673455853939}]



# Get all messages
$ curl -vvv -L -X GET "localhost:8080/comments/"; echo
Note: Unnecessary use of -X or --request, GET is already inferred.
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /comments/ HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.79.1
> Accept: */*
>
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 OK
< Date: Wed, 11 Jan 2023 16:51:59 GMT
< Content-Type: application/json
< Transfer-Encoding: chunked
<
* Connection #0 to host localhost left intact
{"aaa":[{"userName":"aaa","message":"aaa","createdOn":1673454086613},{"userName":"aaa","message":"bbbbb","createdOn":1673455690453}],"jonathan":[{"userName":"jonathan","message":"hello","createdOn":1673455846852},{"userName":"jonathan","message":"hello","createdOn":1673455853939}]}

```
