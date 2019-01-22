package io.github.xshoji.samplecode.builderpattern;

import io.github.xshoji.samplecode.ObjectPrinter;
import org.junit.Test;

/** Created by xshoji on 2018/11/18. */
public class BuilderPatternTests {
  @Test
  public void test() {
    // AllOptional
    GrapeAllOptional grape = GrapeAllOptional.Builder //
            .builder() //
            .setProductName("MyGrapeAllOptional") //
            .setOrigin("Japan") //
            .setPrice(100.00) //
            .setWeightGram(200.00) //
            .build();
    ObjectPrinter.printlnAsJsonString(grape);

    GrapeAllOptional grape2 = GrapeAllOptional.Builder //
            .builder() //
            .setProductName("MyGrapeAllOptional") //
            .build(); //
    ObjectPrinter.printlnAsJsonString(grape2);

    // PartiallyRequired
    GrapePartiallyRequired grape3 = GrapePartiallyRequired.Builder //
            .builder("MyGrapePartiallyRequired", 100.0) //
            .setOrigin("Japan") //
            .setWeightGram(200.00) //
            .build();
    ObjectPrinter.printlnAsJsonString(grape3);

    GrapePartiallyRequired grape4 = GrapePartiallyRequired.Builder //
            .builder("MyGrapePartiallyRequired", 100.0) //
            .build();
    ObjectPrinter.printlnAsJsonString(grape4);

    // Oneway
    GrapeOneway grape5 = GrapeOneway.Builder
            .builder()
            .setProductName("MyGrapeOneway")
            .setOrigin("Japan")
            .setPrice(100.00)
            .build();
    ObjectPrinter.printlnAsJsonString(grape5);

    GrapeOneway grape6 = GrapeOneway.Builder
            .builder()
            .setProductName("MyGrapeOneway")
            .setOrigin("Japan")
            .setPrice(100.00)
            .setWeightGram(300.0)
            .build();
    ObjectPrinter.printlnAsJsonString(grape6);

    User user = User.Builder.builder()
            .setName("John")
            .setNickname("JJ")
            .setStates("AAA")
            .setCity("BBB")
            .setIsStudent(true)
            .setIsMarried(false)
            .build();
    user.getName();
    user.getNickname();
    user.getStates();
    user.getCity();
    user.isStudent();
    user.isMarried();
    ObjectPrinter.printlnAsJsonString(user);

    UserRequired user2 = UserRequired.Builder
            .builder("John", "JJ", true)
            .setCity("aaa")
            .setStates("AAA")
            .setIsMarried(false)
            .build();
    ObjectPrinter.printlnAsJsonString(user2);

    UserStep user3 = UserStep.Builder.builder()
            .setName("AAA")
            .setNickname("BBB")
            .setStates("CCC")
            .setCity("DDD")
            .setIsStudent(true)
            .setIsMarried(true)
            .build();
    ObjectPrinter.printlnAsJsonString(user3);

  }
}
