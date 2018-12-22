package io.github.xshoji.samplecode.builderpattern;

/**
 * Created by xshoji on 2018-12-22.
 */
public class GrapePartiallyRequired {
  private GrapePartiallyRequired(String productName, String origin, Double price, Double weightGram){
    this.productName = productName;
    this.origin = origin;
    this.price = price;
    this.weightGram = weightGram;
  }
  private final String productName;
  private final String origin;
  private final Double price;
  private final Double weightGram;
  public String getProductName() {
    return productName;
  }
  public String getOrigin() {
    return origin;
  }
  public Double getPrice() {
    return price;
  }
  public Double getWeightGram() {
    return weightGram;
  }

  public static class Builder {
    private String productName = null;
    private String origin = null;
    private Double price = null;
    private Double weightGram = null;
    private Builder(String productName, Double price){
      this.productName = productName;
      this.price = price;
    }
    public static Builder builder(String productName, Double price) {
      return new Builder(productName, price);
    }
    public Builder setOrigin(String origin) {
      this.origin = origin;
      return this;
    }
    public Builder setWeightGram(Double weightGram) {
      this.weightGram = weightGram;
      return this;
    }
    public GrapePartiallyRequired build() {
      return new GrapePartiallyRequired(this.productName, this.origin, this.price, this.weightGram);
    }
  }
}
