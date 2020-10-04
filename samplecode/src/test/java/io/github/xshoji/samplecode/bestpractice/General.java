package io.github.xshoji.samplecode.bestpractice;

import io.github.xshoji.samplecode.bestpractice.testingtarget.*;
import org.junit.Before;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class General {
  @Test
  public void getTest() {
    // Given
    UserGetRequest request = new UserGetRequest(1111L);
    UserDao dao = new UserDao();

    // When
    User actualUser = dao.get(request);

    // Then
    User expectedUser = new User(1111L, "John");
    assertThat(actualUser, is(expectedUser));
  }

  @Test
  public void formatBadTest() {
    // Given
    Instant currentInstant = Instant.now();
    EpochSecondFormatter formatter = new EpochSecondFormatter();

    // When
    String actualDate = formatter.format(currentInstant); // DATE: 20201003

    // Then
    String expectedDate = createExpectedString(currentInstant);
    assertThat(actualDate, is(expectedDate));
  }

  @Test
  public void formatGoodTest() {
    // Given
    Instant fixedInstant = Instant.ofEpochSecond(1601739774);
    EpochSecondFormatter formatter = new EpochSecondFormatter();

    // When
    String actualDate = formatter.format(fixedInstant); // DATE: 20201003

    // Then
    String expectedDate = createExpectedString(fixedInstant);
    assertThat(actualDate, is(expectedDate));
  }

  @Test
  public void getByIdGreaterThanVariableIdTest() {
    // Given
    Long id1 = 10L;
    Long id2 = 20L;
    Long id3 = 30L;
    UserFilter userFilter = new UserFilter(Arrays.asList(
            createUserWithId(id1),
            createUserWithId(id2),
            createUserWithId(id3)
    ));

    // When
    List<User> actualUsers = userFilter.getByIdGreaterThan(15L);

    // Then
    assertThat(actualUsers.size(), is(2));
    assertThat(actualUsers, is(containsInAnyOrder(createUserWithId(id2), createUserWithId(id3))));
  }

  @Test
  public void getByIdGreaterThanTest() {
    // Given
    UserFilter userFilter = new UserFilter(Arrays.asList(
            createUserWithId(10L),
            createUserWithId(20L),
            createUserWithId(30L)
    ));

    // When
    List<User> actualUsers = userFilter.getByIdGreaterThan(15L);

    // Then
    assertThat(actualUsers.size(), is(2));
    assertThat(actualUsers, is(containsInAnyOrder(createUserWithId(20L), createUserWithId(30L))));
  }


  private static List<User> targetUsers;

  /**
   * ダメな例
   */
  @Before
  public void setup() {
    targetUsers = Arrays.asList(
            createUserWithId(10L),
            createUserWithId(20L),
            createUserWithId(30L)
    );
  }

  @Test
  public void getByIdGreaterThanTestWithBeforeSetup() {
    // Given
    UserFilter userFilter = new UserFilter(targetUsers);

    // When
    List<User> actualUsers = userFilter.getByIdGreaterThan(15L);

    // Then
    assertThat(actualUsers.size(), is(2));
    assertThat(actualUsers, is(containsInAnyOrder(createUserWithId(20L), createUserWithId(30L))));
  }

  @Test
  public void getByIdGreaterThanTestIncludesSetup() {
    // Given
    List<User> targetUsers = createUsersHavingIdFrom10To30();
    UserFilter userFilter = new UserFilter(targetUsers);

    // When
    List<User> actualUsers = userFilter.getByIdGreaterThan(15L);

    // Then
    assertThat(actualUsers.size(), is(2));
    assertThat(actualUsers, is(containsInAnyOrder(createUserWithId(20L), createUserWithId(30L))));
  }

  private String createExpectedString(Instant instant) {
    return "DATE: " + LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
  }

  private User createUserWithId(Long id) {
    return new User(id, "test");
  }

  public List<User> createUsersHavingIdFrom10To30() {
    return Arrays.asList(
            createUserWithId(10L),
            createUserWithId(20L),
            createUserWithId(30L)
    );
  }
}
