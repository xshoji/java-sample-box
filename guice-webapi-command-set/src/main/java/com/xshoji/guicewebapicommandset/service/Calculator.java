package com.xshoji.guicewebapicommandset.service;


public class Calculator {

  /**
   * @param x
   * @param y
   * @return String
   */
  public String getStringFormula(Integer x, Integer y) {
    return "x:" + x + " + y:" + y + " = sum:" + this.getSum(x, y);
  }

  /**
   * @param x
   * @param y
   * @return Integer
   */
  public Integer getSum(Integer x, Integer y) {
    return x + y;
  }
}
