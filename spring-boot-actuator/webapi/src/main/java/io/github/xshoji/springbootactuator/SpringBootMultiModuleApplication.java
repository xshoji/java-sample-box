package io.github.xshoji.springbootactuator;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@SpringBootApplication
@RestController
@RequestMapping("/comment")
public class SpringBootMultiModuleApplication {

    private ConcurrentMap<String, List<Comment>> commentRepository = new ConcurrentHashMap<>();

    @Data
    public class Comment {

        public Comment(Date createdOn){
            this.createdOn = createdOn;
        }

        protected String user;
        protected String message;
        @Getter
        protected Date createdOn;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMultiModuleApplication.class, args);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    ConcurrentMap<String, List<Comment>> getAll() {
        return commentRepository;
    }

    @RequestMapping(value = "/{user}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    List<Comment> get(@PathVariable String user) {
        if (commentRepository.containsKey(user)) {
            return commentRepository.get(user);
        } else {
            return new ArrayList<>();
        }
    }

    /**
     *  - [【Spring Boot入門（5）】RestAPI(POST)を作ってみる | なんちゃってSEの備忘録](https://poppingcarp.com/spring-boot_intro_rest_post/)
     */
    @RequestMapping(value = "/{user}/{message}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    Comment add(@PathVariable String user, @PathVariable String message) {
        List<Comment> comments = new ArrayList<>();
        if (commentRepository.containsKey(user)) {
            comments = commentRepository.get(user);
        }
        Comment comment = new Comment(new Date());
        comment.setUser(user);
        comment.setMessage(message);
        comments.add(comment);
        commentRepository.put(user, comments);
        return comment;
    }
}
