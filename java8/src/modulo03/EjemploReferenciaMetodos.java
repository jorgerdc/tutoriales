/**
 * EjemploReferenciaMetodos.java
 * Fecha de creación: 19/04/2018, 17:10:45
 *
 * Este software fue creado para fines didácticos y académicos.
 * Puede ser empleado e inclusive ser modificado haciendo referencia
 * al autor e indicando que se trata de una versión modificada.
 *
 */
package modulo03;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Historial de cambios
 * <b>Usuario Email Fecha Descripción</b>
 * Jorge Rodriguez jorgerdc@gmail.com 19/04/2018 Creación
 */

public class EjemploReferenciaMetodos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ejemplo 1
		List<String> lista;
		lista = Arrays.asList("M", "j", "x", "0", "a");
		lista.sort(String::compareToIgnoreCase);
		System.out.println(lista);

		// ejemplo 2
		// sin referencia a métodos
		Supplier<String> supplier = () -> "hola";
		System.out.println("s1: " + supplier.get());
		// con referencia a métodos
		supplier = String::new;

		System.out.println("s2: " + supplier.get());

		// ejemplo 3
		// sin referencia a metodos
		Function<String, File> fx1 = (path) -> new File(path);
		File myFile = fx1.apply("/tmp/noexiste.txt");
		System.out.println(myFile.getAbsolutePath());
		// con referencia a metodos
		fx1 = File::new;
		myFile = fx1.apply("/tmp/noexiste.txt");
		System.out.println(myFile.getAbsolutePath());
	}

}
