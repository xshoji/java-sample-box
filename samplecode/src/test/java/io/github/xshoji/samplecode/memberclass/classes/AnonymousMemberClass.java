package io.github.xshoji.samplecode.memberclass.classes;

import io.github.xshoji.samplecode.ObjectPrinter;

import java.util.function.Consumer;

/**
 * Created by xshoji on 2018-12-07.
 */
public class AnonymousMemberClass {
  public Consumer<String> say = new Consumer<String>() {
    @Override
    public void accept(String s) {
      ObjectPrinter.println("Consumer's say: " + s);
    }
  };
}
