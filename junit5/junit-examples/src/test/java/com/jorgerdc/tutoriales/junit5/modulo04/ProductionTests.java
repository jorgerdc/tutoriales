/**
 * ProductionTests.java
 * Creation Date: 19 ene 2019, 0:17:58
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

import org.junit.platform.commons.annotation.Testable;

/**
 * This class executes test methods of this package tagged as "prod". See
 * {@link TestTagExamples}. In this class only two method should be executed on
 * production.
 */
@Testable
// @SelectPackages("com.jorgerdc.tutoriales.junit5.modulo04")
// @SelectClasses(TestTagExamples.class)
// @IncludeTags("prod")
public class ProductionTests {
  // no code needed
}
