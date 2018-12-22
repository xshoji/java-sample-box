package io.github.xshoji.samplecode.builderpattern;

/**
 * Created by xshoji on 2018-12-22.
 */
public class GrapeOneway {
  private GrapeOneway(String productName, String origin, Double price, Double weightGram){
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

  public interface ProductNameSetter {
    OriginSetter setProductName(String productName);
  }

  public interface OriginSetter {
    PriceSetter setOrigin(String origin);
  }

  public interface PriceSetter {
    Builder setPrice(Double price);
  }

  public static class Builder implements ProductNameSetter,OriginSetter,PriceSetter {
    private String productName = null;
    private String origin = null;
    private Double price = null;
    private Double weightGram = null;
    private Builder() {}
    public static ProductNameSetter builder() {
      return new Builder();
    }


    @Override
    public OriginSetter setProductName(String productName) {
      this.productName = productName;
      return this;
    }

    @Override
    public PriceSetter setOrigin(String origin) {
      this.origin = origin;
      return this;
    }

    @Override
    public Builder setPrice(Double price) {
      this.price = price;
      return this;
    }

    public Builder setWeightGram(Double weightGram) {
      this.weightGram = weightGram;
      return this;
    }

    public GrapeOneway build() {
      return new GrapeOneway(this.productName, this.origin, this.price, this.weightGram);
    }

  }
}
