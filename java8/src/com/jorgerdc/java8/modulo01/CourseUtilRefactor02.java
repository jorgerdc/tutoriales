/**
 * CourseUtilRefactor02.java
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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.jorgerdc.java8.comun.Course;

/**
 * Second Refactor of {@link CourseUtil} class. It shows more Java8 features.
 */
public class CourseUtilRefactor02 {

  /**
   * @param courses
   * @param p
   * @return
   */
  public static List<Course> filterCourses(List<Course> courses, Predicate<Course> p) {

    List<Course> cursosFiltrados = new ArrayList<>();
    for (Course c : courses) {
      if (p.test(c)) {
        cursosFiltrados.add(c);
      }
    }
    return cursosFiltrados;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {

    List<Course> courses, javaCourses, cheapCourses;

    courses = asList(new Course("Java", 8500), new Course("WebServices", 18500));

    javaCourses = filterCourses(courses, c -> c.getName().toLowerCase().contains("java"));

    cheapCourses = filterCourses(courses, (Course c) -> c.getPrice() <= 10000);

    System.out.println("Java courses:");
    System.out.println(javaCourses);

    System.out.println("Cheap courses:");
    System.out.println(cheapCourses);

  }

}
