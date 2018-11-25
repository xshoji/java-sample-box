package io.github.xshoji.samplecode.dependencyinjection;

import io.github.xshoji.samplecode.ObjectPrinter;
import org.junit.Test;

import java.util.HashMap;

public class InverseMapGeneratorTests {
  @Test
  public void test() {
    InverseMapGenerator<String, Integer> mapInverser =
        new InverseMapGenerator<>(
            () -> {
              HashMap<String, Integer> map = new HashMap<>();
              map.put("name1", 1);
              map.put("name2", 2);
              map.put("name3", 3);
              return map;
            });
    ObjectPrinter.printlnAsJsonString(mapInverser.getOriginalMap());
    ObjectPrinter.printlnAsJsonString(mapInverser.getInversedMap());
    assert true;
  }
}
