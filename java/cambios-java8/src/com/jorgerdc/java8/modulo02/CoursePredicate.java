/**
 * CoursePredicate.java
 * Creation Date: 11/04/2018, 20:09:08
 *
 * Copyright (C) The Project *java8-01-basico* Authors.
 *
 * This software was created for didactic and academic purposes.
 * It can be used and even modified by referring to the author
 * or project on GitHub. If the file is modified, add a note
 * after this paragraph saying that this file is a modified version.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */
package com.jorgerdc.java8.modulo02;

import java.util.function.Predicate;

import com.jorgerdc.java8.comun.Course;

/**
 * This simple interface represents a Predicate using {@link Course} objects.
 * Note that there is a functional interface {@link Predicate} that can be used
 * instead of this class. This topic will be reviewed later.
 */
public interface CoursePredicate {

	/**
	 * Apply this predicate.
	 * @param c
	 * @return
	 */
	boolean test(Course c);
}
