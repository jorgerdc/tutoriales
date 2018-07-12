## 3. Siguientes pasos en Scala
### 3.1 Parametrizando arreglos con tipos
* En Scala parametrización significa  *configurar* una instancia  cuando esta es creada. 
* La instancia se parametriza pasándole valores al constructor .
##### Ejemplo.
```scala
scala> val saludos = new Array[String](3)
saludos: Array[String] = Array(null, null, null)
scala> saludos(0)="Hola"
scala> saludos(1)=", "
scala> saludos(2)="mundo"
scala> for(i <- 0 to 2) print(saludos(i))
Hola, mundo
scala>
```
* En este ejemplo, el tipo de dato es ```Array[String]```y recibe el valor 3 en su constructor: ```(3)```
* En el for observar la expresión  ```0 to 2```  En Scala en realidad se está invocando el método ```to```de la clase ```Int```y se le pasa como parámetro el valor 2. Es decir:
 ```scala
 (0).to(2)
 ``` 
 * El método ```to```regresa una colección que representa la secuencia de valores  0,1,2.
 ##### Ejemplo.
 ```scala
 scala> for(i <- (0).to(2)) print(" hola " + i)

hola 0 hola 1 hola 2
 ```
 * Existe otra regla general en Scala: Si el método recibe un solo parámetro, al invocarlo se puede omitir los paréntesis  y el punto. De tal forma que la expresión sin paréntesis y el punto quedará ```0 to 2``` 
 ##### Ejemplo.
 ```scala
 scala> (1).+(2)
res8: Int = 3
 ```
 * En este ejemplo, se invoca al método ```+```
 
 ¿Por qué en Scala se emplean ( )  para acceder a los elementos?
 * Existe una regla general más.  En Scala  se aplica una transformación a una llamada a un método cuando un valor se pone entre ().  El método a invocar depende del tipo de objeto.
##### Ejemplo.
```scala
scala> val miArreglo = new Array[Int](3)
miArreglo: Array[Int] = Array(0, 0, 0)
scala> miArreglo(0) = 1
scala> print(miArreglo(0))
1
scala> print(miArreglo.apply(0))
1
scala>
```
* En el ejemplo, se emplea la expresión ```miArreglo(0)```para acceder al primer elemento del arreglo.
* Debido a que el '0' está entre (),  se aplica la transformación  a ```miArreglo.apply(0)```. La idea es simplemente invocar métodos de un objeto sin importar si son arreglos o no.
##### Ejemplo.
```scala
scala> miArreglo(0)=1
scala> miArreglo.update(0,2)
scala> print(miArreglo.apply(0))
2
scala>
```
* En este ejemplo, primero se asigna el valor 1 al elemento 0 del arreglo.
* En la segunda línea se asigna el valor 2 al elemento 0, pero empleando la transformación. En este caso se emplea el método ```update```
* Finalmente se imprime el primer elemento empleado la transformación a través del método ```apply```
* Forma concisa de declarar un arreglo:
```scala
scala> val myArray = Array("uno","dos","tres")
myArray: Array[String] = Array(uno, dos, tres)
```
### 3.2 Uso de listas
* En Scala las listas son objetos inmutables. En Java son mutables.
* Recordando, el uso de objetos inmutables ofrecen beneficios como confiabilidad, reusabilidad, y en especial, principio fundamental de la programación funcional.
```scala
scala> val list3 = List(1,2,3)
list3: List[Int] = List(1, 2, 3)
```
* En Scala existe un método llamado ```:::``` empleado para concatenar listas:
##### Ejemplo:
```scala
scala> val list2 = List(1,2)
list2: List[Int] = List(1, 2)

scala> val list3 = List(3,4,5)
list3: List[Int] = List(3, 4, 5)

scala> val list5 = list2 ::: list3
list5: List[Int] = List(1, 2, 3, 4, 5)

scala> print(list2)
List(1, 2)

scala> print(list3)
List(3, 4, 5)
```
* Observar el uso del operador ```:::```para crear el objeto ```lista5``` el cual genera una nueva lista con los 5 elementos.
* Observar que al imprimir las listas originales, esas no son afectadas.
* Existe un método más  llamado ```::``` y se pronuncia *cons*.
* Se emplea para agregar un elemento al inicio de una lista. 
	* Se prefiere agregarlo al inicio y no al final principalmente por desempeño.
 ##### Ejemplo:
 ```scala
 scala> val lista2 = List(5,6)
lista2: List[Int] = List(5, 6)

scala> val lista3 = 7 :: lista2
lista3: List[Int] = List(7, 5, 6)
 ```
 * Observar la expresión ```7 :: lista2 ```
 * Aparentemente, se está invocando al método ```::``` a partir del objeto ```7``` ,  ¡ esto no es así !
 * En realidad, se  invoca al método ```::```a partir del objeto ```lista2```(lado derecho), es decir:
 ```scala
 scala> val lista2 = List(5,6)
lista2: List[Int] = List(5, 6)

scala> val lista3 = lista2.::(8)
lista3: List[Int] = List(8, 5, 6)
 ```
 * De lo anterior se desprende la siguiente regla:
 ##### Regla:
 * *Si el nombre del método termina con 2 puntos ```:``` ,  el método es invocado a partir del objeto del lado derecho*.
 * Observar el siguiente ejemplo:
 ```scala
scala> val lista3 = 1 :: 2 :: 3 :: Nil
lista3: List[Int] = List(1, 2, 3)
 ```
