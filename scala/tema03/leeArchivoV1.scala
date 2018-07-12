/*
 * script: tema03/leeArchivoV1.scala
 * Lectura de un archivo de texto version 1
 */
import scala.io.Source

if(args.length >0){
	for(line <- Source.fromFile(args(0)).getLines()){
		println(line.length + " "+ line)
	}
}else{
	Console.err.println("Especificar una ruta valida de un archivo")
}