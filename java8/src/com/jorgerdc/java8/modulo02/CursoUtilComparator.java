package com.jorgerdc.java8.modulo02;

import java.util.Arrays;
import java.util.List;

import com.jorgerdc.java8.intro.Curso;

/**
 * Created by jorge on 13/08/17.
 */
public class CursoUtilComparator {

    public static void main(String[] args) {

        List<Curso> cursos, cursosJava;

        cursos = Arrays.asList(new Curso("Java", 8500),
            new Curso("WebServices",18500));

        System.out.println("Ordenando cursos");
        cursos.sort((Curso c1, Curso c2) -> c1.getNombre().compareTo(c2.getNombre()));
        System.out.println(cursos);


    }
}
