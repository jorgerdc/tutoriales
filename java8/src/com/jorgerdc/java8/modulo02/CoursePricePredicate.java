/**
 * CoursePricePredicate.java
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
package com.jorgerdc.java8.modulo02;

import com.jorgerdc.java8.intro.Course;

/**
 * CoursePredicate implementation using its price as criteria
 */
public class CoursePricePredicate implements CoursePredicate {

	private double initialPrice;

	private double finalPrice;

	/**
	 * @param costoInicial
	 * @param finalPrice
	 */
	public CoursePricePredicate(double costoInicial, double finalPrice) {
		this.initialPrice = costoInicial;
		this.finalPrice = finalPrice;
	}

	/*
	 * See the original documentation of the method declaration
	 * @see
	 * com.jorgerdc.java8.modulo02.CoursePredicate#test(com.jorgerdc.java8.intro.Course)
	 */
	@Override
	public boolean test(Course c) {
		return c.getPrice() >= initialPrice && c.getPrice() <= finalPrice;
	}
}
