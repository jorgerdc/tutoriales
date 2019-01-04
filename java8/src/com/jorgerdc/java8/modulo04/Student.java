/**
 * Student.java
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

package com.jorgerdc.java8.modulo04;

/**
 * POJO Student
 */
public class Student {

  private long id;

  private String name;

  private double weight;

  private double height;

  private int semester;

  /**
   * @param id
   * @param name
   * @param weight
   * @param height
   * @param semester
   */
  public Student(long id, String name, double weight, double height, int semester) {
    super();
    this.id = id;
    this.name = name;
    this.weight = weight;
    this.height = height;
    this.semester = semester;
  }

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the weight
   */
  public double getWeight() {
    return weight;
  }

  /**
   * @param weight the weight to set
   */
  public void setWeight(double weight) {
    this.weight = weight;
  }

  /**
   * @return the height
   */
  public double getHeight() {
    return height;
  }

  /**
   * @param height the height to set
   */
  public void setHeight(double height) {
    this.height = height;
  }

  /**
   * @return the semester
   */
  public int getSemester() {
    return semester;
  }

  /**
   * @param semester the semester to set
   */
  public void setSemester(int semester) {
    this.semester = semester;
  }

  /*
   * See the original documentation of the method declaration
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Student [id=");
    builder.append(id);
    builder.append(", name=");
    builder.append(name);
    builder.append(", weight=");
    builder.append(weight);
    builder.append(", height=");
    builder.append(height);
    builder.append(", semester=");
    builder.append(semester);
    builder.append("]");
    return builder.toString();
  }

}
