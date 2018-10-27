package io.github.xshoji.springbootembeddeddb.domain.repository;

import io.github.xshoji.springbootembeddeddb.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *  - [SpringDataJPA · hyukke/HelloWorldTS Wiki](https://github.com/hyukke/HelloWorldTS/wiki/SpringDataJPA)
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
