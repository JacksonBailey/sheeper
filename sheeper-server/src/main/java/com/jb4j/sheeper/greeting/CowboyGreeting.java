package com.jb4j.sheeper.greeting;

import com.jb4j.sheeper.api.Greeting;
import org.springframework.stereotype.Component;

@Component
public class CowboyGreeting implements Greeting {

  @Override
  public String greet(String name) {
    return String.format("Howdy, %s!", name);
  }
}
