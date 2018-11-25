package io.github.xshoji.samplecode.constructororder;

import io.github.xshoji.samplecode.ObjectPrinter;

/** Created by xshoji on 2018/11/26. */
public class Sub extends Super {
  public Sub() {
    ObjectPrinter.println("Sub's constructor");
  }
}
