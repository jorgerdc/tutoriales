/**
 * ReaderProcessorMain.java
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
package com.jorgerdc.java8.modulo03.procesador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * In this example some lambda expressions are created to represent functional logic which
 * will be executed to process a text file through {@link BufferedReader}.
 * This strategy avoids writing repetitive code for every {@link BufferedReader} instance.
 * The repetitive code is written only once using
 * {@link ReaderProcessorMain}{@link #processFile(String, ReaderProcessor)}
 * The main method contains the functional code which is different in every case. The idea
 * of this example is to
 * implement the concept of behavior parameterization.
 */
public class ReaderProcessorMain {

  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    String result;

    System.out
      .println("Case 1. Functional code to read  the first line of the file only.");
    result = processFile("resources/data.txt", (reader) -> reader.readLine());
    System.out.println(result);

    System.out.println("Case 2. Read first and second line of the file only");
    result = processFile("resources/data.txt",
      (reader) -> reader.readLine() + "\n" + reader.readLine());
    System.out.println(result);

    System.out.println("Case 3. Read all line and convert them to upper case.");
    result = processFile("resources/data.txt", (reader) -> {
      StringBuilder sb;
      String line;
      sb = new StringBuilder();
      while ((line = reader.readLine()) != null) {
        sb.append(line.toUpperCase());
        sb.append("\n");
      }
      return sb.toString();
    });
    System.out.println(result);
  }

  /**
   * This method executes the logic that is passed to this method using the processor
   * parameter.
   * This method is invoked from main using expression lambda.
   * @param file
   * @param processor
   * @return
   */
  public static String processFile(String file, ReaderProcessor processor) {

    try (BufferedReader reader = new BufferedReader(new FileReader(new File(file)))) {
      return processor.procesa(reader);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
