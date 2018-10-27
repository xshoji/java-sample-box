package io.github.xshoji.springbootmultimodule;

import io.github.xshoji.springbootmultimodule.domain.repository.CommentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/comment")
public class SpringBootMultiModuleApplication {

    @Autowired
    private CommentRepositoryImpl commentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultiModuleApplication.class, args);
	}

    /**
     *  - [【Spring Boot入門（5）】RestAPI(POST)を作ってみる | なんちゃってSEの備忘録](https://poppingcarp.com/spring-boot_intro_rest_post/)
     */
    @RequestMapping(value = "/{userName}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    List<String> get(@PathVariable String userName) {
        return commentRepository.get(userName);
    }

    /**
     *  - [【Spring Boot入門（5）】RestAPI(POST)を作ってみる | なんちゃってSEの備忘録](https://poppingcarp.com/spring-boot_intro_rest_post/)
     */
    @RequestMapping(value = "/{userName}/{message}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    String add(@PathVariable String userName, @PathVariable String message) {
        commentRepository.add(userName, message);
        return message;
    }
}
