/**
 * Application.java
 * Creation Date: 17/07/2018, 18:43:26
 *
 * Copyright (C) The Project *properties-spring-boot* Authors.
 *
 * This software was created for didactic and academic purposes.
 * It can be used and even modified by referring to the author
 * or project on GitHub. If the file is modified, add a note
 * after this paragraph saying that this file is a modified version.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */

package com.jorgerdc.tutoriales.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application start point
 */
@SpringBootApplication
public class Application {

	/**
	 * Application main method
	 * @param args
	 */
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

}
