/**
 * UserServiceTest.java
 * Creation Date: 20 ene 2019, 19:16:23
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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This test case shows how to use @Nested. The idea is to create two Nested classes.
 * Every class is used to test a group of related test methods. Group 1: loging tests.
 * Group 2: password tests. At top level the service is initialized, so, nested classes
 * can reuse this object. Every nested class has its own methods to initialize specific
 * stuff.
 */

public class UserServiceTest {

  private static final Logger log = LoggerFactory.getLogger(UserServiceTest.class);

  private UserService userService;

  @BeforeEach
  void beforeEach() {
    log.debug("Init UserService");
    userService = new UserService();
  }

  @Nested
  @DisplayName("Testing Login feature")
  class LoginTests {

    private Map<String, String> testingUsers;

    @BeforeEach
    void beforeEach() {
      log.debug("Init login data for Login tests");
      testingUsers = new HashMap<>();
      testingUsers.put("u1", "pwd1");
      testingUsers.put("u2", "pwd-wrong");
    }

    @Test
    void usernameAndPasswordAreValid() {
      assertTrue(userService.loginUser("u1", testingUsers.get("u1")));
    }

    @Test
    void passwordIsInvalid() {
      assertFalse(userService.loginUser("u2", testingUsers.get("u2")));
    }

    @Test
    void emptyLoginAndNullPassword() {
      assertFalse(userService.loginUser("", null));
    }
  }

  @Nested
  @DisplayName("Testing password feature")
  class PasswordTests {

    private Map<String, String> testingUsers;

    @BeforeEach
    void beforeEach() {
      log.debug("Init login data for password tests");
      testingUsers = new HashMap<>();
      testingUsers.put("u1", "pwd1");
      testingUsers.put("u2", "pwd2");
    }

    @Test
    void newPasswordIsValid() {
      assertTrue(
        userService.changePassword("u1", testingUsers.get("u1"), "new-password"));
    }

    @Test
    void newPasswordIsTheSame() {
      assertFalse(
        userService.changePassword("u2", testingUsers.get("u2"), testingUsers.get("u2")));
    }

    @Test
    void newPasswordIsEmpty() {
      assertFalse(userService.changePassword("u2", testingUsers.get("u2"), ""));
    }
  }
}
