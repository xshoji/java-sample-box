package io.github.xshoji.springbootmultimodule.domain.repository;

import io.github.xshoji.springbootgrpc.domain.Application;
import io.github.xshoji.springbootgrpc.domain.repository.CommentRepositoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by shojinao on 2018/10/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ComponentScan(basePackages = { "io.github.xshoji" })
public class CommentRepositoryImplTest {

    @Autowired
    CommentRepositoryImpl commentRepository;

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
    public void testAddGet() {
        assert commentRepository.get("aaa").size() == 0;
        commentRepository.add("aaa", "message1");
        commentRepository.add("aaa", "message2");
        assert commentRepository.get("aaa").size() == 2;
    }
}
