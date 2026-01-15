/**
 * ComparingMethodExample.java
 * Creation Date: 26/04/2018, 17:45:47
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

package com.jorgerdc.java8.modulo03;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.jorgerdc.java8.comun.Course;

/**
 * This example shows how to build a {@link Comparator} object using the
 * utility and static method {@link Comparator#comparing(java.util.function.Function)}
 */

public class ComparingMethodExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Course> courseList;

		courseList =
			Arrays.asList(new Course("Spring Framework", 230), new Course("Java 8", 130),
				new Course("Angular", 50), new Course("Zeppelin apache", 230));

		System.out.println("sorting courses using it's name:");
		courseList.sort(comparing(c -> c.getName()));
		System.out.println(courseList);

		System.out.println("sorting by name, then by price");
		courseList
			.sort(comparing(Course::getName).thenComparing(Course::getPrice).reversed());
		System.out.println(courseList);
	}
}
