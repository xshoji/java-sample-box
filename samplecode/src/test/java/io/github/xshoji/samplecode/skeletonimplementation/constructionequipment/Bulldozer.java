package io.github.xshoji.samplecode.skeletonimplementation.constructionequipment;

import io.github.xshoji.samplecode.ObjectPrinter;
import io.github.xshoji.samplecode.skeletonimplementation.car.AbstractCar;
import io.github.xshoji.samplecode.skeletonimplementation.car.Car;

/**
 * Created by xshoji on 2018-12-03.
 */
public class Bulldozer extends AbstractConstructionEquipment implements Car {

  private Car car;

  public Bulldozer() {
    car = new AbstractCar(5){};
  }

  @Override
  public void startEngine() {
    this.car.startEngine();
  }

  @Override
  public void stopEngine() {
    this.car.stopEngine();
  }

  @Override
  public Integer getSpeed() {
    return this.car.getSpeed();
  }
}
