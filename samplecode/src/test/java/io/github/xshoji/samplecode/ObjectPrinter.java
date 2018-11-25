package io.github.xshoji.samplecode;

import com.google.gson.GsonBuilder;

import java.util.regex.Pattern;

/** Created by xshoji on 2018/11/17. */
public class ObjectPrinter {
  protected static GsonBuilder builder = new GsonBuilder();

  private ObjectPrinter() {}

  public static void printlnAsJsonString(Object object) {
    System.out.println(builder.create().toJson(object));
  }

  public static void printlnIdentityHashCode(Object object) {
    System.out.println(System.identityHashCode(object));
  }

  public static void println(Object object) {
    System.out.println(object);
  }

  public static String getClassName(Object object) {
    // > java - How to get the name of a class without the package? - Stack Overflow
    // > https://stackoverflow.com/questions/2690333/how-to-get-the-name-of-a-class-without-the-package
//    String className = object.getClass().getName();
//    String classNameSimple = className.substring(className.lastIndexOf(".") + 1);
    return object.getClass().getSimpleName();
  }
}
