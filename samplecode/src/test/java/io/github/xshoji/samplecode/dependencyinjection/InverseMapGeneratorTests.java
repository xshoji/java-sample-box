package io.github.xshoji.samplecode.dependencyinjection;

import io.github.xshoji.samplecode.ObjectPrinter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
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
    ObjectPrinter.printAsJsonString(mapInverser.getOriginalMap());
    ObjectPrinter.printAsJsonString(mapInverser.getInversedMap());
    assert true;
  }
}
