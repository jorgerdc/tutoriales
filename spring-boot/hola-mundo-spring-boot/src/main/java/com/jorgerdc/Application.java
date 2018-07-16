/**
 * Application.java
 * Creation Date: 08/07/2018, 23:54:55
 *
 * Copyright (C) The Project *raven-course-spring-boot* Authors.
 *
 * This software was created for didactic and academic purposes.
 * It can be used and even modified by referring to the author
 * or project on GitHub. If the file is modified, add a note
 * after this paragraph saying that this file is a modified version.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */

package com.jorgerdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Application Main class for this project.
 */
@RestController
@SpringBootApplication
public class Application {

	/**
	 * @return
	 */
	@RequestMapping("/")
	public String home() {
		return "Hello World";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
