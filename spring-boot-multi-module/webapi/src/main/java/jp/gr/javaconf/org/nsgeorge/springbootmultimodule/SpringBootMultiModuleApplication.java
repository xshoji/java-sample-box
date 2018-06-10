package jp.gr.javaconf.org.nsgeorge.springbootmultimodule;

import jp.gr.javaconf.org.nsgeorge.springbootmultimodule.domain.entity.Comment;
import jp.gr.javaconf.org.nsgeorge.springbootmultimodule.domain.repository.CommentRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class SpringBootMultiModuleApplication {

    @Autowired
    private CommentRepository commentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultiModuleApplication.class, args);
	}

    /**
     *  - [【Spring Boot入門（5）】RestAPI(POST)を作ってみる | なんちゃってSEの備忘録](https://poppingcarp.com/spring-boot_intro_rest_post/)
     */
    @RequestMapping(value = "/{userId}/{recordId}", method =	 RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    Comment add(@PathVariable Long userId, @PathVariable Long recordId) {
        //  - [Lombok - Qiita](https://qiita.com/yyoshikaw/items/32a96332cc12854ca7a3)
        //  - [Java8の日時APIはとりあえずこれだけ覚えとけ - Qiita](https://qiita.com/tag1216/items/91a471b33f383981bfaa)
        Comment comment = new Comment();
        comment.setRecordId(userId);
        comment.setUserId(recordId);
        Map<String, Object> content = new HashMap<>();
        Map<String, String> content2 = new HashMap<>();
        content2.put("testKey1", "testValue1");
        content.put("testKey1", "testValue1");
        content.put("testKey2", "testValue2");
        content.put("testKey3", "testValue3");
        content.put("testKey4", content2);
        JSONObject json = new JSONObject(content);
        comment.setContentJson(json.toString());
        return commentRepository.saveAndFlush(comment);
    }
}
