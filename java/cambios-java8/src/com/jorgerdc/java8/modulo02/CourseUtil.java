/**
 * CourseUtil.java
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

import java.util.ArrayList;
import java.util.List;

import com.jorgerdc.java8.comun.Course;

/**
 * Utility class used to test {@link CoursePredicate} implementations.
 */
public class CourseUtil {

	/**
	 * Generic course filter
	 * @param courses
	 * @param p
	 * @return
	 */
	public static List<Course> filterCourses(List<Course> courses, CoursePredicate p) {

		List<Course> filteredCourses;
		filteredCourses = new ArrayList<>();
		for (Course course : courses) {
			if (p.test(course)) {
				filteredCourses.add(course);
			}
		}
		return filteredCourses;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Course> courses;
		CoursePredicate predicado;

		courses = asList(new Course("Java", 8500), new Course("WebServices", 18500));
		predicado = new JavaCoursePredicate();

		System.out.println("Java Courses");
		System.out.println(filterCourses(courses, predicado));

	}
}
