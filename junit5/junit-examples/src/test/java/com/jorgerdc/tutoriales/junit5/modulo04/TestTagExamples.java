/**
 * TestTagExamples.java
 * Creation Date: 19 ene 2019, 0:08:30
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

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This test class shows how to use the @Tag annotation.
 */

public class TestTagExamples {

  private static final Logger log = LoggerFactory.getLogger(TestTagExamples.class);

  @Tag("dev")
  @Test
  void testA() {
    log.debug("Running test on development environment");
  }

  @Tag("qa")
  @Test
  void testB() {
    log.debug("Running test on quality server");
  }

  @Tag("prod")
  @Test
  void testC() {
    log.debug("Running test on production");
  }

  @Tag("dev")
  @Tag("qa")
  @Tag("prod")
  @Test
  void testD() {
    log.debug("Running test on all environments");
  }
}
