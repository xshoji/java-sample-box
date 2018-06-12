package jp.gr.javaconf.org.nsgeorge.springbootmultimodule;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jp.gr.javaconf.org.nsgeorge.springbootmultimodule.domain.entity.Comment;
import jp.gr.javaconf.org.nsgeorge.springbootmultimodule.domain.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/comment")
public class SpringBootMultiModuleApplication {

    @Autowired
    private CommentRepository commentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultiModuleApplication.class, args);
	}

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    List<Comment> get() {
        return commentRepository.findAll();
    }

    /**
     *  - [【Spring Boot入門（5）】RestAPI(POST)を作ってみる | なんちゃってSEの備忘録](https://poppingcarp.com/spring-boot_intro_rest_post/)
     */
    @RequestMapping(value = "/{message}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    Comment add(@PathVariable String message) {
        //  - [Lombok - Qiita](https://qiita.com/yyoshikaw/items/32a96332cc12854ca7a3)
        //  - [Java8の日時APIはとりあえずこれだけ覚えとけ - Qiita](https://qiita.com/tag1216/items/91a471b33f383981bfaa)
        Comment comment = new Comment();
        Map<String, Object> content = new HashMap<>();
        Map<String, String> content2 = new HashMap<>();
        content.put("message", message);
        content2.put("key", "value");
        content.put("details", content2);
        ObjectMapper mapper = new ObjectMapper();
        try {
            comment.setMessage(mapper.writeValueAsString(content));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return commentRepository.saveAndFlush(comment);
    }
}
