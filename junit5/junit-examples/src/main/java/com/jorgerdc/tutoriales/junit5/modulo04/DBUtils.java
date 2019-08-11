/**
 * DBUtils.java
 * Creation Date: 20 ene 2019, 18:22:55
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

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a simple User Database
 */

public class DBUtils {

  static Map<String, String> getUserList() {
    Map<String, String> users;
    users = new HashMap<>();
    users.put("u1", "pwd1");
    users.put("u2", "pwd2");
    users.put("u3", "pwd3");
    users.put("u4", "pwd4");
    users.put("u5", "pwd5");
    return users;
  }
}
