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

	System.out.println("3. Lee todas las lineas en mayusculas");
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
* Observar que en cada caso, solo se envía la ruta del archivo y una expresión lambda que contiene la lógica a ejecutar. La  expresión lambda  implementa funcionalmente a la interface `ReaderProcessor`.
* Notar que en las expresiones no se especifica el tipo de dato del parámetro ```reader``` . El compilador infiere su tipo de dato com base al contexto de la expresión.  En este caso, el segundo parámetro del método ```processFile```recibe un objeto ```ReaderProcessor``` y a partir de el, el compilador infiere el tipo de dato.
### Principales Interfaces Funcionales 
* Se encuentran en el paquete ```java.util.function```

|Interface               | descriptor funcional |
|------------------------|-----------------------|
|```Predicate<T>```      |```T -> boolean```     |
|```Consumer<T>```       |```T -> void```        |
|```Function<T,R>```     |```T -> R```      |
|```Supplier<T>```      |``` () -> T```      |
|```UnaryOperator<T>``` |``` T -> T```      |
|```BinaryOperator<T,T>``` |``` (T,T) -> T```      |
|```BiPredicate<L,R>```      |```(L,R) -> boolean```     |
|```BiConsumer<T,U>```       |```(T,U) -> void```        |
 |```BiFunction<T,U,R>```     |```(T,U) -> R```      |
* Adicional a estas interfaces,  existen sus correspondientes especializaciones que hacen uso de primitivos para evitar autoboxing (mejorar desempeño).  Por ejemplo: ```IntPredicate, LongPredicate, IntConsumer```, etc.

### Manejo de excepciones 
* Ninguno de los descriptores funcionales (métodos) de las interfaces funcionales del API de java contienen la cláusula ```throws```
* Lo anterior significa que si el código de la expresión lambda lanza una *checked exception* , se tienen 2 mecanismos para manejarla:
	* Emplear un  bloque ```try - catch ```
	* Crear interfaces funcionales  personalizadas y agregar la cláusula ```throws```
* El el ejemplo anterior,  la interface funcional  ```ReaderProcessor```   se incluye esta cláusula, y por lo tanto el código de la  expresión lambda no requiere un manejo explícito de ```IOException```.
```Java
@FunctionalInterface
public interface ReaderProcessor {
	String procesa(BufferedReader reader) throws IOException;
}
``` 
### Uso de variables locales en expresiones lambda.
* Aplican las mismas reglas que una clase anónima.
* El cuerpo de una expresión lambda puede hacer referencia a una variable que está definida fuera de ella. A este tipo de expresiones lambda se les llama  *capturing lambdas* 
```Java
int x =0;
Runnable r = () -> System.out.print(x);
```
* Existe una restricción a lo anterior.  Las variables deben ser:
	* Declaradas como final
	* Ser efectivamente finales.
* El siguiente código no compilaría al agregar la tercer línea:
```Java
int x =0;
Runnable r = () -> System.out.print(x);
x=10;
```
* Esta restricción se debe a lo siguiente:
	* Las variables locales se guardan en el stack. 
	* Suponer que la expresión lambda se ejecuta en otro thread (T2) diferente al thread que creó la variable (T1).
	* Si T1  muere debido a que terminó la ejecución del método, la variable ya no estaría disponible dentro de la expresión lambda y por lo tanto no se podría emplear.
	* Para resolver esto, se hace una copia de la variable para emplearse dentro de la expresión.
	* Para evitar inconsistencias con el valor original,  se restringe que la variable sea modificada (final  o effectively final).
	### Referencias a métodos.
* Este mecanismo permite hacer uso de definiciones de métodos existentes como expresiones lambda.
* En algunas ocasiones su uso permite obtener un código más entendible que con el uso de una expresión lambda.
* Referencias a métodos permiten crear expresiones lambda.
* Se emplea el operador ::  para hacer referencia a un método.
#####Ejemplos:

|Expresión lambda              | Equivalente como referencia a método |
|------------------------      |-----------------------|
|```(str,i) -> str.substring(i)```  |```String::substring```     |
|```(String s) -> System.out.print(s)```  |```System.out::print```     |

#### Tipos de referencias a métodos.
* Referencia a métodos de clase (estáticos)
	* Ejemplo: ```Integer::parseInt```
* Referencias a métodos de instancia
	* Ejemplo: ```String::substring```
	* Ejemplo: ```String::new``` Referencia al constructor.
