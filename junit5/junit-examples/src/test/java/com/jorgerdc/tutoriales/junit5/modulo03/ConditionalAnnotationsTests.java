/**
 * ConditionalAnnotationsTests.java
 * Creation Date: 16 ene 2019, 19:40:39
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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This test class shows how to use the conditional test annotations
 */
public class ConditionalAnnotationsTests {

  private static final Logger log =
    LoggerFactory.getLogger(ConditionalAnnotationsTests.class);

  /**
   * Not execute this test on Weekend!. Javascript code is used as a Script using
   * the value parameter (String array). This script is evaluated using Oracle nashorn as
   * a engine. Note that the last line of this script is a boolean expression. This result
   * is used to decide if the test will be disabled or executed.
   * Example 1, using @DisabledIf
   */
  @DisabledIf(value = {
    //@formatter:off
    "var d = new Date();",
    "var day = d.getDay()",
    "day == 0 || day ==6"
    //@formatter:on
  }, engine = "nashorn", reason = "This test is disabled on weekend: Sunday(day =0),"
    + " saturday(day =6). Current day: {result} ")
  @Test
  void disabledOnWeekend() {
    LocalDate localDate;
    DayOfWeek today;
    localDate = LocalDate.now();
    today = localDate.getDayOfWeek();
    assertTrue(today != DayOfWeek.SATURDAY && today != DayOfWeek.SUNDAY,
      "This tests should not be executed on weekend");
    log.debug("Executing  this test on {}", today);
  }

  /**
   * Example 2. This tests is disabled if a random number less than 0.5 is
   * generated. In this case Java code is used as a Script.
   */
  @DisabledIf(value = "Math.random()<0.5")
  @Test
  void disabledRandomly() {
    log.debug("This test execute randomly ");
  }

  /**
   * Example 3: Using @DisabledIfEnvironmentVariable.
   */
  @DisabledIfEnvironmentVariable(named = "USER", matches = ".*jorge.*")
  @Test
  void disableIfUserJorge() {
    String user;
    user = System.getProperty("user.name");
    assertNotEquals("jorge", user,
      () -> "This test should not be executed by user " + user);
    log.debug("This test is executed by user {}  User jorge is prohibited.");
  }

  /**
   * Example 4: This test should be disabled if the Operating System is Mac.
   */
  @DisabledIfSystemProperty(named = "os.name", matches = ".*Mac.*")
  @Test
  void disabledIfMac() {
    String os;
    os = System.getProperty("os.name");
    log.debug("Current operating system: {}", os);
    assertNotNull(os);
    assertFalse(os.contains("Mac"), "This test should not be executed on Mac");
  }

  /**
   * Example 5: Don`t execute this test for specific JRE Version.
   * {@link JRE} Enum is used as parameter of @DisabledOnJRE
   */
  @DisabledOnJre(JRE.JAVA_9)
  @Test
  void disabledForJRE9() {
    log.debug("This test will be disabled if Java 9 is used");
  }

  /**
   * Example 6: Don`t Execute this test for specific JRE Version
   */
  @DisabledOnOs(OS.SOLARIS)
  @Test
  void disableOnSomeOs() {
    log.debug("This test will be disabled if Solaris is used");
  }

  /**
   * Example 7: Using a custom Annotation (Meta annotated). @ProhibitedOs is a
   * custom annotation that avoids writing
   * <code>@DisabledOnOs({ OS.WINDOWS, OS.AIX, OS.SOLARIS})</code>
   */
  @Test
  @ProhibitedOs
  void disabledOnSeveralOs() {
    log.debug("This test will be disabled if Solaris, Win or AIX is used");
  }
}
