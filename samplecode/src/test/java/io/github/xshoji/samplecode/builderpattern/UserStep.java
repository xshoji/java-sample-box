package io.github.xshoji.samplecode.builderpattern;

public class UserStep {
  private String name;
  private String nickname;
  private String states;
  private String city;
  private Boolean isStudent;
  private Boolean isMarried;
  // 直接new禁止
  private UserStep(Builder b) {
    name = b.name; nickname = b.nickname; states = b.states; city = b.city; isStudent = b.isStudent; isMarried = b.isMarried;
  }
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
    private String name;
    private String nickname;
    private String states;
    private String city;
    private Boolean isStudent;
    private Boolean isMarried;
    private Builder() {}
    public static NameSetter builder()                     { return new Builder(); }
    public NicknameSetter setName(String name)             { this.name = name;           return this; }
    public StatesSetter setNickname(String nickname)       { this.nickname = nickname;   return this; }
    public CitySetter setStates(String states)             { this.states = states;       return this; }
    public IsStudentSetter setCity(String city)            { this.city = city;           return this; }
    public IsMarriedSetter setIsStudent(Boolean isStudent) { this.isStudent = isStudent; return this; }
    public Builder setIsMarried(Boolean isMarried)         { this.isMarried = isMarried; return this; }
    public UserStep build() {
      // 必要に応じてここで状態の整合性チェック
      return new UserStep(this);
    }
  }
}
