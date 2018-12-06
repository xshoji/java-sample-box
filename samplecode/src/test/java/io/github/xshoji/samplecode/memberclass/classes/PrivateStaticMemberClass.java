package io.github.xshoji.samplecode.memberclass.classes;

import io.github.xshoji.samplecode.ObjectPrinter;

/**
 * Created by xshoji on 2018-12-07.
 */
public class PrivateStaticMemberClass {
  public String name;
  private Integer age;

  public PrivateStaticMemberClass(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  static class MyPerson implements Person {

    private String myName;

    public MyPerson(String myName) {
      this.myName = myName;
    }

    @Override
    public void say() {
      ObjectPrinter.println("My name is " + this.myName);
    }
  }
  public Integer getAge() {
    return this.age;
  }
  public Person toPerson() {
    return new MyPerson(this.name);
  }
}
