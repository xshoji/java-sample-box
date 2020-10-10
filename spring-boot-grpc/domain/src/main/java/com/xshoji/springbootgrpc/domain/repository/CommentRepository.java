package com.xshoji.springbootgrpc.domain.repository;

import java.util.List;

/**
 * - [SpringDataJPA · hyukke/HelloWorldTS Wiki](https://github.com/hyukke/HelloWorldTS/wiki/SpringDataJPA)
 */
public interface CommentRepository {
  void add(String userName, String comment);

  List<String> get(String userName);
}
