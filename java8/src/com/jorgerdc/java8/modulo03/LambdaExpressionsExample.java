/**
 * LambdaExpressionsExample.java
 * Creation Date: 19/04/2018, 14:34:15
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

import java.io.File;
import java.util.Comparator;

import com.jorgerdc.java8.comun.Course;

/**
 * Examples of some lambda expressions
 */
public class LambdaExpressionsExample {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Comparator<Course> oldComparator, lambdaComparator;

		// Before Java 8 (using anonymous class)
		oldComparator = new Comparator<Course>() {
			@Override
			public int compare(Course o1, Course o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		// java 8
		lambdaComparator = (Course o1, Course o2) -> o1.getName().compareTo(o2.getName());

		// Using lambda expression as a parameter of a method, using the concept of
		// functional interface.
		File myFiles;

		String[] filteredFiles;
		myFiles = new File("/tmp");
		filteredFiles =
			myFiles.list((file, fileName) -> file.canWrite() && fileName.endsWith(".txt"));
	}
}
