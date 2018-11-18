package io.github.xshoji.samplecode.compareto;

import io.github.xshoji.samplecode.ObjectPrinter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by xshoji on 2018/11/18.
 */
@RunWith(SpringRunner.class)
public class CompareToTests {
  @Test
  public void test() {
    // equals
    HashSet<BigDecimal> set1 = new HashSet<>();
    set1.add(new BigDecimal("1.0"));
    set1.add(new BigDecimal("1.00"));
    ObjectPrinter.println(set1);

    // compareTo
    TreeSet<BigDecimal> set2 = new TreeSet<>();
    set2.add(new BigDecimal("1.0"));
    set2.add(new BigDecimal("1.00"));
    ObjectPrinter.println(set2);
  }
}
