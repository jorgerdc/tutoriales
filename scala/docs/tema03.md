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
