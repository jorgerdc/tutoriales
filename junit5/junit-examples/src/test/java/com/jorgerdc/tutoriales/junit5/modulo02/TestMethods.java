/**
 * TestMethods.java
 * Creation Date: 14 ene 2019, 21:14:43
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

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This example show the life cycle of a test class.
 */

public class TestMethods {

  private static int beforeAllCounter;

  private static int beforeEachCounter;

  private static int testCounter;

  private static int afterEachCounter;

  private static int afterAllCounter;

  private static final Logger log = LoggerFactory.getLogger(TestMethods.class);

  @BeforeAll
  private static void initAll() {
    log.debug("before all");
    beforeAllCounter++;
  }

  @BeforeEach
  private void init() {
    log.debug("before each");
    beforeEachCounter++;
  }

  @Test
  void testOne() {
    log.debug("test one");
    assertEquals(1, beforeAllCounter, "Invalid value for beforeAllCounter");
    assertEquals(1, beforeEachCounter, "Invalid value for beforeEachCounter");
    testCounter++;
  }

  @Test
  void testTwo() {
    log.debug("test two");
    assertEquals(1, beforeAllCounter, "Invalid value for beforeAllCounter");
    assertEquals(2, beforeEachCounter, "Invalid value for beforeEachCounter");
    testCounter++;
  }

  @Test
  void testThree() {
    log.debug("test three");
    assertEquals(1, beforeAllCounter, "Invalid value for beforeAllCounter");
    assertEquals(3, beforeEachCounter, "Invalid value for beforeEachCounter");
    testCounter++;
  }

  @Disabled
  private void disabled() {
    throw new RuntimeException(
      "This method should not be executed. Annotated with @Disabled");
  }

  @AfterEach
  private void tearDown() {
    log.debug("after each");
    afterEachCounter++;
  }

  @AfterAll
  private static void tearDownAll() {
    log.debug("after all");
    afterAllCounter++;
    assertEquals(3, beforeEachCounter, "Invalid value for testCounter");
    assertEquals(3, testCounter, "Invalid value for testCounter");
    assertEquals(3, afterEachCounter, "Invalid value for testCounter");
    assertEquals(1, beforeAllCounter, "Invalid value for beforeAllCounter");
    assertEquals(1, afterAllCounter, "Invalid value for afterAllCounter");
  }

}
