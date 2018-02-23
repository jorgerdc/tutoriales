/**
 * Este software puede ser modificado o utilizado haciendo referencia al autor. 15/02/2018
 */
package com.jorgerdc.rxjava;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

/**
 * TODO: File description
 * 
 * @author Jorge A. Rodriguez Campos (jorgerdc@gmail.com)
 */
public class LibroService {

    private LibroDAO libroDAO = new LibroDAO();

    public Observable<Libro> getAll() {
        return Observable.fromArray(libroDAO.getAll());
    }

    /**
     * Versión sincrona
     */
    public List<Libro> getAllSync() {
        return Arrays.asList(libroDAO.getAll());
    }

}
