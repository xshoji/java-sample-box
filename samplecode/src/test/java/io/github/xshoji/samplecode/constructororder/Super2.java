package io.github.xshoji.samplecode.constructororder;

import io.github.xshoji.samplecode.ObjectPrinter;

/** Created by xshoji on 2018/11/26. */
public class Super2 {
  public Super2(String name) {
    ObjectPrinter.println("  " + this.getClass().getSimpleName() + "'s constructor, name: " + name);
  }
}
