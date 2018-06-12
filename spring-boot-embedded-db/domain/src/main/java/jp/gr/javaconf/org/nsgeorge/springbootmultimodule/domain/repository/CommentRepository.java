package jp.gr.javaconf.org.nsgeorge.springbootmultimodule.domain.repository;

import jp.gr.javaconf.org.nsgeorge.springbootmultimodule.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  - [SpringDataJPA · hyukke/HelloWorldTS Wiki](https://github.com/hyukke/HelloWorldTS/wiki/SpringDataJPA)
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
