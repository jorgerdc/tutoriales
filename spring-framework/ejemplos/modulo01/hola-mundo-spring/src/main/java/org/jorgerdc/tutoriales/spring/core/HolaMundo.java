/**
 * HolaMundo.java
 * Creation Date: 26 sep. 2020, 18:13:48
 *
 * Copyright (C) 2019,2020  All rights reserved.
 * Use of this software is subject to the license terms.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */

package org.jorgerdc.tutoriales.spring.core;

/**
 * Hola Mundo con Spring
 * @author Jorge Rodríguez Campos (jorgerdc@gmail.com)
 */
public class HolaMundo {

  private String saludo;

  /**
   * @return
   */
  public String saluda() {
    return saludo;
  }

  /**
   * Set saludo.
   * @param saludo
   */
  public void setSaludo(String saludo) {
    this.saludo = saludo;
  }

}
