package io.github.xshoji.samplecode.overridablemethod;

/** Created by xshoji on 2018/11/26. */
public class Sub1 extends Super1 {
  public Sub1() {
  }

  @Override
  public String getWord() {
    return "Sub1 Hello";
  }
}
