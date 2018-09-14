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

Lambdas
 *  Streams
 * Programación funcional
 * Pasar código como parámetro a un método.
### 1.2 Parametrización del comportamiento.
- Suponer 2 métodos con código similar.
- Solo algunas líneas son diferentes.
- En Java 8 es posible pasar como argumento el código que es diferente y dejar uno solo con el código común:  *Parametrización del comportamiento*
- Antes de Java 8 esto se realizaba con *Clases anónimas*.
-  Esta capacidad de pasar código permite establecer un nuevo estilo de programación: *Programación funcional*.
- Al código que se pasa como argumento se le llama *función*.
 ### 1.3 Stream processing 
 * Stream: Secuencia de elementos (datos) que son leídos por programas de forma secuencial.
 * El resultado del procesamiento de estos elementos puede ser escrito a otro Stream: *Output Stream*  
 #####  Ejemplo:
```bash
cat archivo1 archivo2 | tr “[A-Z]” “[a z]” | sort | tail -3
```
* El comando ```cat``` crea el stream de datos concatenando el contenido de ambos archivos.
* El comando ```tr```  realiza la transformación de mayúsculas a minúsculas
* El comando ``sort`` realiza el ordenamiento de los registros, recibe un Stream de entrada y produce otro.
* El comando ```tail```obtiene las últimas 3 líneas del Stream de salida.
* Los comandos ```cat``` , ```sort``` y ```tail``` pueden ser ejecutados de forma paralela, es decir, ```sort``` se puede ejecutar antes que ```tr``` o ```cat``` terminen.



<!--stackedit_data:
eyJoaXN0b3J5IjpbLTMxMjM4NTkwNywtNTg0MDM5NjUyLDE3Mj
kzOTgxNDAsMTk1NTI0MzkzNiwtMTkwNjUzMDQ2OCw3OTU4NDMw
OTAsLTkwMjI0NzMyMCw0NTA4NTY1ODIsLTE0NTQ5MjMyMDEsMT
g1MzAzNjc0MSwtNjc3MTIzMjY0XX0=
-->