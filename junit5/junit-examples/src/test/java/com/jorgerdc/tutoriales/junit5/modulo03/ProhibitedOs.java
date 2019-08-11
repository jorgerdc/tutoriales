/**
 * TestOnLinuxMac.java
 * Creation Date: 17 ene 2019, 23:37:53
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

package com.jorgerdc.tutoriales.junit5.modulo03;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

/**
 * Custom annotation used to represent both Linux and Mac Os
 */
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
@DisabledOnOs({ OS.WINDOWS, OS.AIX, OS.SOLARIS })
public @interface ProhibitedOs {
  // no code
}
