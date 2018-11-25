package io.github.xshoji.samplecode.factorymethod;

import io.github.xshoji.samplecode.ObjectPrinter;
import io.github.xshoji.samplecode.factorymethod.packageprivate.NameCreator;
import io.github.xshoji.samplecode.factorymethod.packageprivate.PrivateName;
import org.junit.Test;

public class NameCreatorTests {

  @Test
  public void test() {
    // Cannot create directly
    // NormalName name = new NormalName();
    PrivateName name3 = NameCreator.normalName("test", 10);
    PrivateName name4 = NameCreator.emptyName();
    ObjectPrinter.printlnAsJsonString(name3);
    ObjectPrinter.printlnAsJsonString(name4);
    assert true;
  }
}
