package io.github.xshoji.samplecode.constructororder;

import io.github.xshoji.samplecode.ObjectPrinter;

/** Created by xshoji on 2018/11/26. */
public class Super1 {
  public Super1() {
    ObjectPrinter.println("  " + this.getClass().getSimpleName() + "'s constructor");
  }
}
