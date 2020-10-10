package com.xshoji.springbootembeddeddb.domain.repository;

import com.xshoji.springbootembeddeddb.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SpringDataJPA · devhyukke/HelloWorldTS Wiki  
 * https://github.com/devhyukke/HelloWorldTS/wiki/SpringDataJPA
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
