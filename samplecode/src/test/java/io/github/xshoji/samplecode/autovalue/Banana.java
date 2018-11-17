package io.github.xshoji.samplecode.autovalue;

import com.google.auto.value.AutoValue;
import org.springframework.lang.Nullable;

/**
 * Created by xshoji on 2018/11/18.
 */
@AutoValue
abstract class Banana {
  abstract String getProductionArea();
  abstract Integer getCost();
  @Nullable
  abstract String getBrandName();

  static Builder builder() {
    return new io.github.xshoji.samplecode.autovalue.AutoValue_Banana.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {
    abstract Builder setProductionArea(String productionArea);
    abstract Builder setBrandName(String brandName);
    abstract Builder setCost(Integer cost);
    abstract Banana build();
  }
}
