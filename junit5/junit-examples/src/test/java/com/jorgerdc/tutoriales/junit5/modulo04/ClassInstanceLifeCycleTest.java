/**
 * ClassInstanceLifeCycleTest.java
 * Creation Date: 20 ene 2019, 14:06:10
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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class test is used to show @TestInstance. Instead of creating a new instance
 * of this class for every method test, just one instance will be created.
 */
@TestInstance(Lifecycle.PER_CLASS)
class ClassInstanceLifeCycleTest {

  private static int instanceCount;

  /**
   * This property is used to simulate a shared property used by method tests. Suppose
   * that the value of this property must be 10 before running. If a test method change
   * it`s value, it must be reseted to 10 since only one instance is created. This
   * behavior can be implemented using @BeforeEach and @AfterEach
   */
  private int sharedProperty;

  private static final Logger log =
    LoggerFactory.getLogger(ClassInstanceLifeCycleTest.class);

  /**
   * Constructor used to validate the number of instances created to executed all
   * test methods.
   */
  ClassInstanceLifeCycleTest() {
    log.debug("Creating a new instance of ClassInstanceLifeCycleTest ");
    instanceCount++;
  }

  /**
   * If a test class is using PER_INSTANCE value as instance class life cycle, make sure
   * to reset possible instance attributes which share common data. In this example,
   * the <code>sharedProperty</code> instance attribute must be reseted to 10.
   */
  @BeforeEach
  void init() {
    log.debug("reset sharedProperty to 10 before running");
    this.sharedProperty = 10;
  }

  @Test
  void testOne() {
    log.debug("test one");
    assertEquals(1, instanceCount, "Only one instance should be created");
    assertEquals(10, sharedProperty, "initial value of sharedProperty must be 10");
    // change a shared instance property
    sharedProperty = 1;
  }

  @Test
  void testTwo() {
    log.debug("test two");
    assertEquals(1, instanceCount, "Only one instance should be created");
    assertEquals(10, sharedProperty, "initial value of sharedProperty must be 10");
    // change a shared instance property
    sharedProperty = 2;
  }

  @Test
  void testThree() {
    log.debug("test three");
    assertEquals(1, instanceCount, "Only one instance should be created");
    assertEquals(10, sharedProperty, "initial value of sharedProperty must be 10");
    // change a shared instance property
    sharedProperty = 2;
  }

}
