package io.github.xshoji.samplecode.objecthashcode;

/**
 * Created by xshoji on 2018/11/18.
 */
public class AppleConst extends Apple {
  public AppleConst(Integer weight, Integer cost) {
    super(weight, cost);
  }

  @Override
  public int hashCode() {
    return 10;
  }
}
