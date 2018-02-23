/**
 * Este software puede ser modificado o utilizado haciendo referencia al autor. 15/02/2018
 */
package com.jorgerdc.rxjava;

/**
 * TODO: File description
 * 
 * @author Jorge A. Rodriguez Campos (jorgerdc@gmail.com)
 */
public class LibroClient {

    private LibroService libroService = new LibroService();

    private void buscaLibros() {

        // uso básico
        // libroService.getAll().subscribe(System.out::println);

        // empleando operaciones de los Streams
        libroService.getAll().map(libro -> libro.getNombre()).subscribe(System.out::println);

        // version sincrona
        // libroService.getAllSync().stream().map(libro -> libro.getNombre())
        // .forEach(System.out::println);
    }

    public static void main(String[] args) {

        new LibroClient().buscaLibros();
    }
}
