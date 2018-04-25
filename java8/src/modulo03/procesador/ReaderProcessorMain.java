/**
 * ReaderProcessorMain.java
 * Fecha de creación: 19/04/2018, 14:34:15
 *
 * Este software fue creado para fines didácticos y académicos.
 * Puede ser empleado e inclusive ser modificado haciendo referencia
 * al autor e indicando que se trata de una versión modificada.
 *
 */
package modulo03.procesador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * En este ejemplo, se crean expresiones lambda para representar la lògica que se
 * va a ejecutar al procesar un archivo de texto.
 * Esta técnica evita escribir còdigo repetitivo para crear instancias de un
 * {@link BufferedReader}.
 * El código repetitivo se escribe una sola vez en el método
 * {@link ReaderProcessorMain}{@link #processFile(String, ReaderProcessor)}. En
 * el método main únicamente se codifica el código funcional que es diferente en cada caso.
 * Historial de cambios
 * <b>Usuario Email Fecha Descripción</b>
 * Jorge Rodriguez jorgerdc@gmail.com 19/04/2018 Creación
 */

public class ReaderProcessorMain {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String result;

		System.out.println("1. Crea un processor que lee la primer linea del archivo");
		result = processFile("resources/datos.txt", (reader) -> reader.readLine());
		System.out.println(result);

		System.out.println("2. Crea un processor que lee las primeras 2 lineas");
		result = processFile("resources/datos.txt",
			(reader) -> reader.readLine() + "\n" + reader.readLine());
		System.out.println(result);

		System.out
			.println("3. Crea un processor que lee todas las lineas y las pasa a mayusculas");
		result = processFile("resources/datos.txt", (reader) -> {
			StringBuilder sb;
			String line;
			sb = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				sb.append(line.toUpperCase());
				sb.append("\n");
			}
			return sb.toString();
		});
		System.out.println(result);
	}

	/**
	 * Procesa un {@link BufferedReader}. La lógica que se emplea para procesar al
	 * archivo se pasa en el parámetro processor a través de una expresión lambda.
	 * @param file
	 * @param processor
	 * @return
	 */
	public static String processFile(String file, ReaderProcessor processor) {

		try (BufferedReader reader = new BufferedReader(new FileReader(new File(file)))) {
			return processor.procesa(reader);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
