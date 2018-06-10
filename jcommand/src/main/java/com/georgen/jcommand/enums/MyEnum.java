package com.georgen.jcommand.enums;


/**
 * Created by shojinao on 2017/06/11.
 */
public enum MyEnum {
    MyEnumA(0),
    MyEnumB(1),
    MyEnumC(2)
    ;

    private int code;

    private MyEnum(int i) {
        code = i;
    }
    public int getValue() {
        return code;
    }
}
