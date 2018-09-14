# Java 8
## 1. Introducción
### 1.1 Principales características de Java 8
* Java 8  lanzada en marzo del 2014 representa  a la versión con la mayor cantidad de cambios a fondo que se haya tenido desde el lanzamiento del JDK 1.0 en 1996.
* Uno de los principales objetivos de estos cambios es la posibilidad de escribir código más simple y conciso, evitando código repetitivo, verboso.
#####  Ejemplo:
* Suponer que se tiene  la siguiente clase que define a un objeto ```Course``` 
```java
public  class Course {
	private  double  price;
	private String name;
	//getters & setters
}
```
* Suponer que se tiene una lista de objetos ```Course```, escribir un programa que realice el ordenamiento de  estos objetos empleando como criterio de ordenamiento el nombre del curso.
	* Antes de Java 8
```java
public class CourseOrderingJava7 {

	public static void main(String[] args) {
		List<Course> courses;
		courses = Arrays.asList(new Course("Web Services", 7899.3),
			new Course("Java 8", 2100), new Course("C programming", 3400));
		
		courses.sort(new Comparator<Course>() {
			@Override
			public int compare(Course o1, Course o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		System.out.println("Ordered course list: " + courses);
	}
}
```
 * En Java 8 se tiene lo siguiente:
 ```java
 public class CourseOrderingJava8 {
	public static void main(String[] args) {
		List<Course> courses;

		courses = Arrays.asList(new Course("Web Services", 7899.3),
			new Course("Java 8", 2100), new Course("C programming", 3400));
		
		//nuevo en Java8 (por ahora no se requiere comprender):
		courses.sort(Comparator.comparing(Course::getName));
		System.out.println(courses);
	}
} 
```
 * A nivel  de hardware también existen mejoras.  Un programa en Java puede aprovechar la capacidad multi-core de los procesadores sin que el programador tenga que hacer uso de programación multi-hilos haciendo uso de los complicados *Threads*
 * En Java 5 se agregaron algunas mejoras como son: Thread pools y colecciones concurrentes.
 * En Java 7 se incorpora el framework Fork/Join haciendo el paralelismo más práctico, pero un tanto complicado.
 *Adicional las características vistas hasta el momento, Java 8 ofrece:
	 * Stream API
	 * Técnicas de pasar código a métodos:  Parametrización del comportamiento
	 * Métodos default en interfaces
	 * Otras ideas de la programación funcional.
### 1.2 Stream API.
* A modo de introducción, un Stream representa a una secuencia de datos (elementos) que son producidos por una fuente. Un programa en Java puede leer y/o escribir estos elementos. La salida de uno puede ser la entrada de otro. Algo similar al proceso de pipeling en linux:
```bash
cat file1 file2 | tr "[a-z]" "[A-Z]" | sort | tail -3
```
* El comando ```cat```crea un stream concatenando el contenido de los 2 archivos.
* el comando ```tr```  crea un nuevo stream tomando a cada uno de los caracteres del stream convirtiéndolos  a mayúsculas. 
* El comando ```sort```realiza el ordenamiento lexicográfico de cada linea del archivo, generando un nuevo stream.
* El comando ```tail``` obtiene las  últimas 3 palabras ordenas (ya no crea un nuevo stream). y las imprime en consola.
* Cada una de estas operaciones puede ser ejecutada con cierto nivel de paralelismo. No se necesita que ```cat``` termine de ejecutarse antes de que ```tr``` comience a transformar las primeras líneas.
* En Java 8  un Stream está representado por ```java.util.stream.Stream<T>``` : secuencia de elementos tipo ```T```
* * El uso de Streams permite un estilo de programación a un nivel  mayor de abstracción.  Una analogía de lo anterior son las sentencias SQL, en las que se escribe lo que se desea obtener. Se especifica el "Qué" y no el "Cómo" se obtiene los datos.
* Otra ventaja es la posibilidad de hacer "pipeline" empleando la capacidad multi-core de los procesadores de forma transparente.
### 1.2 Parametrización del comportamiento.
- Suponer 2 métodos con código similar.
- Solo algunas líneas son diferentes.
- En Java 8 es posible pasar como argumento el código que es diferente y dejar uno solo con el código común:  *Parametrización del comportamiento*
- Antes de Java 8 esto se realizaba con *Clases anónimas*.
-  Esta capacidad de pasar código permite establecer un nuevo estilo de programación: *Programación funcional*.
- Al código que se pasa como argumento se le llama *función*.
 * Visto de otra forma, las funciones representan *valores* que pueden ser pasados a un método. 
 * Otras terminologías comúnmente empleadas para nombrar a estos *valores* son *first value classes*  o 



<!--stackedit_data:
eyJoaXN0b3J5IjpbMTQyMjUyNzM5NCwxODI4MTY3NzA5LC0xMz
g1NDA0NTU1LC0xNzE5ODY5MzE3LC01NjYyODc5NiwtMTI3NDQ2
NTEwOSwtMzEyMzg1OTA3LC01ODQwMzk2NTIsMTcyOTM5ODE0MC
wxOTU1MjQzOTM2LC0xOTA2NTMwNDY4LDc5NTg0MzA5MCwtOTAy
MjQ3MzIwLDQ1MDg1NjU4MiwtMTQ1NDkyMzIwMSwxODUzMDM2Nz
QxLC02NzcxMjMyNjRdfQ==
-->