package io.github.xshoji.samplecode.skeletonimplementation;

import io.github.xshoji.samplecode.ObjectPrinter;
import io.github.xshoji.samplecode.skeletonimplementation.car.Car;
import io.github.xshoji.samplecode.skeletonimplementation.car.OldCar;
import io.github.xshoji.samplecode.skeletonimplementation.car.SportsCar;
import io.github.xshoji.samplecode.skeletonimplementation.constructionequipment.Bulldozer;
import org.junit.Test;

/**
 * Created by xshoji on 2018-12-03.
 */
public class SkeltonImplementationTest {
  @Test
  public void test() {
    Car sportsCar = new SportsCar();
    Car oldCar = new OldCar();
    Bulldozer bulldozer = new Bulldozer();

    handleCar("SportsCar", sportsCar);
    ObjectPrinter.println("");
    handleCar("OldCar", oldCar);
    ObjectPrinter.println("");
    handleCar("Bulldozer", bulldozer);
    ObjectPrinter.println("");
    assert true;
  }

  protected void handleCar(String carName, Car car) {
    ObjectPrinter.println(carName);
    ObjectPrinter.println("  isDriving: " + car.isDriving());
    ObjectPrinter.println("  startEngine...");
    car.startEngine();
    ObjectPrinter.println("  isDriving: " + car.isDriving());
    ObjectPrinter.println("  getSpeed: " + car.getSpeed());
    ObjectPrinter.println("  stopEngine...");
    car.stopEngine();
  }
}
