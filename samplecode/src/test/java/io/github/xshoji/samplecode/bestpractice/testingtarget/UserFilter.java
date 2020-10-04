package io.github.xshoji.samplecode.bestpractice.testingtarget;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserFilter {
  public final List<User> users;
  public List<User> getByIdGreaterThan(Long id) {
    return users.stream().filter(e -> e.getId() > id).collect(Collectors.toList());
  }
}
