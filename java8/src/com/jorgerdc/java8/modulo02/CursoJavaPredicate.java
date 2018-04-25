package com.jorgerdc.java8.modulo02;

import com.jorgerdc.java8.intro.Curso;

/**
 * Created by jorge on 13/08/17.
 */
public class CursoJavaPredicate implements  CursoPredicate {
    @Override
    public boolean test(Curso curso) {
        return curso.getNombre().toLowerCase().contains("java");
    }
}
