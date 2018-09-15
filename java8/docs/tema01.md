# Java 8
## 1. Introducción
### 1.1 Principales características de Java 8
* Java 8  lanzada en marzo del 2014 representa  a la versión con la mayor cantidad de cambios a fondo que se haya tenido desde el lanzamiento del JDK 1.0 en 1996.
* Uno de los principales objetivos de estos cambios es la posibilidad de escribir código más simple y conciso, evitando código repetitivo, verboso.
#####  Ejemplo:
* El código completo de este capítulo se encuentra dentro del paquete ```modulo1``` .
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
* Suponer 2 métodos con código similar.
* Solo algunas líneas son diferentes.
* En Java 8 es posible pasar como argumento el código que es diferente y dejar uno solo con el código común:  *Parametrización del comportamiento*
* Antes de Java 8 esto se realizaba con *Clases anónimas*.
*  Esta capacidad de pasar código permite establecer un nuevo estilo de programación: *Programación funcional*.
* Al código que se pasa como argumento se le llama *función*.
* Visto de otra forma, las funciones representan *valores* que pueden ser pasados a un método. 
* Otras terminologías comúnmente empleadas para nombrar a estos *valores* son *first class values*  o *first value citizens*.
#### 1.2.1 Method References
* Una de las  aplicaciones del uso de funciones como valores son las referencias a métodos.
##### Ejemplo:
* Suponer que se desea crear un programa que haga el filtrado de los archivos que se encuentran en un directorio. El programa debe mostrar a todos los archivos que son ocultos.  Antes de Java 8 se tendría el siguiente código:
```java
/**
 * Shows hidden files using imperative programming style.
 */
private static void showHiddenFilesJava7() {
	File[] hiddenFiles;

	System.out.println("Showing hidden files before Java8. Verbose..");
	hiddenFiles =
		new File(System.getProperty("java.io.tmpdir")).listFiles(new FileFilter() {
			@Override
			public boolean accept(File f) {
				return f.isHidden();
			}
		});
	for (File file : hiddenFiles) {
		System.out.println(file.getAbsolutePath());
	}
}
```
* En Java 8 el código será:
```java
/**
 * Shows hidden files using lambda expressions and method references.
 */
private static void showHiddendFilesJava8() {
	List<File> files;
	String tmpDir;

	tmpDir = System.getProperty("java.io.tmpdir");
	System.out.println("Showing hidden files with Java8 :");

	// new in Java 8
	files = Arrays.asList(new File(tmpDir).listFiles(File::isHidden));
	// new in Java 8
	files.forEach(System.out::println);

}
```
* Observar el paso de una referencia de un método empleando la sintaxis ```File::isHidden```y  ```System.out::println``` , reduce considerablemente las líneas de código haciéndolo más entendible.
* Estos conceptos se revisarán más adelante.
#### 1.2.2 Expresiones Lambda.
* Otra forma de considerar a las funciones como valores es  a través del concepto de *expresión lambda* llamadas también *funciones anónimas*.
* Este último nombre se deriva debido a que una expresión lambda representa a la definición de un método pero sin su nombre:
##### Ejemplo:
```java
(int x) -> x + 1
```
* La parte izquierda de la expresión representa a la lista de parámetros del método pero sin su nombre.
* Se lee de la siguiente manera:  "La función que, cuando  sea invocada  con un argumento tipo ```int``` regresará el valor ```x+1```.
* Las expresiones lambda son convenientes en especial cuando no existe un método que implemente cierta funcionalidad. La definición del dicho método se representa por una expresión lambda resultando en un código conciso y entendible.
##### Ejemplo:
* Suponer que se tiene el siguiente requerimiento:  Crear un programa que reciba  una lista de objetos tipo ```Course```. Se requiere escribir funcionalidad para obtener una lista de cursos que cumplan con ciertos criterios: Filtrar cursos por nombre, o por precio máximo.  Una solución a esto es crear los siguientes métodos:
```java
public static List<Course> getCoursesByName(List<Course> courses, String courseName) {
	List<Course> javaCourses = new ArrayList<>();
	for (Course course : courses) {
		if (course.getName().toLowerCase().contains(courseName)) {
			javaCourses.add(course);
		}
	}
	return javaCourses;
}
```
* Para filtrar por precio máximo:
```java
public static List<Course> getCoursesByMaxPrice(List<Course> courses,
	double maxPrice) {
	List<Course> javaCourses = new ArrayList<>();
	for (Course course : courses) {
		if (course.getPrice() <= maxPrice) {
			javaCourses.add(course);
		}
	}
	return javaCourses;
}
```
* Observar que estos 2 métodos presentan código repetitivo: iterar  sobre la lista, agregar los elementos a la lista de resultado. Si se requieren más criterios de búsqueda, más copy & paste !.
* En Java 8 se puede realizar el siguiente refactor: 
	* En los 2 ejemplos anteriores, existen unas cuantas líneas de código que son diferentes y que corresponden a los criterios de cada filtro.  Dichas líneas se pueden extraer del código y ser parametrizadas a través de una *función* !
