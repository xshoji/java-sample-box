package io.github.xshoji.samplecode.skeletonimplementation.constructionequipment;

import io.github.xshoji.samplecode.ObjectPrinter;

/**
 * Created by xshoji on 2018-12-03.
 */
abstract public class AbstractConstructionEquipment implements ConstructionEquipment {
  @Override
  public void construct() {
    ObjectPrinter.println("Construct!!");
  }
}
