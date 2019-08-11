/**
 * RandomNamesParameterResolver.java
 * Creation Date: 25 ene 2019, 22:56:55
 *
 * Copyright (C) The Project *junit-examples* Authors.
 *
 * This software was created for didactic and academic purposes.
 * It can be used and even modified by referring to the author
 * or project on GitHub. If the file is modified, add a note
 * after this paragraph saying that this file is a modified version.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */

package com.jorgerdc.tutoriales.junit5.modulo04;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Parameter;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This implementation shows how to use the {@link ParameterResolver} interface
 * for dependency injection of random names of people.
 */

public class RandomNamesParameterResolver implements ParameterResolver {

  private static final Logger log =
    LoggerFactory.getLogger(RandomNamesParameterResolver.class);

  /**
   * Custom annotation used to identify parameters that can be injected using this
   * parameter resolver implementation
   */
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.PARAMETER)
  public @interface RandomName {
    // no code needed
  }

  /*
   * See the original documentation of the method declaration
   * @see
   * org.junit.jupiter.api.extension.ParameterResolver#supportsParameter(org.junit.jupiter
   * .api.extension.ParameterContext, org.junit.jupiter.api.extension.ExtensionContext)
   */
  @Override
  public boolean supportsParameter(ParameterContext parameterContext,
    ExtensionContext extensionContext) throws ParameterResolutionException {
    return parameterContext.isAnnotated(RandomName.class);
  }

  /*
   * See the original documentation of the method declaration
   * @see
   * org.junit.jupiter.api.extension.ParameterResolver#resolveParameter(org.junit.jupiter.
   * api.extension.ParameterContext, org.junit.jupiter.api.extension.ExtensionContext)
   */
  @Override
  public Object resolveParameter(ParameterContext parameterContext,
    ExtensionContext extensionContext) throws ParameterResolutionException {

    return getRandomValue(parameterContext.getParameter(), extensionContext);
  }

  private Object getRandomValue(Parameter parameter, ExtensionContext extensionContext) {
    Class<?> type = parameter.getType();
    String[] array = extensionContext.getRoot().getStore(Namespace.GLOBAL)
      .getOrComputeIfAbsent("names", key -> {
        log.debug("creating name array");
        return new String[] { "Mike", "Melli", "Paty" };
      }, String[].class);
    int random = (int) (Math.random() * array.length);
    if (String.class.equals(type)) {
      return new String(array[random]);
    }
    if (StringBuilder.class.equals(type)) {
      return new StringBuilder(array[random]);
    }
    throw new ParameterResolutionException("No Name generator implemented for " + type);
  }
}
