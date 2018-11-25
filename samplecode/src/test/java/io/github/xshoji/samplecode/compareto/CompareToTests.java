package io.github.xshoji.samplecode.compareto;

import io.github.xshoji.samplecode.ObjectPrinter;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/** Created by xshoji on 2018/11/18. */
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

    Integer[] integerArray = {2, 1, 4, 3, 5};
    List<Integer> sortedIntegerList = Arrays.asList(integerArray);
    sortedIntegerList.sort(Comparator.comparingInt(i -> i));
    ObjectPrinter.println(sortedIntegerList);

    List<Orange> orangeList = new ArrayList<>();
    orangeList.add(
        Orange.builder()
            .setBrandName("brand_333")
            .setProductionArea("area_33333")
            .setCost(100)
            .build());
    orangeList.add(
        Orange.builder()
            .setBrandName("brand_22")
            .setProductionArea("area_22")
            .setCost(100)
            .build());
    orangeList.add(
        Orange.builder().setBrandName("brand_1").setProductionArea("area_1").setCost(100).build());
    orangeList.add(
        Orange.builder()
            .setBrandName("brand_333")
            .setProductionArea("area_333")
            .setCost(300)
            .build());
    orangeList.add(
        Orange.builder()
            .setBrandName("brand_333")
            .setProductionArea("area_333")
            .setCost(100)
            .build());
    // > java - Comparator comparingInt - Stack Overflow
    // > https://stackoverflow.com/questions/36253973/comparator-comparingint/36254016#36254016
    orangeList.sort(
        Comparator.<Orange>comparingInt(o -> o.getBrandName().length())
            .thenComparingInt(o -> o.getProductionArea().length())
            .thenComparingInt(o -> o.getCost()));
    ObjectPrinter.println(orangeList);
  }
}