* En el ejemplo se agregan 3 elementos a una nueva lista.  El último elemento ```Nil``` representa una lista vacía por lo que solo se agregan los primeros 3 elementos.
```scala
scala> //crea una lista vacia
scala> val listVacia = List()
listVacia: List[Nothing] = List()

scala> // otra forma
scala> val listaVacia = Nil
listaVacia: scala.collection.immutable.Nil.type = List()

scala> val lista3 = List(1,2,3)
lista3: List[Int] = List(1, 2, 3)

scala> // obtiene el segundo elemento
scala> lista3(2)
res2: Int = 3

scala> //cuenta los elementos que sean mayores a 2
scala> lista3.count(e=> e > 2)
res3: Int = 1

scala> //genera una nueva lista sin los 2 primeros elementos de la original
scala> lista3.drop(2)
res5: List[Int] = List(3)

scala> //genera una nueva lista quitando los 2 ultimos elementos
scala> lista3.dropRight(2)
res7: List[Int] = List(1)

scala> //verifica si existe el valor 2 en la lista
scala> lista3.exists(s => s == 2)
res12: Boolean = true

scala> //Obtiene elementos que complen con el predicado
scala> lista3.filter(e => e == 1 || e == 2)
res13: List[Int] = List(1, 2)

scala> //foreach
scala> lista3.foreach(println)
1
2
3
scala> //regresa todos los elementos excepto el ultimo
scala> lista3.init
res15: List[Int] = List(1, 2)

scala> //otros metodos isEmpty, last, length, head se describen por si solos.

scala> //regresa una lista sumando uno a cada elemento
scala> lista3.map(e => e+1)
res17: List[Int] = List(2, 3, 4)

scala> lista3.reverse
res19: List[Int] = List(3, 2, 1)
```
### 3.3 Uso de tuplas.
* Representa a otro contenedor de datos.
* Similar a un ```List```, es un objeto inmutable. 
* La diferencia es que una tupla puede contener objetos con diferente tipo de dato. 
* Utiles cuando un método desea regresar múltiples objetos de tipos de datos diferentes.  Por ejemplo,  en Java, si un  método regresa los datos de un cliente,  típicamente se crea un Java Bean para representar a todos los datos: nombre, edad, etc.
* En Scala se pueden emplear tuplas.
##### Ejemplo:
```scala 
scala> val estudiante = ("Juan","Lopez",7,8.9,new java.util.Date())
estudiante: (String, String, Int, Double, java.util.Date) = (Juan,Lopez,7,8.9,Sun Jul 08 20:01:17 CDT 2018)
```
* El tipo de dato de este objeto depende del número de elementos de la tupla.
* En este ejemplo, el tipo de dato es ```Tuple5```ya que la tupla tiene 5 elementos.
* Scala soporta hasta 22.
* Para acceder a los elementos de la tupla se emplea la notación ```._n```donde ```n```es en número de elemento iniciando en 1.
##### Ejemplo:
```scala
scala> estudiante._2
res23: String = Lopez

scala> estudiante._1
res24: String = Juan

scala> estudiante._3
res26: Int = 7
```
* ¿Cuál es el significado del operador ```._n``` ?
* El punto tiene el mismo significado: empleado para invocar a un método del objeto ```estudiante```.  Es decir,  se está invocando al método que tiene como nombre ```_n```  para acceder  a cada elemento.
* En el primer ejemplo se invoca al método ```_2``` que regresa un objeto de tipo ```String```.
*  En el tercer ejemplo, se invoca al método ```_3``` que regresa un objeto de tipo ```Int```
* En resumen, se invoca un método distinto por cada elemento de la tupla debido a que esta contiene objetos de distinto tipo. 
* Por esta razón no es posible usar la misma notación que una lista para obtener sus elementos, es decir: ```estudiante(1)``` no funcionaría. ¿ por qué?
* Recordando de secciones anteriores, ```estudiante(1)``` es equivalente a ```estudiante.apply(1)``` .  El método ```apply```solo puede regresar un tipo de dato,  y por lo tanto no podría emplearse en tuplas.
* Finalmente, se inicia en 1 en lugar de en 0 por tradición y compatibilidad con otros lenguajes como Haskell y ML.
### 3.4 Uso de Sets
* Scala ofrece soporte para Sets  tanto para implementaciones inmutables como para implementaciones Inmutables .  Observar la siguiente Jerarquía:
*
![enter image description here](https://lh3.googleusercontent.com/Zxff_n3OhRN3Cffh7xon_rFjt2J8NhUuZWWXiyYtNyF0WBfBmfrj_s_YUDE0x9l-yhhkLUco6tyW "Scala collection hierarchy") 

* Por default se crea una colección inmutable.
##### Ejemplo:
```scala
scala> var set1 = Set("one","two")
set1: scala.collection.immutable.Set[String] = Set(one, two)

scala> set1 += "three"
scala> print(set1)
Set(one, two, three)
```
* Observar el uso de ```var```en lugar de ```val```
* Observar el uso del  método ```+=``` , regresa una nueva colección con los 3 elementos. Se requiere el uso de ```var```ya que se trata de un nuevo objeto.
* En el siguiente ejemplo se muestra el mismo código , pero con una colección mutable. 
```scala
scala> import scala.collection.mutable
import scala.collection.mutable

scala> val set1 = mutable.Set("one","two")
set1: scala.collection.mutable.Set[String] = Set(two, one)

scala> set1 += "three"
res14: set1.type = Set(three, two, one)

scala> print(set1)
Set(three, two, one)
```
* Observar el uso de ```val```en lugar de ```var```.
* A pesar de realizar una reasignación con ```+=```no  existe error ya  que el objeto es el mismo.
* Observar que el objeto se agregó al inicio.

### 3.5 Uso de Maps
* Similar a un Set, existem implementaciones mutables e inmutables.

![enter image description here](https://lh3.googleusercontent.com/ow5zUIP3pdJc0jcLOHSQJhiEURc9wzFyKt4k1odHQL7LmgeZJH-MmXUmACJkNH9PrzedjSUdFb9y "Scala Maps")

##### Ejemplo:
```scala
scala> var myMap = Map[Int,String]()
myMap: scala.collection.immutable.Map[Int,String] = Map()

scala> myMap +=(1 -> "One")
scala> myMap +=(2 -> "two")

scala> print(myMap)
Map(1 -> One, 2 -> two)
```
* Notar que la expresión para agregar un nuevo elemento al map es equivalente a: ```myMap +=((3).-> ("three"))```
* Para acceder a un elemento del map:
```scala
scala> myMap(2)
res24: String = two
// de forma equivalente:
scala> myMap.apply(2)
res25: String = two
```
### 3.6 Algunos tips para identificar estilo funcional de programación.
1. Usar ```val```en lugar de ```var```  (Objetos inmutables)
2. Hacer uso de funciones que no tengan efectos secundarios, es decir, trabajan con los parámetros, los procesan y regresan un valor sin afectar otras cosas.
3. Verificar el uso de loops.
##### Ejemplo 1:  Estilo imperativo
```scala
def imprimeArgs(args: Array[String]): Unit = {
	var i = 0
	while(i < args.length){
		println(args(i))
		i += 1
	}
}
```
##### Ejemplo 2: Eliminando vars
```scala
def imprimeArgs(args: Array[String]): Unit = {
	for(arg <- args){
		println(arg)
	}
}
```
* Otra solución al código anterior:
```scala
def imprimeArgs(args: Array[String]): Unit = {
	args.foreach(println)
}
```
* El código anterior tiene un estilo casi funcional.
* La función ```imprimeArgs```tiene un efecto secundario ya que imprime  un mensaje a consola.
* Si se quisiera solucionar este detalle, la función ```imprimeArgs```tendría que generar la cadena completa que se va a imprimir en consola y que la regresara como valor de retorno:
```scala
def imprimeArgs(args: Array[String])  ) args.mkString("\n")
```
* En esta última versión se tiene un método completamente funcional.
* La función ```mkString```  es aplicable sobre objetos iterables. Agrega la cadena especificada en el parámetro al final de cada elemento de la colección o arreglo, que es justamente lo que se va a imprimir.
* Llevar hasta este nivel tiene varios beneficios:
	* Reusabilidad.
	* Facilidad para probar:
```scala
var cadena = imprimeArgs(Array("1","2","3"))
assert(res == "1\n2\n3")
```
* El estilo imperativo no necesariamente es malo. Se debe optar por el estilo funcional, pero en situaciones particulares se puede preferir el imperativo con su respectiva justificación.
##### Ejemplo:
* *Crear un script que lea las líneas de un archivo, imprima el contenido de la línea y el número de caracteres que contiene*.
* Versión 1
```scala
/*
 * script: tema03/leeArchivoV1.scala
 * Lectura de un archivo de texto version 1
 */
import scala.io.Source

if(args.length > 0){
	for(line <- Source.fromFile(args(0)).getLines()){
		println(line.length + " "+ line)
	}
}else{
	Console.err.println("Especificar una ruta valida de un archivo")
}
```
* Salida del programa:
```shell
67 The following are the graphical (non-control) characters defined by
66 ISO 8859-1 (1987).  Descriptions in words aren't all that helpful,
69 but they're the best we can do in text.  A graphics file illustrating
67 the character set should be available from the same archive as this
5 file.
```
* Versión 2
*Formatear el número que aparece a la izquierda seguido de un " | " de tal forma que el contenido del archivo inicie en la misma columna*:
```shell
67 | The following are the graphical (non-control) characters defined by
66 | ISO 8859-1 (1987).  Descriptions in words aren't all that helpful,
69 | but they're the best we can do in text.  A graphics file illustrating
67 | the character set should be available from the same archive as this
5  | file.
```
* La solución se muestra a continuación:
```scala {.line-numbers}
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
```
* En este ejemplo se hace uso de un estilo funcional.
* En la función ```getLongitudNumeroLinea``` obtiene la longitud de la cadena que representa al número de línea. Esto con la finalidad de determinar el número máximo de espacios necesarios para justificar a la izquierda.
* Se crea una lista con el contenido de las líneas del archivo llamada ```lineas```.
* Observar el uso de ```reduceLeft```  . En esta función se comparan los elementos de la lista, en este caso las longitudes de cada línea del archivo.  En la primera iteración se comparan las líneas 1 y 2. La función que se pasa como parámetro elige a una de ellas ( la que tiene la mayor longitud) la cual será comparada con la siguiente, es decir, la línea 3. 
* El uso de ```reduceLeft``` permite obtener la línea con la  mayor longitud  evitando el uso de ```var```en un estilo imperativo:
```scala
var maxLongitud = 0
for(line <- lineas)
	maxLongitud = maxLongitud.max(getLongitudNumeroLinea(linea))
```
* Finalmente en el ciclo for se calcula el número exacto de espacios que se deben imprimir para justificar correctamente.    Observar la siguiente expresión:
```scala
val padding = " " * numEspacios
```
* ¡El caracter espacio es multiplicado N veces! , ¡se obtiene una cadena de N espacios!
