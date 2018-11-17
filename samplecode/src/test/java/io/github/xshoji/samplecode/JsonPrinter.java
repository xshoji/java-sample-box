package io.github.xshoji.samplecode;

import com.google.gson.GsonBuilder;

/**
 * Created by xshoji on 2018/11/17.
 */
public class JsonPrinter {
    protected static GsonBuilder builder = new GsonBuilder();
    private JsonPrinter(){}
    public static void printObject(Object object) {
        System.out.println(builder.create().toJson(object));
    }
}
