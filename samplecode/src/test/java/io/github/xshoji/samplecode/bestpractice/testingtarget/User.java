package io.github.xshoji.samplecode.bestpractice.testingtarget;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class User {
  public final Long id;
  public final String name;
  @Setter
  public LocalDateTime dateTime;
}
