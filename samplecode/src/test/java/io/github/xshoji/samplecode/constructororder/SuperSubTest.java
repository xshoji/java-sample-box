package io.github.xshoji.samplecode.constructororder;

import io.github.xshoji.samplecode.ObjectPrinter;
import org.junit.Test;

/** Created by xshoji on 2018/11/26. */
public class SuperSubTest {
  @Test
  public void test() {
    ObjectPrinter.println("Super1: ");
    Super1 super1 = new Super1();
    ObjectPrinter.println("Sub1: ");
    Sub1 sub1 = new Sub1();

    ObjectPrinter.println("");
    ObjectPrinter.println("Super2: ");
    Super2 super2 = new Super2("super2");
    ObjectPrinter.println("Sub2: ");
    Sub2 sub2 = new Sub2("sub2");

    ObjectPrinter.println("");
    ObjectPrinter.println("Super3: ");
    Super3 super3 = new Super3("super3");
    ObjectPrinter.println("Sub3: ");
    Sub3 sub3 = new Sub3("sub3");
    assert true;
  }
}
