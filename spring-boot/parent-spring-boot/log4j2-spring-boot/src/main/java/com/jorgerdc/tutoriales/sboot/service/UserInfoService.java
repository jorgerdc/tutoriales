/**
 * UserInfoService.java
 * Creation Date: 23 dic. 2019, 20:59:22
 *
 * Copyright (C) 2019,2019 The {COMPANY_NAME} and/or its affiliates.
 * All rights reserved. {COMPANY_NAME}/CONFIDENTIAL.
 * Use of this software is subject to the license terms.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */

package com.jorgerdc.tutoriales.sboot.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jorgerdc.tutoriales.sboot.entity.User;

/**
 * Sample service used to generate random user data
 */

@Service
public class UserInfoService {

  /**
   * Logger
   */
  private static final Logger logger = LogManager.getLogger(UserInfoService.class);

  /**
   * Builds a sample {@link User} object. The attribute values are always the same.
   * The propose of this sample service is just to show how to user Log4J2 with
   * spring boot.
   * @param id The user id
   * @return a sample {@link User} object
   */
  public User getUserInfo(Long id) {

    User user;
    logger.debug("Building sample user data for id {}", id);

    user = new User();
    user.setId(id);
    user.setUsername("sampleUser");
    user.setPassword("samplePassword");
    user.setEmail("sample.user@mail.com");
    return user;
  }

}
