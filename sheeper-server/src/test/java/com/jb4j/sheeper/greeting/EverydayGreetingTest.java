package com.jb4j.sheeper.greeting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EverydayGreetingTest {

  private EverydayGreeting everydayGreeting = new EverydayGreeting();

  @Test
  void test() {
    assertEquals("Hello, Jackson.", everydayGreeting.greet("Jackson"));
  }
}
