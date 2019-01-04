/**
 * StudentMockDAO.java
 * Creation Date: 26/04/2018, 20:17:15
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

package com.jorgerdc.java8.modulo04;

import java.util.Arrays;
import java.util.List;

/**
 * Student Mock DAO used for testing
 */
public class StudentMockDAO {

  /**
   * @return Get all students.
   */
  public static List<Student> getStudents() {
    return Arrays.asList(new Student(1, "John", 81, 1.7, 3),
      new Student(2, "Mike", 74.9, 1.77, 8), new Student(3, "Susan", 67, 1.6, 5),
      new Student(4, "Jio", 84, 1.5, 9), new Student(5, "Michel", 71, 1.8, 1),
      new Student(6, "Gio", 89, 1.9, 9));
  }

}
