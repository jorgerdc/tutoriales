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
### 3.4 Uso de Sets y Maps
* Scala ofrece soporte para Sets y Maps  tanto para inmutable como para Inmutable implementaciones.  Observar la siguiente Jerarquía:
![enter image description here](https://lh3.googleusercontent.com/Zxff_n3OhRN3Cffh7xon_rFjt2J8NhUuZWWXiyYtNyF0WBfBmfrj_s_YUDE0x9l-yhhkLUco6tyW "Scala collection hierarchy") 
