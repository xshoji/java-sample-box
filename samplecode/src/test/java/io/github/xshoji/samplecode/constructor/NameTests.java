package io.github.xshoji.samplecode.constructor;

import com.google.gson.GsonBuilder;
import io.github.xshoji.samplecode.JsonPrinter;
import io.github.xshoji.samplecode.constructor.packageprivate.NameCreator;
import io.github.xshoji.samplecode.constructor.packageprivate.PrivateName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class NameTests {

	@Test
	public void test() {
		Name name1 = new Name("test", 10);
		Name name2 = new Name(10, "name");
		JsonPrinter.printObject(name1);
		JsonPrinter.printObject(name2);

		name1 = Name.createName("test", 10);
		name2 = Name.createEmptyName();
		JsonPrinter.printObject(name1);
		JsonPrinter.printObject(name2);

		// Cannot create directly
		// NormalName name = new NormalName();
		PrivateName name3 = NameCreator.normalName("test", 10);
		PrivateName name4 = NameCreator.emptyName();
		JsonPrinter.printObject(name3);
		JsonPrinter.printObject(name4);
		assert true;
	}

}
