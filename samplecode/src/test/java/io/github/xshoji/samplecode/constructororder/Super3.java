package io.github.xshoji.samplecode.constructororder;

import io.github.xshoji.samplecode.ObjectPrinter;

/** Created by xshoji on 2018/11/26. */
public class Super3 {
  public Super3(String name) {
    ObjectPrinter.println("  " + this.getClass().getSimpleName() + "'s constructor, name: " + name);
  }
  public Super3() {
    ObjectPrinter.println("  " + this.getClass().getSimpleName() + "'s constructor, no args");
  }
}
