package io.github.xshoji.samplecode.memberclass;

import io.github.xshoji.samplecode.ObjectPrinter;
import io.github.xshoji.samplecode.memberclass.classes.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xshoji on 2018-12-07.
 */
public class MemberClassTests {
  @Test
  public void test() {
    ObjectPrinter.println("[ StaticMemberClass ]");
    ObjectPrinter.println(StaticMemberClass.name);
    ObjectPrinter.println(StaticMemberClass.Getter.getLanguage());
    StaticMemberClass.Type type = StaticMemberClass.Type.A_TYPE;
    StaticMemberClass.printType(type);
    ObjectPrinter.println("");

    ObjectPrinter.println("[ NonStaticMemberClass ]");
    NonStaticMemberClass clazz1 = new NonStaticMemberClass("NonStaticMemberClass1", 100);
    NonStaticMemberClass clazz2 = new NonStaticMemberClass("NonStaticMemberClass2", 11);
    NonStaticMemberClass clazz3 = new NonStaticMemberClass("NonStaticMemberClass3", 20);
    List<NonStaticMemberClass> list = Arrays.asList(clazz1, clazz2, clazz3);
    ObjectPrinter.printlnAsJsonString(list);
    list.stream().map(NonStaticMemberClass::toPerson).forEach(Person::say);
    ObjectPrinter.println("");

    ObjectPrinter.println("[ PrivateStaticMemberClass ]");
    PrivateStaticMemberClass privateStaticMemberClass = new PrivateStaticMemberClass("PrivateStaticMemberClass", 100);
    ObjectPrinter.printlnAsJsonString(privateStaticMemberClass);
    ObjectPrinter.printlnAsJsonString(privateStaticMemberClass.toPerson());
    ObjectPrinter.println("");

    ObjectPrinter.println("[ AnonymousMemberClass ]");
    AnonymousMemberClass anonymousMemberClass = new AnonymousMemberClass();
    anonymousMemberClass.say.accept("Hello!");
    ObjectPrinter.println("");
    assert true;
  }
}
