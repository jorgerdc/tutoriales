package com.jorgerdc.java8.intro;

/**
 * POJO Curso
 * 
 * <pre>
 * Historial de cambios
 * <b>Usuario		    Email				  Fecha	     Descripción</b>
 * Jorge Rodriguez	    jorgerdc@gmail.com	  11/04/2018	 Creación
 * </pre>
 */
public class Curso {

    private double costo;

    private String nombre;

    /**
     * @param nombre
     * @param costo
     */
    public Curso(String nombre, double costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    /**
     * @return the costo
     */
    public double getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
     * Ver la documentación en la declaración del método (clase o interface).
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Curso{");
        sb.append("costo=").append(costo);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
