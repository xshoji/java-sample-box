package io.github.xshoji.samplecode.builderpattern;

public class UserStep {
  private String name;
  private String nickname;
  private String states;
  private String city;
  private Boolean isStudent;
  private Boolean isMarried;
  // 直接new禁止
  private UserStep() {}
  public String getName()     { return name; }
  public String getNickname() { return nickname; }
  public String getStates()   { return states; }
  public String getCity()     { return city; }
  public Boolean isStudent()  { return isStudent; }
  public Boolean isMarried()  { return isMarried; }
  public interface NameSetter      { NicknameSetter setName(String name); }
  public interface NicknameSetter  { StatesSetter setNickname(String name); }
  public interface StatesSetter    { CitySetter setStates(String name); }
  public interface CitySetter      { IsStudentSetter setCity(String name); }
  public interface IsStudentSetter { IsMarriedSetter setIsStudent(Boolean isStudent); }
  public interface IsMarriedSetter { Builder setIsMarried(Boolean isStudent); }
  public static class Builder implements NameSetter,NicknameSetter,StatesSetter,CitySetter,IsStudentSetter,IsMarriedSetter {
    private UserStep provisionalUser;
    private Builder() {}
    public static NameSetter builder() {
      Builder builder = new Builder();
      builder.provisionalUser = new UserStep();
      return builder;
    }
    public NicknameSetter setName(String name)             { provisionalUser.name = name;           return this; }
    public StatesSetter setNickname(String nickname)       { provisionalUser.nickname = nickname;   return this; }
    public CitySetter setStates(String states)             { provisionalUser.states = states;       return this; }
    public IsStudentSetter setCity(String city)            { provisionalUser.city = city;           return this; }
    public IsMarriedSetter setIsStudent(Boolean isStudent) { provisionalUser.isStudent = isStudent; return this; }
    public Builder setIsMarried(Boolean isMarried)         { provisionalUser.isMarried = isMarried; return this; }
    public UserStep build() {
      UserStep user = new UserStep();
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
