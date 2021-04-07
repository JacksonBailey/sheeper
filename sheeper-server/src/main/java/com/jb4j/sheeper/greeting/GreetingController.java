package com.jb4j.sheeper.greeting;

import com.jb4j.sheeper.api.GreetingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

  private final EverydayGreeting everydayGreeting;
  private final CowboyGreeting cowboyGreeting;

  @Autowired
  public GreetingController(EverydayGreeting everydayGreeting, CowboyGreeting cowboyGreeting) {
    this.everydayGreeting = everydayGreeting;
    this.cowboyGreeting = cowboyGreeting;
  }

  @PostMapping(path = "/greet",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.TEXT_PLAIN_VALUE)
  @ResponseBody
  public String greet(@RequestBody GreetingRequest request) {
    if (request.cowboy()) {
      return cowboyGreeting.greet(request.name());
    } else {
      return everydayGreeting.greet(request.name());
    }
  }

}
