/**
 * NestedTest.java
 * Creation Date: 20 ene 2019, 15:56:18
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

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This test class does not have a particular meaning, it just shows how tne @Nested
 * tag works using inner classes.
 */

public class NestedTest {
  
  private static final Logger log = LoggerFactory.getLogger(NestedTest.class);

  @BeforeAll
  static void beforeAll() {
    log.debug("before all Test methods");
  }

  @BeforeEach
  void beforeEach() {
    log.debug("before each test - Main class");
  }

  @Nested
  class TestA {

    @BeforeEach
    void beforeEach() {
      log.debug("before each test - Test A class");
    }

    @Nested
    class TestAA {

      @BeforeEach
      void beforeEach() {
        log.debug("before each test - Test AA class");
      }

      @Test
      void testA() {
        log.debug("running testAA - Test AA class");
      }

      @AfterEach
      void afterEach() {
        log.debug("after each test - Test AA class");
      }
    }

    @AfterEach
    void afterEach() {
      log.debug("after each test - Test A class");
    }

  }

  @AfterEach
  void afterEach() {
    log.debug("after each test - Main class");
  }

  @AfterAll
  static void afterAll() {
    log.debug("after all Test methods");
  }

}
