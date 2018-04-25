package com.jorgerdc.java8.modulo02;

import com.jorgerdc.java8.intro.Curso;

/**
 * Created by jorge on 13/08/17.
 */
public class CursoCostoPredicate implements CursoPredicate {

    private double costoInicial;

    private double costoFinal;

    public CursoCostoPredicate(double costoInicial, double costoFinal) {
        this.costoInicial = costoInicial;
        this.costoFinal = costoFinal;
    }

    @Override
    public boolean test(Curso c) {
        return c.getCosto() >= costoInicial && c.getCosto() <= costoFinal;
    }
}
