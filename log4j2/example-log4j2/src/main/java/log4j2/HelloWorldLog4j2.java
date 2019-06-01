/**
 * HelloWorldLog4j2.java
 * Creation Date: Jun 1, 2019, 3:47:16 PM
 *
 * Copyright (C) The Project *log4j2* Authors.
 *
 * This software was created for didactic and academic purposes.
 * It can be used and even modified by referring to the author
 * or project on GitHub. If the file is modified, add a note
 * after this paragraph saying that this file is a modified version.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */
package log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Basic class to show in console some levels log, taking properties file as main
 * configuration.
 * In case of error the console will show error as:
 * ERROR StatusLogger No log4j2 configuration file found. Using default configuration:
 * logging only errors to the console.
 */
public class HelloWorldLog4j2 {

  private static final Logger LOGGER = LogManager.getLogger(HelloWorldLog4j2.class.getName());

  /**
   * Method to show in differents log levels of some messages as example a good
   * configuration file.
   * @param args
   */
  public static void main(String[] args) {
    LOGGER.debug("Debug Message Logged !!!");
    LOGGER.info("Info Message Logged !!!");
    LOGGER.error("Error Message Logged !!!", new NullPointerException("NullError"));
  }
}
