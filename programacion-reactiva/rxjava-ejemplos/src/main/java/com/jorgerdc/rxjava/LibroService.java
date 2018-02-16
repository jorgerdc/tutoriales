/**
 * Este software puede ser modificado o utilizado haciendo referencia al autor. 15/02/2018
 */
package com.jorgerdc.rxjava;

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

}
