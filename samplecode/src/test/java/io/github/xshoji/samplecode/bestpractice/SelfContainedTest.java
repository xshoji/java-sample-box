package io.github.xshoji.samplecode.bestpractice;

import io.github.xshoji.samplecode.bestpractice.testingtarget.User;
import io.github.xshoji.samplecode.bestpractice.testingtarget.UserDao;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.net.http.HttpClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

public class SelfContainedTest extends SelfContainedTestBase {

  public class DatabaseConfiguration {
    public Connection setupConnection() {
      try {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/sample", // "jdbc:postgresql://<場所>:<ポート>/<データベース名>"
                "postgres", //user
                "postgres"); //password;
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
      return null;
    }
  }

  public class HttpClientConfiguration {
    public HttpClient setupClient() {
      return HttpClient.newHttpClient();
    }
  }

  public class CacheManager {
    public void initCache() {

    }
  }

  @RequiredArgsConstructor
  public class CompanyDao {
    private final Connection connection;
    private final HttpClient httpClient;
    public List<Company> getAll() {
      return Arrays.asList(new Company(1111L, "Apple"));
    }
  }

  @Getter
  @EqualsAndHashCode
  @RequiredArgsConstructor
  public class Company {
    public final Long id;
    public final String name;
  }

  @Test
  public void extendedTest() {
    // Given ( load data is loaded in SelfContainedTestBase )
    UserDao dao = new UserDao();

    // When
    List<User> actualUsers = dao.getAll();

    // Then
    User expectedUser = new User(1111L, "John");
    assertThat(actualUsers, is(containsInAnyOrder(expectedUser)));
  }

  @Test
  public void compositionTest() {
    // Given
    new CacheManager().initCache();
    CompanyDao dao = new CompanyDao(
            new DatabaseConfiguration().setupConnection(),
            new HttpClientConfiguration().setupClient()
    );

    // When
    List<Company> actualCompanies = dao.getAll();

    // Then
    Company expectedCompany = new Company(1111L, "Apple");
    assertThat(actualCompanies, is(containsInAnyOrder(expectedCompany)));
  }
}
