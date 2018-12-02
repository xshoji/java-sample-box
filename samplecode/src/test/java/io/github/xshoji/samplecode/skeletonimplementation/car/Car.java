package io.github.xshoji.samplecode.skeletonimplementation.car;

/**
 * Created by xshoji on 2018-12-03.
 */
public interface Car {
  void startEngine();
  void stopEngine();
  Integer getSpeed();
  default Boolean isDriving() {
    return getSpeed() > 0;
  }
}
