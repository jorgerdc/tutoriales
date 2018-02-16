/**
 * Este software puede ser modificado o utilizado haciendo referencia al autor. 15/02/2018
 */
package com.jorgerdc.rxjava;

/**
 * TODO: File description
 * 
 * @author Jorge A. Rodriguez Campos (jorgerdc@gmail.com)
 */
public class LibroDAO {

    private static final Libro[] libros = new Libro[] { new Libro("La Biblia", "001"),
            new Libro("Citas del Presidente Mao Tse-Tung", "002"), new Libro("Harry Potter", "003"),
            new Libro("El Señor de los Anillos", "004"), new Libro("El Alquimista", "005"),
            new Libro("El Código da Vinci", "006"), new Libro("Crepúsculo", "007"),
            new Libro("Lo que el viento se llevó ", "008") };

    public Libro[] getAll() {
        return libros;
    }
}
