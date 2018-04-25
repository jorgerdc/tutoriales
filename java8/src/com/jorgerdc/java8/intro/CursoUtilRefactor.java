package com.jorgerdc.java8.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by jorge on 02/07/17.
 */
public class CursoUtilRefactor {

    /**
     * @param c
     * @return
     */
    public static boolean isJava(Curso c) {
        return c.getNombre().toLowerCase().contains("java");
    }

    /**
     * @param c
     * @param costoMaximo
     * @return
     */
    public static boolean isCostoMenor(Curso c, double costoMaximo) {
        return c.getCosto() <= costoMaximo;
    }

    /**
     * @param cursos
     * @param p
     * @return
     */
    public static List<Curso> filtraCursos(List<Curso> cursos, Predicate<Curso> p) {

        List<Curso> cursosFiltrados = new ArrayList<>();
        for (Curso c : cursos) {
            if (p.test(c)) {
                cursosFiltrados.add(c);
            }
        }
        return cursosFiltrados;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        List<Curso> cursos, cursosJava;

        cursos = Arrays.asList(new Curso("Java", 8500), new Curso("WebServices", 18500));

        cursosJava = CursoUtilRefactor.filtraCursos(cursos, CursoUtilRefactor::isJava);

        System.out.println("Cursos de java");
        System.out.println(cursosJava);

    }
}
