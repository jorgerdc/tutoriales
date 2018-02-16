/**
 * Este software puede ser modificado o utilizado haciendo referencia al autor. 15/02/2018
 */
package com.jorgerdc.rxjava;

/**
 * TODO: File description
 * 
 * @author Jorge A. Rodriguez Campos (jorgerdc@gmail.com)
 */
public class Libro {

    private String nombre;

    private String clave;

    /**
     * @param nombre
     * @param clave
     */
    public Libro(String nombre, String clave) {
        super();
        this.nombre = nombre;
        this.clave = clave;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre
     *        the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave
     *        the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Libro [nombre=");
        builder.append(nombre);
        builder.append(", clave=");
        builder.append(clave);
        builder.append("]");
        return builder.toString();
    }

}
