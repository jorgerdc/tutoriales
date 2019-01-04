/**
 * ComparingMethodExample.java
 * Creation Date: 26/04/2018, 17:45:47
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
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 */
public class MethodReferencesExample {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // example 1
    List<String> list;
    list = Arrays.asList("M", "j", "x", "0", "a");
    list.sort(String::compareToIgnoreCase);
    System.out.println(list);

    // example 2
    // without method references
    Supplier<String> supplier = () -> "hello";
    System.out.println("s1: " + supplier.get());
    // with method references
    supplier = String::new;

    System.out.println("s2: " + supplier.get());

    // example 3
    // without method references
    Function<String, File> fx1 = (path) -> new File(path);
    File myFile = fx1.apply("/tmp/nonextisting.txt");
    System.out.println(myFile.getAbsolutePath());
    // with method references
    fx1 = File::new;
    myFile = fx1.apply("/tmp/nonextisting.txt");
    System.out.println(myFile.getAbsolutePath());
  }

}
