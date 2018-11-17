package io.github.xshoji.samplecode.autovalue;

import io.github.xshoji.samplecode.ObjectPrinter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xshoji on 2018/11/18.
 */
@RunWith(SpringRunner.class)
public class AutoValueTests {
  @Test
  public void test() {
    Set<Banana> bananaSet = new HashSet<>();
    // あくまでImutableなオブジェクトを生成するための手段みたい。所謂DTO的なオブジェクトのように使う想定ではないみたい。
    Banana banana = Banana
            .builder()
            .setBrandName("BananaKing")
            .setProductionArea("Japan")
            .setCost(100)
            .build();
    ObjectPrinter.println(banana);
    Banana banana2 = Banana
            .builder()
            .setProductionArea("America")
            .setCost(200)
            .build();
    ObjectPrinter.println(banana2);
  }
}
