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
package com.jorgerdc.java8.intro;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

/**
 * This example gets hidden files of a directory before and after Java8.
 */
public class HiddenFilesExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		showHiddenFilesJava7();
		showHiddendFilesJava8();
	}

	/**
	 * Shows hidden files using imperative programming style.
	 */
	private static void showHiddenFilesJava7() {
		File[] hiddenFiles;

		System.out.println("Showing hidden files before Java8. Verbose..");
		hiddenFiles =
			new File(System.getProperty("java.io.tmpdir")).listFiles(new FileFilter() {
				@Override
				public boolean accept(File f) {
					return f.isHidden();
				}
			});
		for (File file : hiddenFiles) {
			System.out.println(file.getAbsolutePath());
		}

	}

	/**
	 * Shows hidden files using lambda expressions and method references.
	 */
	private static void showHiddendFilesJava8() {
		List<File> files;

		System.out.println("Showing hidden files with Java8 :");
		files = Arrays.asList(
			new File(System.getProperty("java.io.tmpdir")).listFiles(File::isHidden));
		files.forEach(System.out::println);

	}
}
