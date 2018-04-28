/**
 * ReaderProcessor.java
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
package com.jorgerdc.java8.modulo03.procesador;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * {@link BufferedReader} Processor modeled as a functional interface.
 */
@FunctionalInterface
public interface ReaderProcessor {

	/**
	 * This method is used to process a {@link BufferedReader} object .
	 * The strategy is to separate the functional code from the code that is
	 * needed to handle the {@link BufferedReader} creation and the code used to release
	 * resources. The functional code will we passed as a parameter using lambda
	 * expressions.
	 * @param reader
	 * @return A String object that represents the processing result.
	 * @throws IOException if something goes wrong. This avoid handling exception directly
	 *         inside the lambda expression.
	 */
	String procesa(BufferedReader reader) throws IOException;
}
