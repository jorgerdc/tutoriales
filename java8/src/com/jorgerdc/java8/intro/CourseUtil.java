/**
 * CourseUtil.java
 * Creation Date: 26/04/2018, 20:09:08
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
import java.util.List;

import com.jorgerdc.java8.comun.Course;

/**
 * Utility Course class without using Java8 main features.
 */
public class CourseUtil {

	/**
	 * @param courses
	 * @param courseName
	 * @return
	 */
	public static List<Course> getCoursesByName(List<Course> courses, String courseName) {

		List<Course> javaCourses = new ArrayList<>();
		for (Course course : courses) {
			if (course.getName().toLowerCase().contains(courseName)) {
				javaCourses.add(course);
			}
		}
		return javaCourses;
	}

	/**
	 * @param courses
	 * @param maxPrice
	 * @return
	 */
	public static List<Course> getCoursesByMaxPrice(List<Course> courses,
		double maxPrice) {
		List<Course> javaCourses = new ArrayList<>();
		for (Course course : courses) {
			if (course.getPrice() <= maxPrice) {
				javaCourses.add(course);
			}
		}
		return javaCourses;
	}
}
