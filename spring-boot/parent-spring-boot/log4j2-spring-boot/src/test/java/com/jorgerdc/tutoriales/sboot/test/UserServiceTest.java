/**
 * UserServiceTest.java
 * Creation Date: 23 dic. 2019, 21:35:52
 *
 * Copyright (C) 2019,2019 The {COMPANY_NAME} and/or its affiliates.
 * All rights reserved. {COMPANY_NAME}/CONFIDENTIAL.
 * Use of this software is subject to the license terms.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */

package com.jorgerdc.tutoriales.sboot.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jorgerdc.tutoriales.sboot.entity.User;
import com.jorgerdc.tutoriales.sboot.service.UserInfoService;

/**
 * Simple User service test
 */

@SpringBootTest
public class UserServiceTest {

  @Resource
  private UserInfoService userInfoService;

  /**
   * Logger
   */
  private static final Logger logger = LogManager.getLogger(UserServiceTest.class);

  /**
   * Simple JUnit 5 test used to invoke a service to get user data.
   */
  @Test
  public void getTestInfo() {
    User user;

    user = userInfoService.getUserInfo(10L);
    logger.debug("Get User Info from JUnit: {}", user);

    assertNotNull(user);
    assertNotNull(user.getId());
    assertNotNull(user.getUsername());
    assertNotNull(user.getPassword());
    assertNotNull(user.getEmail());

  }
}
