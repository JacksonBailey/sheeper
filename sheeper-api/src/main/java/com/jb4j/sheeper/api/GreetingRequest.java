package com.jb4j.sheeper.api;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class GreetingRequest {

  private final String name;
  private final boolean cowboy;
}
