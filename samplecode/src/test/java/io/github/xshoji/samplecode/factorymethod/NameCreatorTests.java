package io.github.xshoji.samplecode.factorymethod;

import io.github.xshoji.samplecode.ObjectPrinter;
import io.github.xshoji.samplecode.factorymethod.packageprivate.NameCreator;
import io.github.xshoji.samplecode.factorymethod.packageprivate.PrivateName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class NameCreatorTests {

  @Test
  public void test() {
    // Cannot create directly
    // NormalName name = new NormalName();
    PrivateName name3 = NameCreator.normalName("test", 10);
    PrivateName name4 = NameCreator.emptyName();
    ObjectPrinter.printAsJsonString(name3);
    ObjectPrinter.printAsJsonString(name4);
    assert true;
  }
}
