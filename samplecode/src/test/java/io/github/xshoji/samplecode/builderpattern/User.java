package io.github.xshoji.samplecode.builderpattern;

public class User {
  private String name;
  private String nickname;
  private String states;
  private String city;
  private Boolean isStudent;
  private Boolean isMarried;
  // 直接new禁止
  private User() {}
  public String getName()     { return name; }
  public String getNickname() { return nickname; }
  public String getStates()   { return states; }
  public String getCity()     { return city; }
  public Boolean isStudent()  { return isStudent; }
  public Boolean isMarried()  { return isMarried; }
  public static class Builder {
    private User provisionalUser;
    private Builder() {}
    public static Builder builder() {
      Builder builder = new Builder();
      builder.provisionalUser = new User();
      return builder;
    }
    public Builder setName(String name)            { provisionalUser.name = name;           return this; }
    public Builder setNickname(String nickname)    { provisionalUser.nickname = nickname;   return this; }
    public Builder setStates(String states)        { provisionalUser.states = states;       return this; }
    public Builder setCity(String city)            { provisionalUser.city = city;           return this; }
    public Builder setIsStudent(Boolean isStudent) { provisionalUser.isStudent = isStudent; return this; }
    public Builder setIsMarried(Boolean isMarried) { provisionalUser.isMarried = isMarried; return this; }
    public User build() {
      User user = new User();
      user.name = provisionalUser.name;
      user.nickname = provisionalUser.nickname;
      user.states = provisionalUser.states;
      user.city = provisionalUser.city;
      user.isStudent = provisionalUser.isStudent;
      user.isMarried = provisionalUser.isMarried;
      // 必要に応じてここで状態の整合性チェック
      return user;
    }
  }
}
