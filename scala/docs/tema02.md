ok# Scala
## 2. Primeros pasos en Scala
### 2.1 El Interprete de Scala
* Sitio de descarga para instala: [Sitio oficial](http://www.scala-lang.org)
* Recomendado, instalar plugin en Eclipse o IntelliJ.
* Se puede descargar el zip que contiene los binarios.
#### 2.1.1 Primeros pasos con el interprete.
* El intérprete es un shell interactivo  en el que se pueden escribir expresiones y programas en Scala.
##### Ejemplo:
```scala
scala
Welcome to Scala 2.12.6 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_151).
Type in expressions for evaluation. Or try :help.
scala>
```
##### Ejemplo:
```scala
scala> 1+1
res0: Int = 2
scala> res0*4
res1: Int = 8
scala>
```
* El resultado de 1 +1 se asigna a una variable ```res0```que se puede emplear posteriormente. 
* Después del nombre de la variable se especifica el tipo de dato. En este caso la clase ```Int```del paquete  ```scala```, es decir, ```scala.Int```
#### 2.1.2 Definición de variables.
* Scala define 2 tipos de variables:
	* ```val```  similar a una variable ```final``` en  Java
	* ```var```  Variables que no son ``final```
##### Ejemplo:
```scala
scala> val saludo ="Hola Mundo"
saludo: String = Hola Mundo

scala> saludo ="Hola Mundo Scala"
<console>:12: error: reassignment to val
saludo ="Hola Mundo Scala"
        ^
```
* Notar que no fue necesario especificar el tipo de dato de la variable ```saludo```. Scala lo infiere:  *type inference*
* En casos donde sea necesario definir tipos de datos,  ya sea por ser requerido o por legibilidad de código se emplea la siguiente sintaxis (contraria a Java).
##### Ejemplo:
```scala
scala> val nuevoSaludo: java.lang.String = "Hola Mundo otra vez"
nuevoSaludo: String = Hola Mundo otra vez

scala> val otroSaludo: String = "Hello World again!"
otroSaludo: String = Hello World again!
```
* Instrucciones en varias líneas:
##### Ejemplo:
```scala
scala> var mensajeLargo =
| "Este es un mensaje en 2 lineas "
mensajeLargo: String = "Este es un mensaje en 2 lineas "

scala> print(
| mensajeLargo)
Este es un mensaje en 2 lineas
scala>
```
* Al presionar ```Enter``` en la primera línea, el intérprete automáticamente detecta que la instrucción está incompleta y responde con un pipe ```|```.
* Lo anterior significa que la instrucción se puede completar en la siguiente línea.
* Para cancelar la edición de una siguiente línea se vuelve a presionar ```Enter```.
####2.

<!--stackedit_data:
eyJoaXN0b3J5IjpbMTUyMjQ3NDU2MywtMTYyNDk2NDc4NiwxND
cyMDM4MDA5LDM0NzU3NjI5MywtNjg5NjIwMzkwXX0=
-->