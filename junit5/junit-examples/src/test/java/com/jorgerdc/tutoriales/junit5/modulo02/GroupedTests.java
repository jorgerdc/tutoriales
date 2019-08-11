/**
 * GroupedTests.java
 * Creation Date: 16 ene 2019, 11:53:44
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This test class shows how to make assertion groups.
 * Every group is executed independently. If a assertion fails, the following assertion
 * in the same group are not executed.
 */
public class GroupedTests {

  private static final Logger log = LoggerFactory.getLogger(GroupedTests.class);

  @Test
  void groupAssertions() {
    String[] persons = { "John", "Mike", "Peter" };
    String[] fruits = { "Apple", "Banana", "Coconut" };

    String[] colors = { "Red", "Blue", "Pink" };

    // the following assertAll has 3 groups: persons, fruits and colors. All the three
    // groups will
    // be processed independently

    assertAll("Words", () -> {
      // if the first assertion fails, the following will not be executed.
      log.debug("Processing name group");
      assertEquals("John", persons[0]);
      assertEquals("Mike", persons[1]);
      assertEquals("Peter", persons[2]);
    }, () -> {
      log.debug("Processing fruit group");
      assertEquals("Apple", fruits[0]);
      assertEquals("Banana", fruits[1]);
      // uncomment the following assertion to produce an error. In the output you will see
      // that all groups are still executed, but the Coconut validation won't be
      // processed.

      // assertEquals("Grapes", fruits[2]);

      log.debug("Processing Coconut group");
      assertEquals("Coconut", fruits[2]);
    }, () -> {
      log.debug("Testing  color group");
      // here we have a nested assertAll. In this case, all the assertion of this group
      // will be processed independently, it does not matter if some of them fails.
      assertAll("Colors", () -> assertEquals("Red", colors[0]),
        () -> assertEquals("Blue", colors[1]), () -> assertEquals("Pink", colors[2]));
    },
      // the last group is using method references. the checkAnimals method match the
      // Executable functional interface, so we can use as a method reference.
      this::checkAnimals);
  }

  private void checkAnimals() {
    String[] animals = { "Cat", "Dog", "Bird" };
    log.debug("Processing Animal group");
    assertAll("Animals", () -> assertEquals("Cat", animals[0]),
      () -> assertEquals("Dog", animals[1]), () -> assertEquals("Bird", animals[2]));
  }
}