##### Refactor 1:
```java
public static List<Course> filterCourses(List<Course> courses, Predicate<Course> p) {

	List<Course> filteredCourses = new ArrayList<>();
	for (Course c : courses) {
		if (p.test(c)) {
			filteredCourses.add(c);
		}
	}
	return filteredCourses;
}
```
* Observar el uso de la función ```java.util.function.Predicate```	 empleada como parámetro y cuyo valor contendrá al código que será ejecutado para aplicarse como filtro a la lista de cursos!.
* El código de esta interface (llamada funcional) es:
```java
public interface Predicate<T> {
	boolean test(T t);
}
```
* Debido a que todas las implementaciones de la interface definen al método ```test```, este será invocado para aplicar diferentes criterios para filtrar cursos.
* Para invocar al método ```filterCourses``` en Java 8 se pueden escribir  las siguientes expresiones lambda:
##### Refactor 2
```java
List<Course> courses, cursosJava, cheapCourses;
courses = asList(new Course("Java", 8500), new Course("WebServices", 18500));
javaCourses = filterCourses(
	courses, c -> c.getName().toLowerCase().contains("java")
);
cheapCourses = filterCourses(
	courses, (Course c) -> c.getPrice() <= 10000
);
```
* En este ejemplo se tienen 2 expresiones lambda:
```java
	courses, c -> c.getName().toLowerCase().contains("java")
```
* La segunda es:
```java
	courses, (Course c) -> c.getPrice() <= 10000
```
* Estas expresiones representan la idea del concepto de  *parametrizar el comportamiento*.
* Notar que ambas expresiones cumplen con la definición del método ``test``de la función ```Predicate``` y por lo tanto pueden ser empleadas como parámetro del método ```filterCourses```. Las condiciones son:   
	* Un método que reciba un objeto ```T```, en este caso, un objeto ```Course```
	* Debe regresar un ```boolean```
* Una mejora del refactor anterior es  la posibilidad de eliminar al método ```filterCourses```!.  Esto es posible con el uso del API de Streams:
##### Refactor 3
```java
List<Course> courses, javaCourses, cheapCourses;
courses = asList(new Course("Java", 8500), new Course("WebServices", 18500));

javaCourses = courses.stream().filter(
	c -> c.getName().toLowerCase().contains("java")
).collect(Collectors.toList());

cheapCourses = courses.stream().filter(
	(Course c) -> c.getPrice() <= 10000
).collect(Collectors.toList());
```
* Las colecciones definen un nuevo método llamado ```stream``` que construye un objeto ```Stream```  el cual es accedido a través del método ```filter``` que pertenece al API de Streams. 
* Con esta técnica, se elimina la necesidad de iterar sobre la lista de cursos !  El API de Streams lo hace internamente y con la posibilidad de aplicar paralelismo!
* Mas adeante se explica a detalle el uso del API de  Streams.
* Finalmente,  una forma adicional de implementar a la función ```Predicate``` es a través del concepto de referencias a métodos:
##### Refactor 4
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE2NjUzMjM5OCwtMTY0MjI0MjI0MiwtMT
gxNzY4MjcwOCwtMTc1NjM2NDQwMywxOTAxMjA1NzkyLDE4MjI4
NjExNiwtMTE3NjA3NTQxNSwxMjA1NDMxOTY5LDYwMjc0ODY4Ni
wxNDQyNDEzODUxLDE4MjgxNjc3MDksLTEzODU0MDQ1NTUsLTE3
MTk4NjkzMTcsLTU2NjI4Nzk2LC0xMjc0NDY1MTA5LC0zMTIzOD
U5MDcsLTU4NDAzOTY1MiwxNzI5Mzk4MTQwLDE5NTUyNDM5MzYs
LTE5MDY1MzA0NjhdfQ==
-->