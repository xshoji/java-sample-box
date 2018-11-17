package io.github.xshoji.samplecode.dependencyinjection;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/** Created by xshoji on 2018/11/17. */
public class InverseMapGenerator<T, R> {

  Map<T, R> originalMap;

  public InverseMapGenerator(Supplier<Map<T, R>> supplier) {
    this.originalMap = supplier.get();
  }

  public Map<T, R> getOriginalMap() {
    return originalMap;
  }

  public Map<R, T> getInversedMap() {
    return originalMap
        .entrySet()
        .stream()
        .collect(Collectors.toMap(Map.Entry::getValue, c -> c.getKey()));
  }
}
