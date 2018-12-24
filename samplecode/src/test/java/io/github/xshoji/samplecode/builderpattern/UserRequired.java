package io.github.xshoji.samplecode.builderpattern;

public class UserRequired {
  private String name;
  private String nickname;
  private String states;
  private String city;
  private Boolean isStudent;
  private Boolean isMarried;
  // 直接new禁止
  private UserRequired(String name, String nickname, String states, String city, Boolean isStudent, Boolean isMarried) {
    this.name = name; this.nickname = nickname; this.states = states; this.city = city; this.isStudent = isStudent; this.isMarried = isMarried;
  }
  public String getName()     { return name; }
  public String getNickname() { return nickname; }
  public String getStates()   { return states; }
  public String getCity()     { return city; }
  public Boolean isStudent()  { return isStudent; }
  public Boolean isMarried()  { return isMarried; }
  public static class Builder {
    private String name;
    private String nickname;
    private String states;
    private String city;
    private Boolean isStudent;
    private Boolean isMarried;
    private Builder() {}
    public static Builder builder(String name, String nickname, Boolean isStudent) {
      Builder builder = new Builder();
      builder.name = name;
      builder.nickname = nickname;
      builder.isStudent = isStudent;
      return builder;
    }
    public Builder setStates(String states)        { this.states = states;       return this; }
    public Builder setCity(String city)            { this.city = city;           return this; }
    public Builder setIsMarried(Boolean isMarried) { this.isMarried = isMarried; return this; }
    public UserRequired build() {
      // 必要に応じてここで状態の整合性チェック
      return new UserRequired(this.name, this.nickname, this.states, this.city, this.isStudent, this.isMarried);
    }
  }
}
