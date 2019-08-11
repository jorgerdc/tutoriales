/**
 * TestRandomNameExample.java
 * Creation Date: 25 ene 2019, 23:52:00
 *
 * Copyright (C) The Project *junit-examples* Authors.
 *
 * This software was created for didactic and academic purposes.
 * It can be used and even modified by referring to the author
 * or project on GitHub. If the file is modified, add a note
 * after this paragraph saying that this file is a modified version.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */

package com.jorgerdc.tutoriales.junit5.modulo04;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jorgerdc.tutoriales.junit5.modulo04.RandomNamesParameterResolver.RandomName;

/**
 * This test class
 */
@ExtendWith(RandomNamesParameterResolver.class)
public class TestRandomNameExample {

  private static final Logger log = LoggerFactory.getLogger(TestRandomNameExample.class);

  @Test
  void randomNumber(@RandomName String n1, @RandomName StringBuilder n2) {
    log.debug("Generated random names: {},{}", n1, n2);
    assertTrue(() -> checkRandomName(n1), "Invalid random name");
    assertTrue(() -> checkRandomName(n2.toString()), "Invalid random name");
  }

  @Test
  void moreRandomNames(@RandomName String n1) {
    log.debug("More generated random name: {}", n1);
    assertTrue(() -> checkRandomName(n1), "Invalid random name");

  }

  boolean checkRandomName(String name) {
    return name.equals("Mike") || name.equals("Melli") || name.equals("Paty");
  }
}
