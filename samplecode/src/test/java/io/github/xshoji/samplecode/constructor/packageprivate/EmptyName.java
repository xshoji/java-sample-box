package io.github.xshoji.samplecode.constructor.packageprivate;

/**
 * Created by xshoji on 2018/11/17.
 */
public class EmptyName implements PrivateName {

    EmptyName(){
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getType() {
        return "empty";
    }
}
