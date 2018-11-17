package io.github.xshoji.samplecode.constructor;

import io.github.xshoji.samplecode.JsonPrinter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
public class InverseMapGeneratorTests {
    @Test
    public void test() {
        InverseMapGenerator<String, Integer> mapInverser = new InverseMapGenerator<>(() -> {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("name1", 1);
            map.put("name2", 2);
            map.put("name3", 3);
            return map;
        });
        JsonPrinter.printObject(mapInverser.getOriginalMap());
        JsonPrinter.printObject(mapInverser.getInversedMap());
        assert true;
    }
}
