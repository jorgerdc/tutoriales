/**
 * ExceptionTests.java
 * Creation Date: 16 ene 2019, 16:12:18
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

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class shows how to write tests that throws exceptions.
 */

public class ExceptionTests {

  private static final Logger log = LoggerFactory.getLogger(ExceptionTests.class);

  /**
   * The test expects an {@link SQLException}. If it is not thrown, the test fails.
   */
  @Test
  void expectedException() {
    assertThrows(SQLException.class, () -> {
      log.debug("Throwing an expected exception");
      throw new SQLException("DB error");
    });
  }

  /**
   * Similar to the previous tests, but now showing how to reuse the exception.
   */
  @Test
  void reuseException() {
    Exception e;
    e = assertThrows(SQLException.class, () -> {
      log.debug("Throwing an expected exception");
      throw new SQLException("DB error");
    });
    log.debug("the following expected exception was thrown, Type: {}, message: {} ",
      e.getClass(), e.getMessage());
  }
}
