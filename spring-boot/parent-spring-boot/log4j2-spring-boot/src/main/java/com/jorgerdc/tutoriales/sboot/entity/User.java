/**
 * User.java
 * Creation Date: 23 dic. 2019, 21:01:08
 *
 * Copyright (C) 2019,2019 The {COMPANY_NAME} and/or its affiliates.
 * All rights reserved. {COMPANY_NAME}/CONFIDENTIAL.
 * Use of this software is subject to the license terms.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */

package com.jorgerdc.tutoriales.sboot.entity;

/**
 * User - POJO
 */

public class User {

  private Long id;

  private String username;

  private String password;

  private String email;

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * @param username the username to set
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /*
   * See the original documentation of the method declaration
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("User [id=");
    builder.append(id);
    builder.append(", username=");
    builder.append(username);
    builder.append(", password=");
    builder.append(password);
    builder.append(", email=");
    builder.append(email);
    builder.append("]");
    return builder.toString();
  }

}
