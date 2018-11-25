package io.github.xshoji.samplecode.overridablemethod;

import io.github.xshoji.samplecode.ObjectPrinter;
import org.junit.Test;

/** Created by xshoji on 2018/11/26. */
public class OverrideMethodTest {
  @Test
  public void test() {
    Super1 super1 = new Super1();
    super1.sayHello();
    Sub1 sub1 = new Sub1();
    sub1.sayHello();

    ObjectPrinter.println("");
    Super2 super2 = new Super2();
    super2.sayHello();
    Sub2 sub2 = new Sub2();
    sub2.sayHello();
    assert true;
  }
}
