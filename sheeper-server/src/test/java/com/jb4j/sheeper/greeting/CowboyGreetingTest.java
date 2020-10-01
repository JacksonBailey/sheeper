package com.jb4j.sheeper.greeting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CowboyGreetingTest {

  private CowboyGreeting cowboyGreeting = new CowboyGreeting();

  @Test
  void test() {
    assertEquals("Howdy, Jackson!", cowboyGreeting.greet("Jackson"));
  }
}
