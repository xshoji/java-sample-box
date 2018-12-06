package io.github.xshoji.samplecode.memberclass.classes;

import io.github.xshoji.samplecode.ObjectPrinter;

/**
 * Created by xshoji on 2018-12-07.
 */
public class NonStaticMemberClass {
  public String name;
  private Integer age;

  public NonStaticMemberClass(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  private class MyPerson implements Person {
    @Override
    public void say() {
      ObjectPrinter.println("My name is " + name + ", " + age + " years old.");
    }
  }
  public Person toPerson() {
    return new MyPerson();
  }
}
