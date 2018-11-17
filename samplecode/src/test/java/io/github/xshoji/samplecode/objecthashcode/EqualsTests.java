package io.github.xshoji.samplecode.objecthashcode;

import io.github.xshoji.samplecode.ObjectPrinter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/** Created by xshoji on 2018/11/17. */
@RunWith(SpringRunner.class)
public class EqualsTests {
  @Test
  public void test() {
    Map<Apple, Integer> appleMap = new HashMap<>();
    Apple apple = new Apple(100, 200);
    appleMap.put(apple, 1);
    ObjectPrinter.println(appleMap.get(new Apple(100, 200)));
    ObjectPrinter.println(appleMap.get(apple));

    Map<AppleConst, Integer> appleConstMap = new HashMap<>();
    AppleConst appleConst = new AppleConst(100, 200);
    AppleConst appleConst2 = new AppleConst(50, 110);
    appleConstMap.put(appleConst, 1);
    appleConstMap.put(appleConst2, 2);
    ObjectPrinter.println(appleConstMap.get(new AppleConst(100, 200)));
    ObjectPrinter.println(appleConstMap.get(new AppleConst(50, 110)));
    ObjectPrinter.println(appleConstMap.get(appleConst));
    ObjectPrinter.println(appleConstMap.get(appleConst2));

    Map<AppleCollect, Integer> appleCollectMap = new HashMap<>();
    AppleCollect appleCollect = new AppleCollect(100, 200);
    AppleCollect appleCollect2 = new AppleCollect(50, 110);
    appleCollectMap.put(appleCollect, 1);
    appleCollectMap.put(appleCollect2, 2);
    ObjectPrinter.println(appleCollectMap.get(new AppleCollect(100, 200)));
    ObjectPrinter.println(appleCollectMap.get(new AppleCollect(50, 110)));
    ObjectPrinter.println(appleCollectMap.get(appleCollect));
    ObjectPrinter.println(appleCollectMap.get(appleCollect2));

    assert true;
  }
}
