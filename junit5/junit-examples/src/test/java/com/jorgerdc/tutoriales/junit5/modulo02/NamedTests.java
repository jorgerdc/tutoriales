/**
 * NamedTests.java
 * Creation Date: 15 ene 2019, 22:50:23
 *
 * Copyright (C) The Project *junit-modulo01* Authors.
 *
 * This software was created for didactic and academic purposes.
 * It can be used and even modified by referring to the author
 * or project on GitHub. If the file is modified, add a note
 * after this paragraph saying that this file is a modified version.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */

package com.jorgerdc.tutoriales.junit5.modulo02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This example show how to use @DisplayName in JUnit 5
 */
@DisplayName("Arithmetic tests")
public class NamedTests {

  @Test
  @DisplayName(" 1 + 1 test")
  void sum() {
    assertEquals(2, 1 + 1, "Invalid result for 1 +1 ");
    // using lambda expressions. The construction of the message is delayed so it can
    // improve performance
    assertEquals(2, 1 + 1, () -> "Invalid result for  " + (1 + 1) + "Expensive message");
  }
}
