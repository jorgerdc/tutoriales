package com.jorgerdc.java8.modulo02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jorgerdc.java8.intro.Curso;

/**
 * Created by jorge on 13/08/17.
 */
public class CursoUtil {

    public static List<Curso> filtraCursos(List<Curso> cursos, CursoPredicate predicado){

        List<Curso> cursosFiltrados;
        cursosFiltrados = new ArrayList<>();
        for(Curso curso: cursos){
            if(predicado.test(curso)){
                cursosFiltrados.add(curso);
            }
        }
            return  cursosFiltrados;
    }

    public static void main(String[] args) {

        List<Curso> cursos, cursosJava;
        CursoPredicate predicado;

        cursos = Arrays.asList(new Curso("Java", 8500),
            new Curso("WebServices",18500));
        predicado = new CursoJavaPredicate();

        System.out.println("Cursos de java");
        System.out.println(filtraCursos(cursos,predicado));

    }
}
