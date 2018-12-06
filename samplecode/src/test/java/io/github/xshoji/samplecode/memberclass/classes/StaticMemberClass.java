package io.github.xshoji.samplecode.memberclass.classes;

import io.github.xshoji.samplecode.ObjectPrinter;

/**
 * Created by xshoji on 2018-12-07.
 */
public class StaticMemberClass {
  public static String name = "StaticMemberClass";
  private static String language = "Japanese";
  public enum Type {
    A_TYPE("A"),
    B_TYPE("B"),
    C_TYPE("C"),
    ;
    String value;
    Type(String name) {
      this.value = name;
    }
  }
  public static class Getter {
    public static String getLanguage() {
      return language;
    }
  }
  public static void printType(Type type) {
    ObjectPrinter.println("Type: " + type.value);
  }
}
