package io.github.xshoji.samplecode.bestpractice.testingtarget;

import java.util.Arrays;
import java.util.List;

public class UserDao {
  public User get(UserGetRequest request) {
    return new User(1111L, "John");
  }

  public List<User> getAll() {
    return Arrays.asList(new User(1111L, "John"));
  }  
}
