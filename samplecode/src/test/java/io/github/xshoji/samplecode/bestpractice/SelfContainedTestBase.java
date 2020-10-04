package io.github.xshoji.samplecode.bestpractice;

import org.junit.Before;

public class SelfContainedTestBase {
  @Before
  public void setup() {
    // Setup database
    System.out.println("Setup database");
    // Setup http client
    System.out.println("Setup http client");
    // Setup cache setting
    System.out.println("Setup cache setting");
  }
}
