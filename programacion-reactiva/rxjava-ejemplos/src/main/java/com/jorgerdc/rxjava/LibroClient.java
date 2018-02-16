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
        libroService.getAll().subscribe(System.out::println);
    }

    public static void main(String[] args) {

        new LibroClient().buscaLibros();
    }
}
