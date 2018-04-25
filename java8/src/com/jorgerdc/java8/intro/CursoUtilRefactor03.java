package com.jorgerdc.java8.intro;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jorge on 02/07/17.
 */
public class CursoUtilRefactor03 {

    public static void main(String[] args) {
        List<Curso> cursos, cursosJava, cursosBaratos;

        cursos = Arrays.asList(new Curso("Java", 8500), new Curso("WebServices", 18500));

        cursosJava = cursos.stream()
            .filter((Curso c) -> c.getNombre().toLowerCase().contains("java"))
            .collect(Collectors.toList());

        cursosBaratos = cursos.stream().filter((Curso c) -> c.getCosto() <= 10000)
            .collect(Collectors.toList());

        System.out.println("Cursos de java");
        System.out.println(cursosJava);

        System.out.println("Cursos baratos");
        System.out.println(cursosBaratos);
    }
}
