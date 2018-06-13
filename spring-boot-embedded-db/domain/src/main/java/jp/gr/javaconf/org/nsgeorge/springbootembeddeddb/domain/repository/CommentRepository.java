package jp.gr.javaconf.org.nsgeorge.springbootembeddeddb.domain.repository;

import jp.gr.javaconf.org.nsgeorge.springbootembeddeddb.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *  - [SpringDataJPA · hyukke/HelloWorldTS Wiki](https://github.com/hyukke/HelloWorldTS/wiki/SpringDataJPA)
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