* Referencias  a un método a partir de un objeto
	* Ejemplo: Suponer la existencia de la variable ``curso`` , la referencia será ```curso::getNombre```
##### Ejemplo:
```Java
List<String> lista;
lista = Arrays.asList("M", "j", "x", "0", "a");
lista.sort(String::compareToIgnoreCase);
System.out.println(lista);
```
* Observar la referencia al método ```compareToIgnoreCase```su firma coincide con la firma de la interface funcional  ```Comparable```, por lo tanto puede emplearse como expresión lambda  y ser enviada como parámetro del método ```sort```.

##### Ejemplo:
```Java
// sin referencia a métodos
Supplier<String> supplier = () -> "hola";
System.out.println("s1: " + supplier.get());

// con referencia a métodos
supplier = String::new;
System.out.println("s2: " + supplier.get());
```
* En este ejemplo se hace una referencia al constructor de la clase  ```String``` el cual es compatible con la expresión lambda que define a  la interface  ```Supplier```,  es decir: ```() -> T```
##### Ejemplo.
```Java 
// sin referencia a metodos
Function<String, File> fx1 = (path) -> new File(path);
File myFile = fx1.apply("/tmp/noexiste.txt");
System.out.println(myFile.getAbsolutePath());

// con referencia a metodos
fx1 = File::new;
myFile = fx1.apply("/tmp/noexiste.txt");
System.out.println(myFile.getAbsolutePath());
```
* En este ejemplo, se  usa la interface ```Function```que recibe un  ```String``` y regresa un objeto ```java.io.File```
* La expresión lambda crea un objeto ```File```empleando el constructor que acepta un ```String```.  La expresión es ejecutada al invocar al método ```apply```.
* En la segunda parte , se obtiene el mismo resultado haciendo referencia al constructor de la clase ```File```que recibe un ```String```como parámetro.

### Métodos de utilería en  Interfaces funcionales.
* Son implementaciones por default definidas en una interface funcional.
* Permiten crear expresiones lambda  a partir de otras, algunas de ellas más complejas que la original.
#### Creando comparadores
* Método ```Comparator.comparing```
```Java
static <T,U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T,? extends U> keyExtractor)
```
* Acepta una función y regresa un objeto ```Comparable<T>```. Dicho objeto se crea  extrayendo  el objeto que regresa la función tipo ```U``` mismo que será empleado como llave para realizar la comparación.
##### Ejemplo:
```Java
List<Curso> courseList;
courseList = Arrays.asList(
	new Curso("Spring Framework", 230),
	new Curso("Java 8", 130),new Curso("Angular", 50), 
	new Curso("Zeppelin apache", 230));
System.out.println("sorting courses using it's name:");
courseList.sort(comparing(c -> c.getNombre()));
System.out.println(courseList);
```
* En el ejemplo anterior, el método ```comparing``` construye un objeto ```Comparable<Curso>``` Se ha importado de forma estática: ```import static java.util.Comparator.comparing;```
* Dicho método acepta una expresión lambda ```Function<Curso,String>```
* La función regresa un ```String```, en este caso, el nombre del curso que será empleado como criterio de ordenamiento (sort key).  
##### Ejemplo
```Java
System.out.println("sorting by name, then by price");
courseList.sort(comparing(Curso::getNombre).thenComparing(Curso::getCosto).reversed());
System.out.println(courseList);
```
* En este ejemplo, se hace un ordenamiento por nombre, después por el costo, y después en orden inverso.

test 
<!--stackedit_data:
eyJoaXN0b3J5IjpbNjM1MzI2MzA5LC0xNDQxMzkwMTcyLC0xNT
IwNTEwMjg0LDMxNzk2NTUzOCwtMjk1NTE0OTQ0LDExODU3NzQ0
MzcsMjEzOTgzMDg3MywtNjYxOTYwOTI3LDE3MjcxMjE3MjMsLT
M0MDk2MTU1MywtMTg0Mjk1OTQ0OSwtNjg0NTQ1NDg2LDk4MzAz
OTYyMSwxNjYwODk5NDQwLC05Njk1MjQ5NzEsLTEzMzExOTE3OT
IsMTQwOTk0NjIwNSwtMzc4OTQ5LC0xNzQwNTkwNDQyLDMxNDEy
MTQ2MV19
-->