package io.github.xshoji.samplecode;

import com.google.gson.GsonBuilder;

/** Created by xshoji on 2018/11/17. */
public class ObjectPrinter {
  protected static GsonBuilder builder = new GsonBuilder();

  private ObjectPrinter() {}

  public static void printAsJsonString(Object object) {
    System.out.println(builder.create().toJson(object));
  }

  public static void printIdentityHashCode(Object object) {
    System.out.println(System.identityHashCode(object));
  }
  public static void println(Object object) {
    System.out.println(object);
  }
}
