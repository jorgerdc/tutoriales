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
#### 2.1.3  definición de funciones.
* Función que compara 2 números y regresa el valor mayor o igual.
```scala
scala> def max(a: Int, b: Int): Int ={
	       if(a > b) a
	       else b
	    }
max: (a: Int, b: Int)Int
scala>
```
* La definición de funciones inicia con ```def```
* Notar que  los parámetros incluyen su tipo de dato.   La declaración de parámetros en Scala requiere especificar el tipo de dato!
* Posteriormente se indica ```: Int``` que corresponde al tipo de dato de retorno que en Scala se le conoce como *result type*.  
* Notar el uso del signo ```=``` antes de la definición o cuerpo de la función, resalta el estilo de programación funcional.
* El tipo de dato del valor de retorno es obligatorio si la función es recursiva. Se recomienda especificarlo siempre por legibilidad.
##### Ejemplo:
```scala
scala> def max(a: Int, b: Int) = {
		 if( a > b ) a
		 else b
	 }
max: (a: Int, b: Int)Int
scala>
```
* En forma más corta:
```scala
scala> def max(a: Int, b: Int) = if ( a > b ) a else b
max: (a: Int, b: Int)Int
```
* Invocando a la función:
```scala
scala> max(-20,19)
res4: Int = 19
```
* Función sin parámetros y sin valor de retorno.
```scala
scala> def saluda() = println("Saludando desde función")
saluda: ()Unit

scala> saluda()
Saludando desde función
```
* Observar que el intérprete regresa ```Unit``` como tipo de dato de retorno, el cual corresponde a ```void```en Java.
* Para salir del intérprete:
```scala
scala> :quit
```
* O de forma alternativa: ```:q```
#### 2.1.4 Scripts en Scala
* Scripts en Scala son representados por archivos de texto con instrucciones que se ejecutan de forma secuencial. 
##### Ejemplo:
* Suponer el contenido del siguiente archivo ```saludo.scala```
```scala
/*
 * script: saludo.scala
 * saludando con argumentos
 */
println("Hola mundo "+ args(0) +" desde script ")
```
* Ejecución del script:
```bash
scala saludo.scala Jorge

Hola mundo Jorge desde script
```
* Observar el uso de parámetros.  En Scala se emplea ```arg(n)``` en lugar de ```arg[n]``` como en Java.
#### 2.1.5 Sentencias de control
* En Scala ```++i```o ```i++```no funciona.  Se debe emplear por ejemplo, ```i=i+1```
* Imprimiendo los argumentos de entrada,  versión imperativa:
```scala
/*
 * script: while-imperativo.scala
 * Imprimineodo argumentos con while
 */
var i = 0
while(i < args.length){
	if(i!=0){
		print(" ")
	}
	print(args(i))
	i = i +1
}
println()
```
* Imprimiendo argumentos de entrada,  estilo funcional:
```scala
/*
 * script: foreach.scala
 * Imprimiendo argumentos estilo funcional
 */
args.foreach(arg => print(" " + arg))
println()
```
* La función ```foreach```recibe una *función literal*  que a su vez recibe un argumento ```arg```
* Si se desea especificar el tipo de dato:
```scala
args.foreach((arg: String) => print(" " + arg))
println()
```
* Observar los paréntesis , requeridos.
* En Scala si una función literal recibe un solo argumento, se puede omitir tanto en nombre  como si tipo de dato.
```scala
args.foreach(println)
println()
```
* En este caso la función ```println```recibe como argumento, a cada valor del arreglo ```args```
* A este tipo de sintaxis se le conoce como *partially applied function* 
* Ejemplo con ```for```  Más adelante se explica a detalle.
```scala

```
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTc3Mjk3MTE5NiwxMDQ4NDAwNDkyLC0xMT
YzNTkyNjAyLDI3MTAyMzUxLC03MjgwNDQyNTIsMTE4MjkxMjY3
NywtMTc2MzExNzUxOCw2NDkxNTIxNTYsLTU2NjY0ODQ5NywtMT
c3MDMzMzc3MSwtMTUzODAxNTQ0OCwxMzM4NDQ2MiwxNDU5MzQ4
NzA0LC0zODk0MTE3NCwtMzI1MjUxMzY1LC0xMTkzNjc0MDYxLD
c4NTU4ODA4Nyw4NDEyMjIwMzQsMTY0MTUwMTc1MCwxNzQxNzU4
NzA3XX0=
-->