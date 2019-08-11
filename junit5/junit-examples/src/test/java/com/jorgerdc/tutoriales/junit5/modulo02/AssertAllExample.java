/**
 * AssertAllExample.java
 * Creation Date: 16 ene 2019, 0:12:35
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

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * This example shows how to test multiple assertions using <code>assertAll</code>.
 * All assertions are evaluated before reporting any failure or error.
 */

public class AssertAllExample {

  @Test
  void multipleAssertions() {

    int[] values = { 1, 2, 3, 4, 5 };
    // change the second parameter to see the list of failed assertions.
    assertAll("Multiple validations",
      () -> assertEquals(values[0], 1, "Invalid result for values[0]"),
      () -> assertEquals(values[1], 2, "Invalid result for values[1]"),
      () -> assertEquals(values[2], 3, "Invalid result for values[2]"),
      () -> assertEquals(values[3], 4, "Invalid result for values[3]"),
      () -> assertEquals(values[4], 5, "Invalid result for values[4]"));

  }

}
