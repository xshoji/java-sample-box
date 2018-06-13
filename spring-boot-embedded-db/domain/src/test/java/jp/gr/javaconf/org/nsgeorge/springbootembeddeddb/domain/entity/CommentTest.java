package jp.gr.javaconf.org.nsgeorge.springbootembeddeddb.domain.entity;//package com.example.demo.common.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jp.gr.javaconf.org.nsgeorge.springbootembeddeddb.domain.repository.CommentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  - [unit testing - How to test Spring Data repositories? - Stack Overflow](https://stackoverflow.com/questions/23435937/how-to-test-spring-data-repositories)
 *  - [How to clear database in Spring Boot tests? | Bright Inventions](https://brightinventions.pl/blog/clear-database-in-spring-boot-tests/)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CommentTest {

    @Autowired
    private CommentRepository rep;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {
        System.out.println("setUp");
    }


    @After
    public void tearDown() {
        System.out.println("tearDown");
    }

    /**
     *  - [java - JUnit tests always rollback the transactions - Stack Overflow](https://stackoverflow.com/questions/9817388/junit-tests-always-rollback-the-transactions)
     */
    @Test
    @Rollback(false)
    public void testNew() {
        System.out.println("testNew - start");

        Comment entity = new Comment();
        Map<String, Object> content = new HashMap<>();
        Map<String, String> content2 = new HashMap<>();
        content2.put("testKey1", "testValue1");
        content.put("testKey1", "testValue1");
        content.put("testKey2", "testValue2");
        content.put("testKey3", "testValue3");
        content.put("testKey4", content2);
        try {
            entity.setMessage(mapper.writeValueAsString(content));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        rep.save(entity);
        rep.flush();
        List<Comment> entities = rep.findAll();
        System.out.println("count:" + entities.size());

        System.out.println("testNew - finish");
    }

}
