package io.github.xshoji.samplecode.overridablemethod;

import io.github.xshoji.samplecode.ObjectPrinter;

/** Created by xshoji on 2018/11/26. */
public class Super2 {
  public Super2() {
  }
  public void sayHello(){
    ObjectPrinter.println(this.getWordLocal());
  }
  public String getWord() {
    return this.getWordLocal();
  }
  private String getWordLocal() {
    return "Hello";
  }
}
