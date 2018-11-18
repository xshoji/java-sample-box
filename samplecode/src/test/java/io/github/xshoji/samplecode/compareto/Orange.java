package io.github.xshoji.samplecode.compareto;

import com.google.auto.value.AutoValue;
import org.springframework.lang.Nullable;

/**
 * Created by xshoji on 2018/11/18.
 */
@AutoValue
abstract class Orange {
  abstract String getProductionArea();
  abstract Integer getCost();
  @Nullable
  abstract String getBrandName();

  static Builder builder() {
    return new io.github.xshoji.samplecode.compareto.AutoValue_Orange.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {
    abstract Builder setProductionArea(String productionArea);
    abstract Builder setBrandName(String brandName);
    abstract Builder setCost(Integer cost);
    abstract Orange build();
  }
}
