package io.github.xshoji.samplecode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SamplecodeApplicationTests {

  @Test
  public void contextLoads() {

    List<String> list = Arrays.asList("aaa_aaa", "bbb_bbb", "ccc_ccc");
    ObjectPrinter.println(list.get(0).split("_")[1]);
  }
}
