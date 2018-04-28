/**
 * CourseUtilAnonymousClass.java
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

import com.jorgerdc.java8.intro.Course;

/**
 * Course filter using an anonymous class
 */
public class CourseUtilAnonymousClass {

	/**
	 * For every course on the list of courses, the Course predicate is applied using
	 * the test method of the parameter p
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

		courses = asList(new Course("Java", 8500), new Course("WebServices", 18500));
		System.out.println("Java courses");
		System.out.println(filterCourses(courses, new CoursePredicate() {
			@Override
			public boolean test(Course course) {
				return course.getName().toLowerCase().contains("java");
			}
		}));
	}
}
