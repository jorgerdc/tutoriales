/**
 * CourseUtilRefactor.java
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
package com.jorgerdc.java8.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Refactor of {@link CourseUtil} class using some new features of Java8
 */
public class CourseUtilRefactor {

	/**
	 * @param c
	 * @return
	 */
	public static boolean isJava(Course c) {
		return c.getName().toLowerCase().contains("java");
	}

	/**
	 * @param c
	 * @param maxPrice
	 * @return
	 */
	public static boolean isPriceLessThan(Course c, double maxPrice) {
		return c.getPrice() <= maxPrice;
	}

	/**
	 * @param courses
	 * @param p the predicate to apply ( Lambda expression)
	 * @return
	 */
	public static List<Course> filterCourses(List<Course> courses, Predicate<Course> p) {

		List<Course> filteredCourses = new ArrayList<>();
		for (Course c : courses) {
			if (p.test(c)) {
				filteredCourses.add(c);
			}
		}
		return filteredCourses;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Course> courses, cursosJava;

		courses = Arrays.asList(new Course("Java", 8500), new Course("WebServices", 18500));

		cursosJava = CourseUtilRefactor.filterCourses(courses, CourseUtilRefactor::isJava);

		System.out.println("Cursos de java");
		System.out.println(cursosJava);

	}
}
