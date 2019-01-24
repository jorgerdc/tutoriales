/**
 * AssumptionsExample.java
 * Creation Date: 16 ene 2019, 18:46:41
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

package com.jorgerdc.tutoriales.junit5.modulo03;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.lang.reflect.Executable;
import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class shows how to use JUnit assumptions.
 */

public class AssumptionsExample {

  private static final Logger log = LoggerFactory.getLogger(AssumptionsExample.class);

  /**
   * Real case: If the test is not running on a Quality server, it won't execute.
   */
  @Test
  void executeOnQualityServer() {
    assumeTrue("QA".equals(System.getProperty("server.type")), "Checking QA server");
    log.debug(
      "this line and the next won't be executed since the previous condition is false");
    fail("This line won`t execute");
  }

  /**
   * Using <code>assumeTrue</code> but now with a
   * {@link java.util.function.BooleanSupplier}
   */
  @Test
  void executeOnDevServer() {

    log.debug("before checking assumption for Dev server");
    assumeTrue(() -> {
      log.debug("Checking if we are running on Dev server");
      // some logic here
      return false;
    });
    fail("This line won't be executed, so the test will succeed.");
  }

  /**
   * Real case: Execute this test if the execution environment is a Continuous Integration
   * Server using <code>assumingThat</code>. The code that is conditioned for execution is
   * now encapsulated in a {@link Executable} object (lambda expression).
   */
  @Test
  void executeOnCIServer() {
    log.debug("before checking assumption for CI server");
    assumingThat("CI".equals(System.getProperty("server.type")), () -> {
      fail("This line won't execute, so the test will succeed.");
    });
    log.debug("after assumingThat");
  }

  /**
   * Using a {@link BooleanSupplier} and a {@link Executable}. In this case
   * the code inside the executable object will be executed because the condition is true.
   */
  @Test
  void executeOnRealServer() {
    log.debug("This test will execute");
    assumingThat(() -> true, () -> {
      log.debug("This Executable will execute since the condition is true");
    });
  }
}
