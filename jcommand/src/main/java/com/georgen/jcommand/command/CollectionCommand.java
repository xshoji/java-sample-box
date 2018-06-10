package com.georgen.jcommand.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.georgen.jcommand.dto.ResponseHttpbinGet;
import com.georgen.jcommand.dto.ResponseHttpbinPost;
import com.georgen.jcommand.enums.MyEnum;
import com.georgen.jcommand.service.ApiClientHttpbin;
import com.google.inject.Inject;
import org.kohsuke.args4j.Option;

import java.util.*;
import java.util.stream.IntStream;

public class CollectionCommand extends Command {

    /**
     * @link Jackson使い方メモ - Qiita http://qiita.com/opengl-8080/items/b613b9b3bc5d796c840c
     * @link java - NoClassDefFoundError of com/fasterxml/jackson/databind/ObjectMapper with Maven https://stackoverflow.com/questions/43826718/noclassdeffounderror-of-com-fasterxml-jackson-databind-objectmapper-with-maven
     * @param args
     */
    protected void doRun(String[] args) {

        // 普通のStringの配列
        // String[] strings = {"aaa", "bbb", "ccc"}; でもOK
        String[] stringArray = new String[3];
        stringArray[0] = "aaa";
        stringArray[1] = "bbb";
        stringArray[2] = "ccc";
        this.systemOutPrintln();
        this.systemOutPrintln("== String[] ==");
        Arrays.stream(stringArray).forEach(value -> this.systemOutPrintln(value));

        // ArrayList
        // インデックスで管理されていて参照が高速。一方で、要素の追加時に追加した要素以降のインデックスの更新が走ってしまう
        List<String> stringList = new ArrayList<>();
        Arrays.stream(stringArray).forEach(value -> stringList.add(value));
        this.systemOutPrintln();
        this.systemOutPrintln("== List<String> new ArrayList<>() ==");
        stringList.stream().forEach(value -> this.systemOutPrintln(value));

        // LinkedList
        // 要素同士が前後の要素のリンク情報を持っている。特定の要素を参照するのが苦手な一方で、要素の追加時にリンク情報を書き換えるだけでOKなので高速
        List<String> stringLinkedList = new LinkedList<>();
        Arrays.stream(stringArray).forEach(value -> stringLinkedList.add(value));
        this.systemOutPrintln();
        this.systemOutPrintln("== List<String> new LinkedList<>() ==");
        stringList.stream().forEach(value -> this.systemOutPrintln(value));

        // Set
        Set<String> stringHashSet = new HashSet<>();
        // 順番は保証されない
        stringHashSet.add("aaa");
        stringHashSet.add("bbb");
        stringHashSet.add("aaa"); // 追加されない
        stringHashSet.add("ccc");
        this.systemOutPrintln();
        this.systemOutPrintln("== Set<String> HashSet ==");
        stringHashSet.stream().forEach(value -> this.systemOutPrintln(value));

        // Set
        Set<String> stringLinkedHashSet = new LinkedHashSet<>();
        // 順番が保証される
        stringLinkedHashSet.add("aaa");
        stringLinkedHashSet.add("bbb");
        stringLinkedHashSet.add("ccc");
        this.systemOutPrintln();
        this.systemOutPrintln("== Set<String> LinkedHashSet ==");
        stringLinkedHashSet.stream().forEach(value -> this.systemOutPrintln(value));

        // Set
        Set<String> stringTreeSet = new TreeSet<>();
        // ソートされる
        stringTreeSet.add("ccc");
        stringTreeSet.add("bbb");
        stringTreeSet.add("aaa");
        this.systemOutPrintln();
        this.systemOutPrintln("== Set<String> TreeSet ==");
        stringTreeSet.stream().forEach(value -> this.systemOutPrintln(value));

        // Set
        Set<MyEnum> stringEnumSet = EnumSet.of(MyEnum.MyEnumA, MyEnum.MyEnumB, MyEnum.MyEnumC);
        this.systemOutPrintln();
        this.systemOutPrintln("== Set<String> EnumSet.of() ==");
        stringEnumSet.stream().forEach(myEnum -> this.systemOutPrintln(myEnum.name()));

        // Map
        Map<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("key_aaa", "value_aaa");
        stringHashMap.put("key_bbb", "value_bbb");
        stringHashMap.put("key_ccc", "value_ccc");
        this.systemOutPrintln();
        this.systemOutPrintln("== Map<String, String> HashMap ==");
        stringHashMap.keySet().stream().forEach(key -> this.systemOutPrintln("key:" + key + ", value:" + stringHashMap.get(key)));

        // Map
        Map<String, String> stringLinkedHashMap = new LinkedHashMap<>();
        stringLinkedHashMap.put("key_aaa", "value_aaa");
        stringLinkedHashMap.put("key_bbb", "value_bbb");
        stringLinkedHashMap.put("key_ccc", "value_ccc");
        this.systemOutPrintln();
        this.systemOutPrintln("== Map<String, String> LinkedHashMap ==");
        stringLinkedHashMap.keySet().stream().forEach(key -> this.systemOutPrintln("key:" + key + ", value:" + stringLinkedHashMap.get(key)));

        // Map
        Map<MyEnum, String> stringEnumMap = new EnumMap<>(MyEnum.class);
        stringEnumMap.put(MyEnum.MyEnumA, "value_aaa");
        stringEnumMap.put(MyEnum.MyEnumB, "value_bbb");
        stringEnumMap.put(MyEnum.MyEnumC, "value_ccc");
        this.systemOutPrintln();
        this.systemOutPrintln("== Map<String, String> EnumMap ==");
        stringEnumMap.keySet().stream().forEach(key -> this.systemOutPrintln("key:" + key + ", value:" + stringEnumMap.get(key)));



        //---------------
        // テクニック系

        // ArrayList
        // java8 の forEach を index つきで使いたい - Qiita https://qiita.com/nakazawaken1/items/6d153352799f3e5be72d
        List<String> stringList2 = Arrays.asList("aaa", "bbb", "ccc");
        this.systemOutPrintln();
        this.systemOutPrintln("== List<String> Arrays.asList ==");
        IntStream
                .range(0, stringList2.size())
                .mapToObj(i -> i + ": " + stringList2.get(i))
                .forEach(System.out::println);

    }
}