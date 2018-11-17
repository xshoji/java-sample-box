package io.github.xshoji.samplecode.objecthashcode;

import org.assertj.core.util.Strings;

/**
 * Created by xshoji on 2018/11/18.
 */
public class AppleCollect extends Apple {
  public AppleCollect(Integer weight, Integer cost) {
    super(weight, cost);
  }

  @Override
  public int hashCode() {
    int result = Integer.hashCode(this.weight);
    result = 31 * result + Integer.hashCode(this.cost);
    return result;
  }
}
