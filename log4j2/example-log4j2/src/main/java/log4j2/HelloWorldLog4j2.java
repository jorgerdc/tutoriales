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
 * Some log levels taking a properties file as the source of configuration.
 * In case of error the console will show error as:
 * ERROR StatusLogger No log4j2 configuration file found. Using default configuration:
 * logging only errors to the console.
 */
public class HelloWorldLog4j2 {

  private static final Logger logger = LogManager.getLogger(HelloWorldLog4j2.class.getName());

  /**
   * Method to show in differents log levels of some messages as example a good
   * configuration file.
   * @param args
   */
  public static void main(String[] args) {
    logger.info("This Will Be Printed On Info");
    logger.debug("This Will Be Printed On Debug");
    logger.warn("This Will Be Printed On Warn");
    logger.error("This Will Be Printed On Error");
    logger.fatal("This Will Be Printed On Fatal");
    logger.info("Appending string: {}.", "Hello, World");
  }
}
