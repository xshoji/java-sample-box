package com.xshoji.webapiaimlessapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootApplication
@EnableWebMvc
@RestController
@RequestMapping("/comments")
public class SpringBootMultiModuleApplication {

  private final ConcurrentMap<String, List<Comment>> commentsMap = new ConcurrentHashMap<>();

  public static class Comment {

    // privateにするとorg.springframework.http.converter.HttpMessageNotWritableExceptionがでるのでpublicにしちゃう
    public String userName;
    public String message;
    public Date createdOn;
    
    public Comment(String userName, String message, Date createdOn) {
      this.userName = userName;
      this.message = message;
      this.createdOn = createdOn;
    }

  }

  public static void main(String[] args) {
    SpringApplication.run(SpringBootMultiModuleApplication.class, args);
  }

  @GetMapping(value = "/", produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  ConcurrentMap<String, List<Comment>> getAll() {
    return commentsMap;
  }

  @GetMapping(value = "/{userName}", produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  List<Comment> get(@PathVariable String userName) {
    if (commentsMap.containsKey(userName)) {
      return commentsMap.get(userName);
    } else {
      return new ArrayList<>();
    }
  }

  @PostMapping(value = "/{userName}/{message}", produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody Comment add(@PathVariable String userName, @PathVariable String message) {
    List<Comment> comments = new ArrayList<>();
    if (commentsMap.containsKey(userName)) {
      comments = commentsMap.get(userName);
    }
    Comment comment = new Comment(userName, message, new Date());
    comments.add(comment);
    commentsMap.put(userName, comments);
    return comment;
  }
}
