/**
 * CourseUtilRefactor03.java
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
package com.jorgerdc.java8.modulo01;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.stream.Collectors;

import com.jorgerdc.java8.comun.Course;

/**
 * Third refactor of {@link CourseUtil} class. It shows more Java8 features.
 */
public class CourseUtilRefactor03 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    List<Course> courses, javaCourses, cheapCourses;

    courses = asList(new Course("Java", 8500), new Course("WebServices", 18500));

    javaCourses = courses.stream().filter(c -> c.getName().toLowerCase().contains("java"))
      .collect(Collectors.toList());

    cheapCourses = courses.stream().filter((Course c) -> c.getPrice() <= 10000)
      .collect(Collectors.toList());

    System.out.println("Java courses");
    System.out.println(javaCourses);

    System.out.println("Cheap courses");
    System.out.println(cheapCourses);
  }
}
