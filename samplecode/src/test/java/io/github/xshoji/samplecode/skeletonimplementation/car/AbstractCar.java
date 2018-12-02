package io.github.xshoji.samplecode.skeletonimplementation.car;

/**
 * Created by xshoji on 2018-12-03.
 */
abstract public class AbstractCar implements Car {

  Integer speed;
  Integer currentSpeed = 0;

  public AbstractCar(Integer speed) {
    this.speed = speed;
  }

  @Override
  public void startEngine() {
    currentSpeed = speed;
  }

  @Override
  public void stopEngine() {
    currentSpeed = 0;
  }

  @Override
  public Integer getSpeed() {
    return currentSpeed;
  }
}
