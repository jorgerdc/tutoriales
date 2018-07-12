import scala.io.Source

def getLongitudNumeroLinea(s: String) = s.length.toString.length

if(args.length >0){
	val lineas = Source.fromFile(args(0)).getLines().toList
	val lineaMasLarga = lineas.reduceLeft(
		(a,b) => if(a.length > b.length) a else b
	)
	val maxLongitud = getLongitudNumeroLinea(lineaMasLarga)
	for(linea <- lineas){
		val numEspacios = maxLongitud - getLongitudNumeroLinea(linea)
		val padding = " " * numEspacios
		println(padding + linea.length + " | " + linea)
	}

}else{
	Console.err.println("Especificar una ruta valida de un archivo")
}