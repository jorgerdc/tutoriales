/**
 * UserService.java
 * Creation Date: 20 ene 2019, 17:55:31
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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Simple Session service use to show how to group related test using @Nested.
 * This service has three dependencies: LoginDAO and UserDAO two Nested Inner
 * classes are created to group Login and User related tests. Session test are validated
 * at the top level test class.
 */

public class UserService {

  private Map<String, String> users;

  private Set<String> sessionUsers;

  /**
   * Constructor, init DB User and sessionUsers.
   */
  public UserService() {
    users = DBUtils.getUserList();
    sessionUsers = new HashSet<>();
  }

  /**
   * Login an existing user. Login means add the user to the sessionUser list.
   * @param username
   * @param password
   * @return
   */
  public boolean loginUser(String username, String password) {
    String dbPassword;
    if (username != null && !username.isEmpty() && password != null
      && !password.isEmpty()) {

      dbPassword = users.get(username);
      if (dbPassword == null || !dbPassword.equals(password)) {
        return false;
      } else {
        return true;
      }
    } else {
      return false;
    }
  }

  /**
   * Remove a user from the session list.
   * @param username
   * @return
   */
  public boolean logoutUser(String username) {
    if (username != null) {
      sessionUsers.remove(username);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Change password only if the user exists and the newPassword is not the same.
   * @param username
   * @param password
   * @param newPassword
   * @return
   */
  public boolean changePassword(String username, String password, String newPassword) {
    String dbPassword;
    if (username == null || username.isEmpty() || password == null || password.isEmpty()
      || newPassword == null || newPassword.isEmpty()) {
      return false;
    }

    dbPassword = users.get(username);
    // no username was found or new password is the same as the current
    if (dbPassword == null || dbPassword.equals(newPassword)) {
      return false;
    }
    users.put(username, newPassword);
    return true;

  }

}
