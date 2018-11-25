package io.github.xshoji.samplecode.constructor;

import io.github.xshoji.samplecode.ObjectPrinter;
import io.github.xshoji.samplecode.factorymethod.packageprivate.NameCreator;
import io.github.xshoji.samplecode.factorymethod.packageprivate.PrivateName;
import org.junit.Test;

public class NameTests {

  @Test
  public void test() {
    Name name1 = new Name("test", 10);
    Name name2 = new Name(10, "name");
    ObjectPrinter.printlnAsJsonString(name1);
    ObjectPrinter.printlnAsJsonString(name2);

    name1 = Name.createName("test", 10);
    name2 = Name.createEmptyName();
    ObjectPrinter.printlnAsJsonString(name1);
    ObjectPrinter.printlnAsJsonString(name2);

    // Cannot create directly
    // NormalName name = new NormalName();
    PrivateName name3 = NameCreator.normalName("test", 10);
    PrivateName name4 = NameCreator.emptyName();
    ObjectPrinter.printlnAsJsonString(name3);
    ObjectPrinter.printlnAsJsonString(name4);
    assert true;
  }
}
