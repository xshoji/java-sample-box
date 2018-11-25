package io.github.xshoji.samplecode.constructororder;

import org.junit.Test;

/** Created by xshoji on 2018/11/26. */
public class SuperSubTest {
  @Test
  public void test() {
    Sub sub = new Sub();
    Super superx = new Super();
    assert true;
  }
}
