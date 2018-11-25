package io.github.xshoji.samplecode.overridablemethod;

import io.github.xshoji.samplecode.ObjectPrinter;

/** Created by xshoji on 2018/11/26. */
public class Super1 {
  public Super1() {
  }
  public void sayHello(){
    ObjectPrinter.println(this.getWord());
  }
  public String getWord() {
    return "Hello";
  }
}
