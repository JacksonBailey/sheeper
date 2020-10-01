package com.jb4j.sheeper.greeting;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jb4j.sheeper.api.GreetingRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerIT {

  private final MockMvc mvc;
  private final ObjectMapper mapper;

  @Autowired
  public GreetingControllerIT(MockMvc mvc, ObjectMapper mapper) {
    this.mvc = mvc;
    this.mapper = mapper;
  }

  @Test
  void testBoringGreeting() throws Exception {
    GreetingRequest greetingRequest = GreetingRequest.builder()
      .cowboy(false)
      .name("Jackson")
      .build();

    mvc.perform(
      post("/greet")
        .accept(MediaType.TEXT_PLAIN)
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(greetingRequest))
    )
      .andExpect(status().isOk())
      .andExpect(content().string(equalTo("Hello, Jackson.")));
  }

  @Test
  void testFunGreeting() throws Exception {
    GreetingRequest greetingRequest = GreetingRequest.builder()
      .cowboy(true)
      .name("Jackson")
      .build();

    mvc.perform(
      post("/greet")
        .accept(MediaType.TEXT_PLAIN)
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(greetingRequest))
    )
      .andExpect(status().isOk())
      .andExpect(content().string(equalTo("Howdy, Jackson!")));
  }

}
