/**
 * ProcesadorArchivos.java
 * Fecha de creación: 19/04/2018, 14:20:23
 *
 * Este software fue creado para fines didácticos y académicos.
 * Puede ser empleado e inclusive ser modificado haciendo referencia
 * al autor e indicando que se trata de una versión modificada.
 *
 */
package modulo03.procesador;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO [Agregar documentación de la clase
 * Historial de cambios
 * <b>Usuario Email Fecha Descripción</b>
 * Jorge Rodriguez jorgerdc@gmail.com 19/04/2018 Creación
 */

@FunctionalInterface
public interface ReaderProcessor {

    /**
     * Este método contiene el código funcional para procesar un {@link BufferedReader}
     * Esta idea permite separar la parte funcional del código de la parte de manejo de
     * recursos, en este caso instanciar el {@link BufferedReader} y su liberación de recursos.
     * @param reader
     * @return Una cadena que resulta del procesamiento del archivo.
     * @throws IOException
     */
    String procesa(BufferedReader reader) throws IOException;
}
