package io.github.xshoji.samplecode.overridablemethod;

/** Created by xshoji on 2018/11/26. */
public class Sub2 extends Super2 {
  public Sub2() {
  }

  @Override
  public String getWord() {
    return "Sub1 Hello";
  }
}
