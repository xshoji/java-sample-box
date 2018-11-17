package io.github.xshoji.samplecode.constructor.packageprivate;

/**
 * Created by xshoji on 2018/11/17.
 */
public class NameCreator {

    public static PrivateName normalName(String name, Integer age){
        return new NormalName(name, age);
    }

    public static PrivateName emptyName() {
        return new EmptyName();
    }
}
