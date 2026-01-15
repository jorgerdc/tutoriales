/**
 * CourseOrderingJava8.java
 * Creation Date: 21/08/2018, 19:29:58
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

package com.jorgerdc.java8.modulo01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.jorgerdc.java8.comun.Course;

/**
 * This class shows how to Order a Course List using Java 7
 */
public class CourseOrderingJava8 {

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		List<Course> courses;

		courses = Arrays.asList(new Course("Web Services", 7899.3),
			new Course("Java 8", 2100), new Course("C programming", 3400));

		courses.sort(Comparator.comparing(Course::getName));

		System.out.println(courses);

	}

}
