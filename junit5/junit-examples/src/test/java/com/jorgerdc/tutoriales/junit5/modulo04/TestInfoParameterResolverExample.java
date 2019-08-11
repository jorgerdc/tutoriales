/**
 * TestInfoParameterResolverExample.java
 * Creation Date: 25 ene 2019, 21:47:15
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This test class shows how to use TestInfoParameterResolver for dependency injection of
 * {@link TestInfo}
 */

@DisplayName("TestInfo class test")
public class TestInfoParameterResolverExample {

  private static final Logger log =
    LoggerFactory.getLogger(TestInfoParameterResolverExample.class);

  TestInfoParameterResolverExample(TestInfo testInfo) {
    log.debug("in constructor of test class {}", testInfo.getDisplayName());
    // note this string must be equals to the value of the @DisplayName of the test class
    assertEquals("TestInfo class test", testInfo.getDisplayName());
  }

  @Test
  @DisplayName("This is test 1")
  @Tag("dev")
  @Tag("qa")
  void test1(TestInfo testInfo) {
    log.debug("Running test with name {}", testInfo.getDisplayName());
    assertEquals("This is test 1", testInfo.getDisplayName());
    testInfo.getTags().forEach(tag -> assertTrue("dev".equals(tag) || "qa".equals(tag)));
  }

  @Test
  void test2(TestInfo testInfo) {
    log.debug("Running test with name {}", testInfo.getDisplayName());
    // in this case, tne name of the test is the method name: test2(TestInfo)
    assertEquals("test2(TestInfo)", testInfo.getDisplayName());
  }

  @BeforeEach
  void beforeEach(TestInfo testInfo) {
    log.debug("Before running test with name {}", testInfo.getDisplayName());
    assertTrue(testInfo.getDisplayName().equals("This is test 1")
      || testInfo.getDisplayName().equals("test2(TestInfo)"));
  }
}
