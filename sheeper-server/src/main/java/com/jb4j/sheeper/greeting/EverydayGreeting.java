package com.jb4j.sheeper.greeting;

import com.jb4j.sheeper.api.Greeting;
import org.springframework.stereotype.Component;

@Component
public class EverydayGreeting implements Greeting {

  @Override
  public String greet(String name) {
    return String.format("Hello, %s.", name);
  }
}
