/**
 * MessageServiceTest.java
 * Creation Date: 14 ene 2019, 17:57:44
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

package com.jorgerdc.tutoriales.junit5.modulo01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * MessageService Test case for JUnit 5 using a custom Annotation
 * <code>@TestSecurity</code>
 */
@TestSecurity
public class MessageServiceMetaTest {

  /**
   * Test methods are annotate with @Test<br>
   * Methods don't have to be <code>public</code><br>
   * Methods must not return a value.
   */
  @Test
  void checkHelloWorldMessage() {
    MessageService service = new MessageService();
    Assertions.assertEquals("Hello World!", service.helloWorld(), "Invalid message");
  }
}
