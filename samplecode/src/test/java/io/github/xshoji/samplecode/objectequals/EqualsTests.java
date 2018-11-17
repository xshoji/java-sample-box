package io.github.xshoji.samplecode.objectequals;

import io.github.xshoji.samplecode.ObjectPrinter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/** Created by xshoji on 2018/11/17. */
@RunWith(SpringRunner.class)
public class EqualsTests {
  @Test
  public void test() {
    Set<Date> dateSet1 = new HashSet<>();
    long systemCurrentTimeMillis = System.currentTimeMillis();
    dateSet1.add(new Date(systemCurrentTimeMillis));
    dateSet1.add(new Date(systemCurrentTimeMillis));
    dateSet1.add(new Timestamp(systemCurrentTimeMillis));
    dateSet1.add(new Timestamp(systemCurrentTimeMillis));
    ObjectPrinter.printAsJsonString(dateSet1);
    ObjectPrinter.println(dateSet1.size());

    Set<Date> dateSet2 = new HashSet<>();
    dateSet2.add(new Timestamp(systemCurrentTimeMillis));
    dateSet2.add(new Timestamp(systemCurrentTimeMillis));
    dateSet2.add(new Date(systemCurrentTimeMillis));
    dateSet2.add(new Date(systemCurrentTimeMillis));
    ObjectPrinter.printAsJsonString(dateSet2);
    ObjectPrinter.println(dateSet2.size());
    assert true;
  }
}
