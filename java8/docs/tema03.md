## 3. Expresiones Lambda

### Definición de expresión Lambda
* Representación concisa de una función anónima que puede ser  empleada como parámetro de otras funciones o ser referenciada por una variable.
* No define un nombre.
* Define lista de parámetros, cuerpo de la función, valor de retorno y posibles excepciones que puede lanzar.
* Se emplea la palabra *función* ya  que esta no está asociada a ninguna clase en particular.   
	* Un *método* siempre está asociado a una clase.
* Es concisa por su sintaxis simple. Permiten pasar código de forma simple.
* Permiten implementar el patrón: *Parametrización del comportamiento* 
* Resultado: código  más claro, flexible

##### Ejemplo:

```Java
Comparator<Curso>  comparatorOld,  comparatorLambda;
// antes de Java 8 (uso de clases anónimas)
comparatorOld = new Comparator<Curso>() {
   @Override
   public int compare(Curso o1, Curso o2) {
       return o1.getNombre().compareTo(o2.getNombre());
   }
};
// java 8
comparatorLambda = (Curso o1, Curso o2) -> o1.getNombre().compareTo(o2.getNombre());
```
### Elementos de una Expresión Lambda

* Lista de parámetros
* Flecha:  Separa a la lista de parámetros  del cuerpo de la expresión lambda.
* Cuerpo de la expresión Lambda.

### Estructura de una expresión Lambda.
* Existen 2 estilos de sintaxis:
```Java
// 1.  Una sola expresión el valor de retorno se infiere
(parametros) -> expresión

// 2. Más de una sentencia, requiere llaves. Si se desea regresar un
// valor se requiere el uso de return, en otro caso se considera void.
(parametros) -> {sentencias;}

```
##### Ejemplos: 
```Java  
//1. Regresa un valor entero. La instrucción return no es requerida
(String s) -> s.length()

//2. Acepta 2 parámetros tipo int, no regresa valor (void)
(int x,int y) -> {
	System.out.print(x+y);
}

//3.  No acepta parámetros. Regresa el valor 42 (expresión)
() -> 42

//4. Mismo caso, pero la expresion lambda está formada por statements (requiere {} y el uso de return).
() -> { return 42; }

//5. No acepta parámetros no regresa valor (void), cuerpo vacío
() -> {}
```
### ¿Dónde emplear expresiones Lambda?
* En general se emplean dentro del contexto de una *Interface funcional* .
* Lo anterior significa que una expresión lambda, además de ser asignada a una variable, puede ser pasada como parámetro de un  método  cuyo tipo de dato corresponde al de una Interface, en este caso a una *Interface funcional*.
##### Ejemplo:
``` Java
File myFiles;
String[] filteredFiles;
myFiles = new File("/tmp");
filteredFiles = myFiles
	.list((file, fileName) -> file.canWrite() && fileName.endsWith(".txt"));
}
```
* En este ejemplo,  se realiza un filtrado de archivos. 
* Se obtienen todos aquellos archivos ubicados en  `/tmp` que tengan permisos de escritura y sean archivos de texto.
* El método `list` acepta un objeto `FilenameFilter`.  
* `FilenameFilter` es una interface que define un solo método:
```Java
boolean accept( File dir,String name);
```
* Esta interface es implementada y representada por la expresión lambda del ejemplo. 
* Observar que la estructura de la expresión coincide con la firma del método `accept`:  Recibe 2 parámetros  `(File,String)` y regresa un `boolean` 
* Al existir dicha coincidencia, la expresión lambda puede  *implementar* al método  `accept`y al ser el  único método de la interfaz, la expresión lambda *implementa  funcionalmente a* `FilenameFilter`.
* De lo anterior, si una Interface declara  un solo método, se le puede llamar *Interface funcional*.
* Observar que en este ejemplo, el tipo de dato de los parámetros no es necesario ya que estos se infieren al  ser empleada como parámetro del método `list`.
* Notar que una misma expresión lambda pudiera implementar a varias interfaces funcionales  siempre y cuando su estructura sea *compatible* con la firma del método de la interface. 

### Interfaces funcionales.
* Como se mencionó anteriormente, una interface funcional define un solo método abstracto.
* En el API de Java existen varias interfaces que pueden ser re-bautizadas como Interfaces funcionales:
	* `Comparable`
	* `Runnable`
	* `FilenameFilter`
	* `ActionListener`, etc.
* En Java 8 se han agregado nuevas interfaces funcionales.
* La importancia de las interfaces funcionales es que  estas pueden ser implementadas por una expresión lambda!.
##### Ejemplo:
```Java
Runnable r = () -> System.out.println("Hola Mundo Lambda");
```
* La firma del método de la interface funcional corresponde o describe a la firma  o estructura de la expresión lambda.  En este contexto al método abstracto de la interface funcional se le llama  *descriptor funcional*.
* En el ejemplo anterior,   la expresión lambda corresponde con el *descriptor funcional* de la interface ```Runnable```
```Java
void run();
```
#### @FunctionalInterface
* Esta anotación se emplea en interfaces para indicar que  se trata de una interface funcional. 
* No es obligatoria, pero si recomendada si  la interface fue diseñada para tal propósito.
* El compilador verificará las condiciones antes descritas y generará error en caso de que la interface contenga más de un método abstracto ya sea de forma directa o por herencia.
* La interface puede ser funcional aunque contenga  definiciones de métodos (default methods).

##### Ejemplo:
* Crear un programa que procese  un archivo a través de un `BufferedReader`. 
* Este archivo se puede procesar varias veces con diferente lógica (lógica funcional).
* Suponer los siguientes casos funcionales (ficticios).
	* Caso 1: Leer la primer línea del archivo
	* Caso 2:  Leer 2 líneas del archivo
	* Caso 3: Leer todo el archivo y pasarlo a minúsculas.
* Implementar el concepto de *Parametrización del comportamiento*.  
* Código repetitivo:  
	* Instanciar la clase `BufferedReader`
	* Transformar  `IOException`a `RuntimeException`
	* Liberar o cerrar el reader.
* El código repetitivo se deberá programar una sola vez, y  la lógica funcional se va a parametrizar (caso1, caso2 y caso3) empleando expresiones lambda.
##### Solución
* Para emplear una expresión  lambda se define la siguiente interface funcional:
```Java
@FunctionalInterface
public interface ReaderProcessor {
	String procesa(BufferedReader reader) throws IOException;
}
``` 
* El método recibe un `BuffferedReader` para realizar el procesamiento de su contenido.
* Se tiene un método de utilería que implementa el código repetitivo:
```Java
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
```
* Este método crea una instancia de `BufferedReader` e  invoca al método `procesa` del objeto que recibe como segundo parámetro el cual contiene la lógica funcional a ejecutar.   Las instancias de `ReaderProcessor`pueden ser enviadas a este método como expresiones lambda:
```Java

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
		.println("3. Crea un processor para leer todas las lineas en mayusculas");
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
```

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTIzOTg1Nzk5OCwtMzc4OTQ5LC0xNzQwNT
kwNDQyLDMxNDEyMTQ2MSwtNzgzODUwMjg4LDE1NjIxMTU5MTks
MTg3MDcwMDU4NSwtMTMwODM2MTU0MiwtMjE0MTc0NzQ0NiwtMT
EzNDM5NDk2MCw5OTI3NjExMTUsLTE0MTcxNTQzMzldfQ==
-->