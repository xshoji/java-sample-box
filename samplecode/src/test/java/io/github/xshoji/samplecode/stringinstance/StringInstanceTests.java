package io.github.xshoji.samplecode.stringinstance;

import io.github.xshoji.samplecode.ObjectPrinter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class StringInstanceTests {

  @Test
  public void test() {
    String string1 = "aaa";
    String string2 = "aaa";
    String string3 = new String("aaa");
    String string4 = new String("aaa");

    // > java - printing the address of the string instances - Stack Overflow
    // > https://stackoverflow.com/questions/16351555/printing-the-address-of-the-string-instances/35648773
    ObjectPrinter.printIdentityHashCode(string1);
    ObjectPrinter.printIdentityHashCode(string2);
    ObjectPrinter.printIdentityHashCode(string3);
    ObjectPrinter.printIdentityHashCode(string4);
    assert string1 == string2;
    assert string1 != string3;
    assert string3 != string4;
    assert true;
  }
}
