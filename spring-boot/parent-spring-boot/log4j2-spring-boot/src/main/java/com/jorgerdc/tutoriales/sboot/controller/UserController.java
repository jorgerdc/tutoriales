/**
 * UserController.java
 * Creation Date: 23 dic. 2019, 21:07:16
 *
 * Copyright (C) 2019,2019 The {COMPANY_NAME} and/or its affiliates.
 * All rights reserved. {COMPANY_NAME}/CONFIDENTIAL.
 * Use of this software is subject to the license terms.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */

package com.jorgerdc.tutoriales.sboot.controller;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorgerdc.tutoriales.sboot.entity.User;
import com.jorgerdc.tutoriales.sboot.service.UserInfoService;

/**
 * Sample controller used to show how to use and configure Log4J2 in spring boot
 */

@RestController
public class UserController {

  /**
   * Logger
   */
  private static final Logger logger = LogManager.getLogger(UserController.class);

  @Resource
  private UserInfoService userInfoService;

  /**
   * Get Sample User Info
   * @return
   */
  @RequestMapping("/userInfo")
  public User getUserInfo() {

    User user;

    logger.debug("Using the Service UserInfoService to get data of user 1 ");
    user = userInfoService.getUserInfo(10L);
    logger.debug("Done. User detail: {}", user);

    return user;
  }

}
