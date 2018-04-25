package com.jorgerdc.java8.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by jorge on 02/07/17.
 */
public class CursoUtilRefactor02 {

    public static List<Curso> filtraCursos(List<Curso> cursos, Predicate<Curso> p) {

        List<Curso> cursosFiltrados = new ArrayList<>();
        for (Curso c : cursos) {
            if (p.test(c)) {
                cursosFiltrados.add(c);
            }
        }
        return cursosFiltrados;
    }

    public static void main(String[] args) {

        List<Curso> cursos, cursosJava, cursosBaratos;

        cursos = Arrays.asList(new Curso("Java", 8500), new Curso("WebServices", 18500));

        cursosJava = CursoUtilRefactor.filtraCursos(cursos,
            (Curso c) -> c.getNombre().toLowerCase().contains("java"));

        cursosBaratos = CursoUtilRefactor.filtraCursos(cursos,
            (Curso c) -> c.getCosto() <= 10000);

        System.out.println("Cursos de java");
        System.out.println(cursosJava);

        System.out.println("Cursos baratos");
        System.out.println(cursosBaratos);

    }

}
