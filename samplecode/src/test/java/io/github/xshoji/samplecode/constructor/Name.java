package io.github.xshoji.samplecode.constructor;

public class Name {

  private String name;
  private Integer age;

  // Set properties
  public Name(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  // empty properties object
  public Name(Integer age, String name) {}

  static Name createName(String name, Integer age) {
    return new Name(name, age);
  }

  static Name createEmptyName() {
    return new Name(0, "");
  }
}
