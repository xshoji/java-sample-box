package io.github.xshoji.samplecode.constructororder;

import io.github.xshoji.samplecode.ObjectPrinter;

/** Created by xshoji on 2018/11/26. */
public class Sub3 extends Super3 {
  public Sub3(String name) {
    ObjectPrinter.println("  " + this.getClass().getSimpleName() + "'s constructor");
  }
}
