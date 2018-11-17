package io.github.xshoji.samplecode.factorymethod.packageprivate;

/** Created by xshoji on 2018/11/17. */
public class NormalName implements PrivateName {

  private String name;
  private Integer age;

  NormalName(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public String getType() {
    return "normal";
  }
}
