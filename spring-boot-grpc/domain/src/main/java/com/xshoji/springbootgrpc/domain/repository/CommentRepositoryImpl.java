package com.xshoji.springbootgrpc.domain.repository;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * - [SpringDataJPA · hyukke/HelloWorldTS Wiki](https://github.com/hyukke/HelloWorldTS/wiki/SpringDataJPA)
 */
@Component
public class CommentRepositoryImpl implements CommentRepository {
    ConcurrentHashMap<String, List<String>> comments;

    public CommentRepositoryImpl() {
        this.comments = new ConcurrentHashMap<>();
    }

    public void add(String userName, String comment) {
        get(userName).add(comment);
    }

    public List<String> get(String userName){
        if (!comments.containsKey(userName)) {
            comments.put(userName, new ArrayList<>());
        }
        return comments.get(userName);
    }
}
