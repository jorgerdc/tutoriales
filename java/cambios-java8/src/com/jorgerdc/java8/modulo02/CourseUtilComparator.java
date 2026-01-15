/**
 * CourseUtilComparator.java
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

import static java.util.Arrays.asList;

import java.util.List;

import com.jorgerdc.java8.comun.Course;

/**
 * This class show how to create a comparator using a lambda expression.
 */
public class CourseUtilComparator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Course> cursos;

		cursos = asList(new Course("Java", 8500), new Course("WebServices", 18500));

		System.out.println("Sorting courses");
		cursos.sort((Course c1, Course c2) -> c1.getName().compareTo(c2.getName()));
		System.out.println(cursos);

	}
}
